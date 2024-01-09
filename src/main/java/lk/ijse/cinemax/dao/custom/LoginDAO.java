package lk.ijse.cinemax.dao.custom;

import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.LoginDto;
import lk.ijse.cinemax.dto.PlaceOrderDto;
import lk.ijse.cinemax.entity.Login;
import lk.ijse.cinemax.entity.SignUp;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LoginDAO extends CrudDAO<Login> {

    LoginDto search(String userName, String password) throws SQLException, ClassNotFoundException;

    boolean save(Login dto) throws SQLException, ClassNotFoundException;

    boolean update(Login dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    Login search(String id) throws SQLException, ClassNotFoundException;

    ArrayList<Login> loadAll() throws SQLException, ClassNotFoundException;

    boolean save(SignUp dto) throws SQLException, ClassNotFoundException;

    boolean update(SignUp dto) throws SQLException, ClassNotFoundException;
}
