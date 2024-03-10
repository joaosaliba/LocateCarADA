package domain.factory;

import domain.entities.aluguel.Aluguel;

public class AluguelFactory implements  EntidadeFactory<Aluguel> {
    @Override
    public Aluguel criarEntidade() {
        return new Aluguel();
    }
}
