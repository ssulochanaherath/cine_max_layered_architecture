package lk.ijse.cinemax.bo.custom.impl;

import lk.ijse.cinemax.bo.custom.CustomerBO;
import lk.ijse.cinemax.dao.DAOFactory;
import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.CustomerDAO;
import lk.ijse.cinemax.dto.CustomerDto;
import lk.ijse.cinemax.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.CUSTOMER);

    public ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {
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

    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        boolean isSaved = SQLUtil.execute("INSERT INTO customer VALUES(?,?,?,?,?,?)",
                dto.getCustomerId(),dto.getCustomerName(),dto.getCustomerAddress(),dto.getCustomerTelephone(),dto.getUserId(),dto.getCustomerEmail());
        return isSaved;
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        boolean isUpdated = SQLUtil.execute("UPDATE customer SET name = ?, address = ?, tele = ?, userId = ?, email = ? WHERE customerId = ?",
                dto.getCustomerName(),dto.getCustomerAddress(),dto.getCustomerTelephone(),dto.getUserId(),dto.getCustomerEmail(),dto.getCustomerId());
        return isUpdated;
    }

    public boolean deleteCustomer(String customerId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM customer WHERE customerId = ?", customerId);
    }

    public CustomerDto searchCustomer(String seachId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer WHERE customerId = ?", seachId);
        rst.next();
        return new CustomerDto(seachId, rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
    }

    public ArrayList<CustomerDto> loadAllCustomer() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer");
        ArrayList<CustomerDto> allCustomer = new ArrayList<>();

        while (rst.next()){
            allCustomer.add(new CustomerDto(
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


    public String getLastIdCustomer() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT customerId FROM customer ORDER BY customerId DESC LIMIT 1");
        if (rst.next()){
            return rst.getString(1);
        }
        return "";
    }
}
