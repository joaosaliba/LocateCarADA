package domain.factory;

import domain.entities.Entidade;

public interface EntidadeFactory<T extends Entidade> {
    T criarEntidade();
}