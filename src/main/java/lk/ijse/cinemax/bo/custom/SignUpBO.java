package lk.ijse.cinemax.bo.custom;

import lk.ijse.cinemax.bo.SuperBO;
import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.SignUpDto;
import lk.ijse.cinemax.entity.SignUp;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SignUpBO extends SuperBO {
    boolean save(SignUpDto dto) throws SQLException, ClassNotFoundException;

    boolean update(SignUpDto dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    SignUpDto search(String id) throws SQLException, ClassNotFoundException;

    ArrayList<SignUpDto> loadAll() throws SQLException, ClassNotFoundException;

    public String getLastUserId() throws SQLException;
}
