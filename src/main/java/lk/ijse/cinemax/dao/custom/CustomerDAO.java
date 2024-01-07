package lk.ijse.cinemax.dao.custom;

import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer> {
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException;

    public String getLastId() throws SQLException, ClassNotFoundException;
}
