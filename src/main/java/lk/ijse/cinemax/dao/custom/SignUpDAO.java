package lk.ijse.cinemax.dao.custom;

import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.entity.SignUp;

import java.sql.SQLException;

public interface SignUpDAO extends CrudDAO<SignUp> {
    String getLastUserId() throws SQLException;
}
