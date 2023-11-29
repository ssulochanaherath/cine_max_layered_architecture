package lk.ijse.cinemax.model;

import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.SignUpDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SignUpModel {
    public static List<SignUpDto> loadAllUserIds() throws  SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM user";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<SignUpDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            dtoList.add(new SignUpDto(
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

    public String getLastUserId() throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT userId FROM user ORDER BY userId DESC LIMIT 1";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            ResultSet resultSet = pstm.executeQuery();

            if(resultSet.next()){
                return resultSet.getString(1);
            }else{
                return "";
            }
        }
    }
}
