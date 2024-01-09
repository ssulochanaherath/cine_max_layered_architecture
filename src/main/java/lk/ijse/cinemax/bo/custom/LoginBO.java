package lk.ijse.cinemax.bo.custom;

import lk.ijse.cinemax.bo.SuperBO;
import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.LoginDto;
import lk.ijse.cinemax.dto.SignUpDto;
import lk.ijse.cinemax.entity.Login;
import lk.ijse.cinemax.entity.SignUp;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LoginBO extends SuperBO {

    LoginDto search(String userName, String password) throws SQLException, ClassNotFoundException;

    boolean save(LoginDto dto) throws SQLException, ClassNotFoundException;

    boolean update(LoginDto dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    LoginDto search(String id) throws SQLException, ClassNotFoundException;

    ArrayList<LoginDto> loadAll() throws SQLException, ClassNotFoundException;

    boolean save(SignUpDto dto) throws SQLException, ClassNotFoundException;

    boolean update(SignUpDto dto) throws SQLException, ClassNotFoundException;
}
