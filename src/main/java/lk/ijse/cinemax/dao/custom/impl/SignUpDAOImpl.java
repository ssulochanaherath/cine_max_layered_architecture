package lk.ijse.cinemax.dao.custom.impl;

import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.SignUpDAO;
import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.TicketDto;
import lk.ijse.cinemax.entity.SignUp;
import lk.ijse.cinemax.entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SignUpDAOImpl implements SignUpDAO {
    public ArrayList<Ticket> loadAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM user");
        ArrayList<SignUp> list = new ArrayList<>();

        while (rst.next()){
            list.add(new SignUp(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5)
                    )
            );
        }
        return list;
    }

    public boolean save(SignUp dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO user VALUES(?,?,?,?,?)",
                dto.getUserId(),dto.getFristName(),dto.getLastName(),dto.getUserName(),dto.getPassword());
    }

    @Override
    public boolean update(SignUp dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public TicketDto search(String id) throws SQLException, ClassNotFoundException {
        return null;
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
