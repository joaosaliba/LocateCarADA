package domain.entities.aluguel;

import domain.entities.Entidade;
import domain.entities.carro.Carro;
import domain.entities.pessoa.Pessoa;
import domain.entities.pessoa.PessoaFisica;
import domain.entities.pessoa.PessoaJuridica;

import java.time.Duration;
import java.time.LocalDateTime;

public class Aluguel implements Entidade {
    private static Long contadorIds = 1L;
    private String id;
    private Pessoa pessoa;
    private Carro carro;
    private LocalDateTime dthRetirada;
    private LocalDateTime dthDevolucao;
    private Double desconto;

    public Aluguel() {
        this.id = getIdAndIncrement();

    }

    public Aluguel(Pessoa pessoa, Carro carro, LocalDateTime dthRetirada, LocalDateTime dthDevolucao, Double desconto) {
        this.pessoa = pessoa;
        this.carro = carro;
        this.dthRetirada = dthRetirada;
        this.dthDevolucao = dthDevolucao;
        this.desconto = desconto;
        this.id = getIdAndIncrement();

    }

    private Aluguel(String id, Pessoa pessoa, Carro carro, LocalDateTime dthRetirada, LocalDateTime dthDevolucao, Double desconto) {

        this.pessoa = pessoa;
        this.carro = carro;
        this.dthRetirada = dthRetirada;
        this.dthDevolucao = dthDevolucao;
        this.desconto = desconto;
        this.id = id;

    }

    private String getIdAndIncrement() {
        contadorIds++;
        return contadorIds.toString();
    }

    public double calcularValorTotal() {
        double total = this.carro.getValorDiaria().doubleValue() * this.getQntDias();
        return total - (total * desconto / 100);
    }

    public void aplicarDesconto() {
        if (pessoa instanceof PessoaFisica && this.getQntDias() > 5) {
            desconto = 5.0;
        } else if (pessoa instanceof PessoaJuridica && this.getQntDias() > 3) {
            desconto = 10.0;
        }
    }

    @Override
    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public Long getQntDias() {
        return Duration.between(this.dthDevolucao, this.dthRetirada).toDays();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
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

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }


    @Override
    public String toCsvString() {
        return id + "," +
                pessoa.getId() + "," +
                carro.getId() + "," +
                dthRetirada.toString() + "," +
                dthDevolucao.toString() + "," +
                desconto;
    }

    @Override
    public Aluguel fromCsvString(String csv) {
        String[] parts = csv.split(",");
        String id = parts[0];
        Pessoa pessoa = new Pessoa();
        Carro carro = new Carro();
        LocalDateTime dthRetirada = LocalDateTime.parse(parts[3]);
        LocalDateTime dthDevolucao = LocalDateTime.parse(parts[4]);
        Double desconto = Double.parseDouble(parts[5]);

        return new Aluguel(id, pessoa, carro, dthRetirada, dthDevolucao, desconto);
    }


}
