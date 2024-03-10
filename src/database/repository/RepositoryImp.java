package database.repository;

import domain.entities.Entidade;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class RepositoryImp<T extends Entidade,K> implements Repository<T,K> {

    protected Set<T> list;

    public RepositoryImp(Set<T> list) {
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
    public Set<T> getAll() throws SQLException {
        return list;
    }
}
