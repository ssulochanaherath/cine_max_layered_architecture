package lk.ijse.cinemax.model;
import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.LoginDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    public static LoginDto searchUser(String userName, String password) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT  * FROM user WHERE userName = ? AND password = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,userName);
        pstm.setString(2, password);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            LoginDto loginDto = new LoginDto();
            loginDto.setUserName(resultSet.getString("userName"));
            loginDto.setPassword(resultSet.getString("password"));

            return loginDto;
        } else {
            return null;
        }
    }
}
