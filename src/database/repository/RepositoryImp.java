package database.repository;

import domain.entities.Entidade;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

public class RepositoryImp<T extends Entidade, K> implements Repository<T, K> {

    protected Set<T> list;

    public RepositoryImp(Set<T> list) {
        this.list = list;
    }

    @Override
    public void insert(T entity) throws SQLException {
        this.list.add(entity);
    }

    @Override
    public void update(T entity) throws SQLException {
       Optional<T> entityFound = this.list.stream().filter(e->e.getId().equals(entity.getId())).findFirst();
       if(entityFound.isPresent()){

        this.list.remove(entityFound.get());
        this.list.add(entity);
       }else {
           throw new SQLException(" Entidade não encontrada");
       }
    }

    @Override
    public void removeById(K entityID) throws SQLException {
        this.list.removeIf(a -> a.getId().equals(entityID.toString()));
    }

    @Override
    public T getByID(K entityID) throws SQLException {
        return this.list.stream().filter(a -> a.getId().equals(entityID.toString())).findFirst().orElse(null);
    }

    @Override
    public Set<T> getAll() throws SQLException {
        return list;
    }
}
