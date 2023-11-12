package lk.ijse.cinemax.model;

import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.SignUpDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpModel {
    public boolean saveUser(SignUpDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO user VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getUserId());
        pstm.setString(2, dto.getFristName());
        pstm.setString(3, dto.getLastName());
        pstm.setString(4, dto.getUserName());
        pstm.setString(5, dto.getPassword());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }
}
