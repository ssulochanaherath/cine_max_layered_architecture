package lk.ijse.cinemax.bo.custom;

import lk.ijse.cinemax.bo.SuperBO;
import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.*;
import lk.ijse.cinemax.entity.Customer;
import lk.ijse.cinemax.entity.ShowTime;
import lk.ijse.cinemax.entity.Supplier;
import lk.ijse.cinemax.entity.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TicketBO extends SuperBO {
    ArrayList<CustomerDto> loadAllCustomerIds() throws SQLException, ClassNotFoundException;

    ArrayList<MovieDto> loadAllMovieIds() throws SQLException, ClassNotFoundException;

    ArrayList<SeatDto> loadAllSeatNos() throws SQLException, ClassNotFoundException;

    String getLastTicketId() throws SQLException, ClassNotFoundException;

    ArrayList<ShowTimeDto> loadAllShowtimeIds() throws SQLException, ClassNotFoundException;

    String getCustomerEmail(String selectedCustomerId) throws SQLException, ClassNotFoundException;

    boolean saveTickets(TicketDto dto) throws SQLException, ClassNotFoundException;

    boolean updateTickets(TicketDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteTickets(String id) throws SQLException, ClassNotFoundException;

    TicketDto searchTickets(String id) throws SQLException, ClassNotFoundException;

    ArrayList<TicketDto> loadAllTickets() throws SQLException, ClassNotFoundException;
}
