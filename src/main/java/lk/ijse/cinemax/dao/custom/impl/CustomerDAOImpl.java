package lk.ijse.cinemax.dao.custom.impl;

import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.CustomerDAO;
import lk.ijse.cinemax.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    public boolean save(Customer dto) throws SQLException, ClassNotFoundException {
        boolean isSaved = SQLUtil.execute("INSERT INTO customer VALUES(?,?,?,?,?,?)",
                dto.getCustomerId(),dto.getCustomerName(),dto.getCustomerAddress(),dto.getCustomerTelephone(),dto.getUserId(),dto.getCustomerEmail());
        return isSaved;
    }

    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer");
        ArrayList<Customer> allCustomer = new ArrayList<>();

        while (rst.next()){
            allCustomer.add(new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return allCustomer;
    }


    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {

        boolean isUpdated = SQLUtil.execute("UPDATE customer SET name = ?, address = ?, tele = ?, userId = ?, email = ? WHERE customerId = ?",
                dto.getCustomerName(),dto.getCustomerAddress(),dto.getCustomerTelephone(),dto.getUserId(),dto.getCustomerEmail(),dto.getCustomerId());
        return isUpdated;
    }

    public boolean delete(String customerId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM customer WHERE customerId = ?", customerId);
    }

    public Customer search(String seachId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer WHERE customerId = ?", seachId);
        rst.next();
        return new Customer(seachId, rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
    }

    public ArrayList<Customer> loadAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer");
        ArrayList<Customer> allCustomer = new ArrayList<>();

        while (rst.next()){
            allCustomer.add(new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return allCustomer;
    }


    public String getLastId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT customerId FROM customer ORDER BY customerId DESC LIMIT 1");
        if (rst.next()){
            return rst.getString(1);
        }
        return "";
    }
}
