package lk.ijse.cinemax.model;

import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketModel {

    public List<CustomerDto> loadAllCustomerIds() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer";
        try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet resultSet = pstm.executeQuery()) {

            List<CustomerDto> customerDtoList = new ArrayList<>();

            while (resultSet.next()) {
                customerDtoList.add(new CustomerDto(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }

            return customerDtoList;
        }
    }

    public List<MovieDto> loadAllMovieIds() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM movie";
        try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet resultSet = pstm.executeQuery()) {

            List<MovieDto> movieDtoList = new ArrayList<>();

            while (resultSet.next()) {
                movieDtoList.add(new MovieDto(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));
            }

            return movieDtoList;
        }
    }

    public List<SeatDto> loadAllSeatNos() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM seats";
        try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet resultSet = pstm.executeQuery()) {

            List<SeatDto> seatsList = new ArrayList<>();

            while (resultSet.next()) {
                seatsList.add(new SeatDto(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));
            }

            return seatsList;
        }
    }

    public boolean saveTicket(TicketDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO tickets VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getTicketId());
        pstm.setString(2, dto.getCustomerId());
        pstm.setString(3, dto.getMovieId());
        pstm.setString(4, dto.getSeatNo());
        pstm.setString(5, dto.getShowTimeID());
        pstm.setString(6, dto.getPrice());

        boolean isBooked = pstm.executeUpdate() > 0;

        return isBooked;
    }

    public List<TicketDto> loadAllTickets() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM tickets";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<TicketDto> ticketDtoList = new ArrayList<>();

        while (resultSet.next()) {
            ticketDtoList.add(
                    new TicketDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return ticketDtoList;
    }

    public String getLastTicketId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String query = "SELECT ticketId FROM tickets ORDER BY ticketId DESC LIMIT 1";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getString("ticketId");
            } else {
                // If no ticket has been generated yet, return an empty string
                return "";
            }
        }
    }

    public List<ShowTimeDto> loadAllShowtimeIds() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM showtime";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<ShowTimeDto> showtimeDtoList = new ArrayList<>();

        while (resultSet.next()) {
            showtimeDtoList.add(
                    new ShowTimeDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    )
            );
        }
        return showtimeDtoList;

    }
}


