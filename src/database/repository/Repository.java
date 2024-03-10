package database.repository;

import domain.entities.Entidade;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T extends Entidade,K> {
    void insert(T entity) throws SQLException;
    void removeById(K entityID) throws SQLException;
    T getByID(K entityID) throws SQLException;
    List<T> getAll() throws SQLException;

}