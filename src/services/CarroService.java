package services;

import database.repository.Repository;
import domain.entities.carro.Carro;

import java.sql.SQLException;
import java.util.Objects;

public class CarroService {
    private Repository<Carro, String> repositoryImp;

    public CarroService(Repository<Carro, String> repositoryImp) {
        this.repositoryImp = repositoryImp;
    }

    public void insert(Carro c) throws SQLException {
        Carro banco = repositoryImp.getByID(c.getId());
        if (Objects.nonNull(banco)) {
            throw new RuntimeException("Carro já cadastrado");
        }
        repositoryImp.insert(c);
    }
}
