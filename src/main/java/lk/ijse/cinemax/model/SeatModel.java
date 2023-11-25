package lk.ijse.cinemax.model;

import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.SeatDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatModel {

    public boolean hideSeat(Connection connection, String seatId) throws SQLException {
        String query = "UPDATE seats SET status = 'unavailable' WHERE seatId = ? AND status = 'available'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, seatId);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        }
    }
//    public List<SeatDto> loadAvailableSeats() throws SQLException{
//        String query = "SELECT * FROM seats WHERE status = 'available'";
//        List<SeatDto> availableSeats = new ArrayList<>();
//
//        try (Connection connection = DbConnection.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query);
//             ResultSet resultSet = preparedStatement.executeQuery()) {
//
//            while (resultSet.next()) {
//                SeatDto seatDto = new SeatDto();
//                seatDto.setSeatId(resultSet.getString("seatId"));
//                seatDto.setStatus(resultSet.getString("status"));
//                // Add other seat details as needed
//                availableSeats.add(seatDto);
//            }
//        } catch (SQLException e) {
//            // Log or print the exception details
//            e.printStackTrace();
//        }
//
//        return availableSeats;
//    }

}
