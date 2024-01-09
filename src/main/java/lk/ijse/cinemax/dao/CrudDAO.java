package lk.ijse.cinemax.dao;

import lk.ijse.cinemax.dto.TicketDto;
import lk.ijse.cinemax.entity.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    TicketDto search(String id) throws SQLException, ClassNotFoundException;

    ArrayList<Ticket> loadAll() throws SQLException, ClassNotFoundException;

    //String getLastId() throws SQLException, ClassNotFoundException;
    //ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
}
