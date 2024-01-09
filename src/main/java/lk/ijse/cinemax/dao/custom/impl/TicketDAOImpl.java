package lk.ijse.cinemax.dao.custom.impl;

import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.TicketDAO;
import lk.ijse.cinemax.dto.*;
import lk.ijse.cinemax.entity.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketDAOImpl implements TicketDAO {
    private SeatDAOImpl seatModel = new SeatDAOImpl();
    public ArrayList<Customer> loadAllCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer");
        ArrayList<Customer> allCustomer = new ArrayList<>();

        while (rst.next()){
            allCustomer.add(new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return allCustomer;
    }

    public ArrayList<MovieDto> loadAllMovieIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM movie");
        ArrayList<MovieDto> allMovie = new ArrayList<>();

        while (rst.next()){
            allMovie.add(new MovieDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return allMovie;
    }

    public ArrayList<SeatDto> loadAllSeatNos() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM seats");
        ArrayList<SeatDto> allSeat = new ArrayList<>();

        while (rst.next()){
            allSeat.add(new SeatDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            ));
        }
        return allSeat;
    }


    @Override
    public boolean save(TicketDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(TicketDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean save(Ticket dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Ticket dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Ticket search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<Ticket> loadAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM tickets");
        ArrayList<Ticket> tickets = new ArrayList<>();

        while(rst.next()){
            tickets.add(new Ticket(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return tickets;
    }

    public String getLastTicketId() throws SQLException, ClassNotFoundException {
        ResultSet rst =  SQLUtil.execute("SELECT ticketId FROM tickets ORDER BY ticketId DESC LIMIT 1");

        if (rst.next()){
            return rst.getString(1);
        } else {
            // If no ticket has been generated yet, return an empty string
            return "";
        }
    }

    public ArrayList<ShowTimeDto> loadAllShowtimeIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM showtime");
        ArrayList<ShowTimeDto> showtimeDtoList = new ArrayList<>();

        while (rst.next()){
            showtimeDtoList.add(new ShowTimeDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            ));
        }
        return showtimeDtoList;
    }

    public boolean save(Connection connection, Ticket ticket) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO tickets (ticketId, customerId, movieId, seatId, showTimeID, price) VALUES (?, ?, ?, ?, ?, ?)",
                ticket.getTicketId(), ticket.getCustomerId(), ticket.getMovieId(), ticket.getSeatNo(), ticket.getShowTimeID(), ticket.getPrice());
    }

    public String getCustomerEmail(String selectedCustomerId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT email FROM customer WHERE customerId = ?", selectedCustomerId);

        if (rst.next()){
            return rst.getString("email");
        } else {
            // If no customer with the specified ID is found, return an empty string
            return "";
        }
    }
}


