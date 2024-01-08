package lk.ijse.cinemax.dao.custom;

import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.entity.Seat;

import java.sql.Connection;
import java.sql.SQLException;

public interface SeatDAO extends CrudDAO<Seat> {
    boolean hideSeat(Connection connection, String seatId) throws SQLException, ClassNotFoundException;

    int getAvailableSeatsCount() throws SQLException, ClassNotFoundException;
}
