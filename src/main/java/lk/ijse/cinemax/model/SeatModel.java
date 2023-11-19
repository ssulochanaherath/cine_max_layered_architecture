package lk.ijse.cinemax.model;

import lk.ijse.cinemax.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SeatModel {
    public boolean deleteSeat(Connection connection, String seatId) {
        try (PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM seats WHERE seatId = ?")) {
            // Set the parameter
            deleteStatement.setString(1, seatId);

            // Execute the delete query
            int rowsAffected = deleteStatement.executeUpdate();

            // Check if the deletion was successful
            if (rowsAffected > 0) {
                // Optionally, you can perform additional actions or log information here
                return true;
            } else {
                // Optionally, you can log a message or throw an exception
                System.err.println("Seat with ID " + seatId + " not found for deletion.");
                return false;
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
            // Optionally, log a message or throw a custom exception
            return false;
        }
    }
}
