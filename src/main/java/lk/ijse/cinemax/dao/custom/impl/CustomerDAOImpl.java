package lk.ijse.cinemax.dao.custom.impl;

import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl {
    public boolean saveCustomer(CustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getCustomerId());
        pstm.setString(2, dto.getCustomerName());
        pstm.setString(3, dto.getCustomerAddress());
        pstm.setString(4, dto.getCustomerTelephone());
        pstm.setString(5, dto.getUserId());
        pstm.setString(6, dto.getCustomerEmail());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public List<CustomerDto> getAllCustomer() throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM customer";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<CustomerDto> dtoList = new ArrayList<>();

        while (resultSet.next()){
            dtoList.add(
                    new CustomerDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return dtoList;
    }


    public boolean updateCustomer(CustomerDto dto) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE customer SET name = ?, address = ?, tele = ?, userId = ?, email = ? WHERE customerId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getCustomerName());
        pstm.setString(2, dto.getCustomerAddress());
        pstm.setString(3, dto.getCustomerTelephone());
        pstm.setString(4, dto.getUserId());
        pstm.setString(5, dto.getCustomerId());
        pstm.setString(6, dto.getCustomerEmail());

        boolean isUpdated = pstm.executeUpdate() > 0;

        return isUpdated;
    }

    public boolean deleteCustomer(String customerId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM customer WHERE customerId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, customerId);

        return pstm.executeUpdate() > 0;
    }

    public CustomerDto searchCustomer(String seachId) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM customer WHERE customerId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, seachId);

        ResultSet resultSet = pstm.executeQuery();

        CustomerDto dto = null;

        if (resultSet.next()) {

            String name = resultSet.getString(1);
            String address = resultSet.getString(2);
            String tele = resultSet.getString(3);
            String userId = resultSet.getString(4);
            String customerId = resultSet.getString(5);
            String email = resultSet.getString(6);

            dto = new CustomerDto(customerId, name, address, tele, userId, email);
        }
        return dto;
    }

    public List<CustomerDto> loadAllCustomerIds() throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM customer";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<CustomerDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            dtoList.add(new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            ));
        }
        return dtoList;
    }

    public String getLastCustomerId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT customerId from customer ORDER BY customerId DESC LIMIT 1";

        try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet resultSet = pstm.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getString(1);
            } else {
                // If no customer has been generated yet, return an empty string
                return "";
            }
        }
    }

//    public List<CustomerDto> loadAllCustomerIds() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM customer";
//        try (PreparedStatement pstm = connection.prepareStatement(sql);
//             ResultSet resultSet = pstm.executeQuery()) {
//
//            List<CustomerDto> customerDtoList = new ArrayList<>();
//
//            while (resultSet.next()) {
//                customerDtoList.add(new CustomerDto(
//                        resultSet.getString(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getString(4),
//                        resultSet.getString(5)
//                ));
//            }
//
//            return customerDtoList;
//        }
//    }
}
