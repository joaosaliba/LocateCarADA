package services;

import database.repository.Repository;
import domain.entities.aluguel.Aluguel;
import domain.entities.carro.Carro;
import domain.entities.pessoa.Pessoa;
import domain.entities.pessoa.PessoaFisica;
import domain.entities.pessoa.PessoaJuridica;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

public class AluguelService {
    private Repository<Aluguel, String> repositoryImp;
    private CarroService carroService;
    private PessoaService pessoaService;


    public AluguelService(Repository<Aluguel, String> repositoryAlugueisImp, CarroService carroService, PessoaService pessoaService) {
        this.repositoryImp = repositoryAlugueisImp;
        this.carroService = carroService;
        this.pessoaService = pessoaService;
    }

    public void aluguarVeiculo(String documento, String placa) throws Exception {
        Pessoa pessoa = this.pessoaService.findById(documento.trim());
        Carro carro = this.carroService.findById(placa.trim().toUpperCase());
        if(carro.getAlugado()){
            throw new Exception("Carro ja alugado");
        }
        carro.setAlugado(true);
        Aluguel aluguel = new Aluguel(pessoa.getId(), carro.getId(), LocalDateTime.now());
        this.repositoryImp.insert(aluguel);
        this.carroService.update(carro);
    }


    public BigDecimal devolverVeiculo(String placa) throws Exception {
        Carro carro = this.carroService.findById(placa.trim().toUpperCase());
        if(!carro.getAlugado()){
            throw new Exception("Carro ja devolvido");
        }
        carro.setAlugado(false);
        Optional<Aluguel> aluguel = this.repositoryImp.getAll().stream().filter(a -> a.getCarro().equals(placa)).findFirst();
        BigDecimal valorAPagar = BigDecimal.ZERO;
        if (aluguel.isPresent()) {
            Aluguel al = aluguel.get();
            Pessoa pessoa = this.pessoaService.findById(al.getPessoa());

            al.setDthDevolucao(LocalDateTime.now());
            long qntDias = al.getQntDias();
            double desconto = aplicarDesconto(pessoa, qntDias);
            valorAPagar = calcularValorTotal(carro, qntDias, desconto);
            this.repositoryImp.insert(al);
            this.carroService.update(carro);
        }
        return valorAPagar;

    }

    public BigDecimal calcularValorTotal(Carro carro, Long qntDias, Double desconto) {
        BigDecimal total = carro.getValorDiaria().multiply(BigDecimal.valueOf(qntDias));
        total = total.subtract(total.multiply(BigDecimal.valueOf(desconto)));
        return total;
    }

    public Double aplicarDesconto(Pessoa pessoa, Long qntDias) {
        if (pessoa instanceof PessoaFisica && qntDias > 5) {
            return 5.0 / 100;
        } else if (pessoa instanceof PessoaJuridica && qntDias > 3) {
            return 10.0 / 100;
        }
        return 0.0;
    }
}
