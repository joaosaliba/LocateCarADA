package services;

import database.repository.Repository;
import domain.entities.pessoa.Pessoa;

import java.util.Objects;

public class PessoaService {
    private Repository<Pessoa, String> repositoryImp;

    public PessoaService(Repository<Pessoa, String> repositoryImp) {
        this.repositoryImp = repositoryImp;
    }

    public void insert(Pessoa p) throws Exception {
        Pessoa banco = repositoryImp.getByID(p.getId());
        if (Objects.nonNull(banco)) {
            throw new RuntimeException("Pessoa já cadastrada");
        }
        repositoryImp.insert(p);

    }
}
