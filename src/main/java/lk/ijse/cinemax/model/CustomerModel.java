package lk.ijse.cinemax.model;

import lk.ijse.cinemax.dto.CustomerDto;
import lk.ijse.cinemax.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
    public boolean saveCustomer(CustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getCustomerId());
        pstm.setString(2, dto.getCustomerName());
        pstm.setString(3, dto.getCustomerAddress());
        pstm.setString(4, dto.getCustomerTelephone());
        pstm.setString(5, dto.getUserId());

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
                            resultSet.getString(5)
                    )
            );
        }
        return dtoList;
    }
}
