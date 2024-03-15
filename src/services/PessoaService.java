package services;

import database.repository.Repository;
import domain.entities.carro.Carro;
import domain.entities.pessoa.Pessoa;
import domain.enums.TipoPessoaEnum;
import domain.factory.PessoaFactory;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Set;

public class PessoaService {
    private Repository<Pessoa, String> repositoryImp;

    public PessoaService(Repository<Pessoa, String> repositoryImp) {
        this.repositoryImp = repositoryImp;
    }

    public void insert(String documento, String nome, String tipo) throws SQLException {
        Pessoa pessoa = PessoaFactory.getInstance(TipoPessoaEnum.valueOf(tipo));
        pessoa.setCpfCnpj(documento);
        pessoa.setNome(nome);
        Pessoa banco = repositoryImp.getByID(pessoa.getId());
        if (Objects.nonNull(banco)) {
            throw new RuntimeException("Pessoa já cadastrada");
        }
        repositoryImp.insert(pessoa);

    }

    public void alterarPessoa(String documento, String nome, String tipo) throws SQLException {
        Pessoa pessoa = PessoaFactory.getInstance(TipoPessoaEnum.valueOf(tipo));
        pessoa.setCpfCnpj(documento);
        pessoa.setNome(nome);
        this.repositoryImp.update(pessoa);
    }

    public Pessoa findById(String id) throws SQLException {
        Pessoa carro = repositoryImp.getByID(id);
        if (Objects.isNull(carro)) {
            throw new RuntimeException("Pessoa não encontrado");
        }
        return carro;
    }

    public Set<Pessoa> getAll() throws SQLException {
       return this.repositoryImp.getAll();
    }
}
