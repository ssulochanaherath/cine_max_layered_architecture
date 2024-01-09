package lk.ijse.cinemax.bo.custom.impl;

import lk.ijse.cinemax.bo.custom.SeatBO;
import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.SeatDAO;
import lk.ijse.cinemax.dto.SeatDto;
import lk.ijse.cinemax.entity.Seat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeatBOImpl implements SeatBO {

    public boolean hideSeat(Connection connection, String seatId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("UPDATE seats SET status = 'unavailable' WHERE seatId = ? AND status = 'available'", seatId);

        return rst.next();


//        String query = "UPDATE seats SET status = 'unavailable' WHERE seatId = ? AND status = 'available'";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setString(1, seatId);
//
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            return rowsAffected > 0;
//        }
    }

    public int getAvailableSeatsCount() throws SQLException, ClassNotFoundException {
        int count = 0;
        ResultSet rst = SQLUtil.execute("SELECT COUNT(*) FROM seats WHERE status = 'available'");
        if (rst.next()) {
            count = rst.getInt(1);
        }
        return count;

//        int count = 0;
//        try {
//            Connection connection = DbConnection.getInstance().getConnection();
//            String sql = "SELECT COUNT(*) FROM seats WHERE status = 'available'";
//            try (PreparedStatement pstm = connection.prepareStatement(sql);
//                 ResultSet resultSet = pstm.executeQuery()) {
//
//                if (resultSet.next()) {
//                    count = resultSet.getInt(1);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle other SQLExceptions appropriately
//        }
//        return count;
    }

    @Override
    public boolean saveSeats(SeatDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateSeats(SeatDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteSeats(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public SeatDto searchSeats(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<SeatDto> loadAllSeats() throws SQLException, ClassNotFoundException {
        return null;
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
