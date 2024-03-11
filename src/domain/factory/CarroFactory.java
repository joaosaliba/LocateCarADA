package domain.factory;

import domain.entities.carro.Carro;

public class CarroFactory implements EntidadeFactory<Carro> {
    @Override
    public Carro criarEntidade() {
        return new Carro();
    }
}
