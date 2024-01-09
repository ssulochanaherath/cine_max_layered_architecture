package lk.ijse.cinemax.bo.custom;

import lk.ijse.cinemax.bo.SuperBO;
import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.SeatDto;
import lk.ijse.cinemax.entity.Seat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SeatBO extends SuperBO {
    boolean saveSeats(SeatDto dto) throws SQLException, ClassNotFoundException;

    boolean updateSeats(SeatDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteSeats(String id) throws SQLException, ClassNotFoundException;

    SeatDto searchSeats(String id) throws SQLException, ClassNotFoundException;

    ArrayList<SeatDto> loadAllSeats() throws SQLException, ClassNotFoundException;

    public boolean hideSeat(Connection connection, String seatId) throws SQLException, ClassNotFoundException;

    public int getAvailableSeatsCount() throws SQLException, ClassNotFoundException;
}
