package lk.ijse.cinemax.bo.custom.impl;

import lk.ijse.cinemax.bo.custom.TicketBO;
import lk.ijse.cinemax.dao.DAOFactory;
import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.CustomerDAO;
import lk.ijse.cinemax.dao.custom.MovieDAO;
import lk.ijse.cinemax.dao.custom.SeatDAO;
import lk.ijse.cinemax.dao.custom.TicketDAO;
import lk.ijse.cinemax.dto.*;
import lk.ijse.cinemax.entity.Customer;
import lk.ijse.cinemax.entity.Movie;
import lk.ijse.cinemax.entity.Seat;
import lk.ijse.cinemax.entity.Ticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketBOImpl implements TicketBO {

    TicketDAO ticketDAO = (TicketDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.TICKET);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.CUSTOMER);
    SeatDAO seatDAO = (SeatDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.SEAT);
    MovieDAO movieDAO = (MovieDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.MOVIE);
//    private SeatBOImpl seatModel = new SeatBOImpl();
    public ArrayList<CustomerDto> loadAllCustomerIds() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customer = customerDAO.loadAll();
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer c : customer) {
            customerDtos.add(new CustomerDto(c.getCustomerId(), c.getCustomerName(), c.getCustomerAddress(), c.getCustomerTelephone(), c.getUserId(), c.getCustomerEmail()));
        }
        return customerDtos;


//        ResultSet rst = SQLUtil.execute("SELECT * FROM customer");
//        ArrayList<CustomerDto> allCustomer = new ArrayList<>();
//
//        while (rst.next()){
//            allCustomer.add(new CustomerDto(
//                    rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getString(4),
//                    rst.getString(5),
//                    rst.getString(6)
//            ));
//        }
//        return allCustomer;

    }

    public ArrayList<MovieDto> loadAllMovieIds() throws SQLException, ClassNotFoundException {
        ArrayList<Movie> movie = movieDAO.loadAll();
        ArrayList<MovieDto> movieDtos = new ArrayList<>();
        for (Movie m : movie) {
            movieDtos.add(new MovieDto(m.getMovieId(), m.getMovieName(), m.getMovieGenre(), m.getYear(), m.getImagePath(), m.getDescription()));
        }
        return movieDtos;
//        ResultSet rst = SQLUtil.execute("SELECT * FROM movie");
//        ArrayList<MovieDto> allMovie = new ArrayList<>();
//
//        while (rst.next()){
//            allMovie.add(new MovieDto(
//                    rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getString(4),
//                    rst.getString(5),
//                    rst.getString(6)
//            ));
//        }
//        return allMovie;
    }

    public ArrayList<SeatDto> loadAllSeatNos() throws SQLException, ClassNotFoundException {
        /*ArrayList<SeatDto> seatDtos = new ArrayList<>();
        ArrayList<Seat> seat = seatDAO.loadAll();

        for (Seat s : seat) {
        seatDtos.add(new SeatDto(
                s.getSeatId(),
                s.getSeatNo(),
                s.getVertical(),
                s.getHorizontal(),
                s.getStatus()
        ));
    }
    return seatDtos;*/
//        ResultSet rst = SQLUtil.execute("SELECT * FROM seats");
//        ArrayList<SeatDto> allSeat = new ArrayList<>();
//
//        while (rst.next()){
//            allSeat.add(new SeatDto(
//                    rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getString(4),
//                    rst.getString(5)
//            ));
//        }
//        return allSeat;
        ArrayList<SeatDto> seatDtos = new ArrayList<>();

        if (seatDAO != null) {
            ArrayList<Seat> seat = seatDAO.loadAll();

            for (Seat s : seat) {
                seatDtos.add(new SeatDto(
                        s.getSeatId(),
                        s.getSeatNo(),
                        s.getVertical(),
                        s.getHorizontal(),
                        s.getStatus()
                ));
            }
        } else {
            System.err.println("seatDAO is null");
        }

        return seatDtos;
    }



    @Override
    public boolean saveTickets(Connection connection, TicketDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateTickets(TicketDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteTickets(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public TicketDto searchTickets(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<TicketDto> loadAllTickets() throws SQLException, ClassNotFoundException {
        ArrayList<Ticket> tickets = ticketDAO.loadAll();
        ArrayList<TicketDto> ticketDtos = new ArrayList<>();
        for (Ticket t : tickets) {
            ticketDtos.add(new TicketDto(
                    t.getTicketId(),
                    t.getMovieId(),
                    t.getSeatNo(),
                    t.getShowTimeID(),
                    t.getCustomerId(),
                    t.getPrice()
            ));
        }
        return ticketDtos;
//        ResultSet rst = SQLUtil.execute("SELECT * FROM tickets");
//        ArrayList<TicketDto> tickets = new ArrayList<>();
//
//        while(rst.next()){
//            tickets.add(new TicketDto(
//                    rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getString(4),
//                    rst.getString(5),
//                    rst.getString(6)
//            ));
//        }
//        return tickets;
    }

    public String getLastTicketId() throws SQLException, ClassNotFoundException {
        return ticketDAO.getLastTicketId();
//        ResultSet rst =  SQLUtil.execute("SELECT ticketId FROM tickets ORDER BY ticketId DESC LIMIT 1");
//
//        if (rst.next()){
//            return rst.getString(1);
//        } else {
//            // If no ticket has been generated yet, return an empty string
//            return "";
//        }
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
        return ticketDAO.save(new TicketDto(ticket.getTicketId(), ticket.getCustomerId(), ticket.getMovieId(), ticket.getSeatNo(), ticket.getShowTimeID(), ticket.getPrice()));
//        return SQLUtil.execute("INSERT INTO tickets (ticketId, customerId, movieId, seatId, showTimeID, price) VALUES (?, ?, ?, ?, ?, ?)",
//                ticket.getTicketId(), ticket.getCustomerId(), ticket.getMovieId(), ticket.getSeatNo(), ticket.getShowTimeID(), ticket.getPrice());
    }

    public String getCustomerEmail(String selectedCustomerId) throws SQLException, ClassNotFoundException {
        return ticketDAO.getCustomerEmail(selectedCustomerId);
//        ResultSet rst = SQLUtil.execute("SELECT email FROM customer WHERE customerId = ?", selectedCustomerId);
//
//        if (rst.next()){
//            return rst.getString("email");
//        } else {
//            // If no customer with the specified ID is found, return an empty string
//            return "";
//        }
    }
}


