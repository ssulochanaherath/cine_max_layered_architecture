package lk.ijse.cinemax.bo.custom;

import lk.ijse.cinemax.bo.SuperBO;
import lk.ijse.cinemax.dto.CustomerDto;
import lk.ijse.cinemax.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    CustomerDto searchCustomer(String id) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDto> loadAllCustomer() throws SQLException, ClassNotFoundException;

    public ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException;

    public String getLastCustomerId() throws SQLException, ClassNotFoundException;
}
