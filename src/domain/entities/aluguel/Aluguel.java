package domain.entities.aluguel;

import domain.entities.Entidade;
import domain.entities.carro.Carro;
import domain.entities.pessoa.Pessoa;
import domain.entities.pessoa.PessoaFisica;
import domain.entities.pessoa.PessoaJuridica;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Aluguel implements Entidade {
    private static Long contadorIds = 1L;
    private String id;
    private String pessoa;
    private String carro;
    private LocalDateTime dthRetirada;
    private LocalDateTime dthDevolucao;

    public Aluguel() {
        this.id = getIdAndIncrement();

    }

    public Aluguel(String pessoa, String carro, LocalDateTime dthRetirada, LocalDateTime dthDevolucao) {
        this.pessoa = pessoa;
        this.carro = carro;
        this.dthRetirada = dthRetirada;
        this.dthDevolucao = dthDevolucao;
        this.id = getIdAndIncrement();

    }

    public Aluguel(String pessoa, String carro, LocalDateTime dthRetirada) {
        this.pessoa = pessoa;
        this.carro = carro;
        this.dthRetirada = dthRetirada;
        this.id = getIdAndIncrement();

    }

    private Aluguel(String id, String pessoa, String carro, LocalDateTime dthRetirada, LocalDateTime dthDevolucao) {

        this.pessoa = pessoa;
        this.carro = carro;
        this.dthRetirada = dthRetirada;
        this.dthDevolucao = dthDevolucao;
        this.id = id;

    }

    private String getIdAndIncrement() {
        contadorIds++;
        return contadorIds.toString();
    }



    @Override
    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public Long getQntDias() {
        return Duration.between( this.dthRetirada,this.dthDevolucao).toHours();
    }



    public LocalDateTime getDthRetirada() {
        return dthRetirada;
    }

    public void setDthRetirada(LocalDateTime dthRetirada) {
        this.dthRetirada = dthRetirada;
    }

    public LocalDateTime getDthDevolucao() {
        return dthDevolucao;
    }

    public void setDthDevolucao(LocalDateTime dthDevolucao) {
        this.dthDevolucao = dthDevolucao;
    }


    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    @Override
    public String toCsvString() {
        return pessoa + "," +
                carro + "," +
                id + "," +
                dthRetirada.toString() + "," +
                (Objects.nonNull(dthDevolucao) ? dthDevolucao.toString() : null) + "," ;
    }

    @Override
    public Aluguel fromCsvString(String csv) {
        String[] parts = csv.split(",");
        String pessoa = parts[0];
        String carro = parts[1];
        String id = parts[2];
        LocalDateTime dthRetirada = !"null".equals(parts[3]) ? LocalDateTime.parse(parts[3]) : null;
        LocalDateTime dthDevolucao = !"null".equals(parts[4]) ? LocalDateTime.parse(parts[4]) : null;

        return new Aluguel(id, pessoa, carro, dthRetirada, dthDevolucao);
    }


}
