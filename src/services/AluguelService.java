package services;

import database.repository.Repository;
import domain.entities.aluguel.Aluguel;

public class AluguelService {
    private Repository<Aluguel, String> repositoryImp;

    public AluguelService(Repository<Aluguel, String> repositoryImp) {
        this.repositoryImp = repositoryImp;
    }
}
