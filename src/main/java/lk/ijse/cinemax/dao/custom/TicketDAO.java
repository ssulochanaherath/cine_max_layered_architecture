package lk.ijse.cinemax.dao.custom;

import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.MovieDto;
import lk.ijse.cinemax.dto.SeatDto;
import lk.ijse.cinemax.entity.Customer;
import lk.ijse.cinemax.entity.ShowTime;
import lk.ijse.cinemax.entity.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TicketDAO extends CrudDAO<Ticket> {
    ArrayList<Customer> loadAllCustomerIds() throws SQLException, ClassNotFoundException;

    ArrayList<MovieDto> loadAllMovieIds() throws SQLException, ClassNotFoundException;

    ArrayList<SeatDto> loadAllSeatNos() throws SQLException, ClassNotFoundException;

    String getLastTicketId() throws SQLException, ClassNotFoundException;

    ArrayList<ShowTime> loadAllShowtimeIds() throws SQLException, ClassNotFoundException;

    String getCustomerEmail(String selectedCustomerId) throws SQLException, ClassNotFoundException;
}
