package services;

import database.repository.Repository;
import domain.entities.carro.Carro;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CarroService {
    private Repository<Carro, String> repositoryImp;

    public CarroService(Repository<Carro, String> repositoryImp) {
        this.repositoryImp = repositoryImp;
    }

    public void insert(Carro c) throws SQLException {
        Carro carro = repositoryImp.getByID(c.getId());
        if (Objects.nonNull(carro)) {
            throw new RuntimeException("Carro já cadastrado");
        }
        repositoryImp.insert(c);
    }

    public Carro findById(String placa) throws SQLException {
        Carro carro = repositoryImp.getByID(placa);
        if (Objects.isNull(carro)) {
            throw new RuntimeException("Carro não encontrado");
        }
        return carro;
    }

    public void update(Carro carro) throws SQLException {

        this.repositoryImp.update(carro);
    }


    public Set<Carro> getAll() throws SQLException {
        return  this.repositoryImp.getAll();
    }
}
