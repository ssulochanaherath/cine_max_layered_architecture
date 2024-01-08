package lk.ijse.cinemax.dao;

import lk.ijse.cinemax.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    boolean save(T dto) throws SQLException, ClassNotFoundException;

    //ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    Item search(String id) throws SQLException, ClassNotFoundException;

    ArrayList<T> loadAll() throws SQLException, ClassNotFoundException;

    //String getLastId() throws SQLException, ClassNotFoundException;

}
