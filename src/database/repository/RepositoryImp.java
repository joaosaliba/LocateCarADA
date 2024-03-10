package database.repository;

import domain.entities.Entidade;

import java.sql.SQLException;
import java.util.List;

public class RepositoryImp<T extends Entidade,K> implements Repository<T,K> {

    protected List<T> list;

    public RepositoryImp(List<T> list) {
        this.list = list;
    }

    @Override
    public void insert(T entity) throws SQLException {
        this.list.add(entity);
    }

    @Override
    public void removeById(K entityID) throws SQLException {
        this.list.removeIf(a-> a.getId().equals(entityID.toString()));
    }

    @Override
    public T getByID(K entityID) throws SQLException {
        return this.list.stream().filter(a->a.getId().equals(entityID.toString())).findFirst().orElse(null);
    }

    @Override
    public List<T> getAll() throws SQLException {
        return list;
    }
}
