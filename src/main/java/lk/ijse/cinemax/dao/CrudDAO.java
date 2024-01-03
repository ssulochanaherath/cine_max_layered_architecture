package lk.ijse.cinemax.dao;

import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    boolean save(T dto) throws SQLException;

    ArrayList<T> getAll() throws SQLException;

    boolean update(T dto) throws SQLException;

    boolean delete(String id) throws SQLException;

    T search(String id) throws SQLException;

    ArrayList<T> loadAllIds() throws SQLException;

    String getLastId() throws SQLException;

}
