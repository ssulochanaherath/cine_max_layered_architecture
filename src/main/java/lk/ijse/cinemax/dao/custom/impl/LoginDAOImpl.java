package lk.ijse.cinemax.dao.custom.impl;
import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.LoginDAO;
import lk.ijse.cinemax.dto.LoginDto;
import lk.ijse.cinemax.entity.Login;
import lk.ijse.cinemax.entity.SignUp;
import lk.ijse.cinemax.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAOImpl implements LoginDAO {
    public LoginDto search(String userName, String password) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM user WHERE userName = ? AND password = ?", userName, password);
        if (rst.next()) {
            LoginDto loginDto = new LoginDto();
            loginDto.setUserName(rst.getString(1));
            loginDto.setPassword(rst.getString(2));

            return loginDto;
        } else {
            return null;
        }

//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT  * FROM user WHERE userName = ? AND password = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,userName);
//        pstm.setString(2, password);
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        if (resultSet.next()) {
//            LoginDto loginDto = new LoginDto();
//            loginDto.setUserName(resultSet.getString("userName"));
//            loginDto.setPassword(resultSet.getString("password"));
//
//            return loginDto;
//        } else {
//            return null;
//        }
    }

    @Override
    public boolean save(Login dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Login dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Supplier> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(SignUp dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(SignUp dto) throws SQLException, ClassNotFoundException {
        return false;
    }
}
