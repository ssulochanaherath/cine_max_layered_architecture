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
        ArrayList<Customer> customer = customerDAO.getAll();
        ArrayList<CustomerDto> customerDTOS = new ArrayList<>();
        for (Customer c : customer) {
            customerDTOS.add(new CustomerDto(c.getCustomerId(), c.getCustomerName(), c.getCustomerAddress(), c.getCustomerTelephone(), c.getUserId(), c.getCustomerEmail()));
        }
        return customer;
    }

    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(
                dto.getCustomerId(),
                dto.getCustomerName(),
                dto.getCustomerAddress(),
                dto.getCustomerTelephone(),
                dto.getUserId(),
                dto.getCustomerEmail()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(
                dto.getCustomerId(),
                dto.getCustomerName(),
                dto.getCustomerAddress(),
                dto.getCustomerTelephone(),
                dto.getUserId(),
                dto.getCustomerEmail()
        ));
}

    public boolean deleteCustomer(String customerId) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(customerId);
    }

    public CustomerDto searchCustomer(String seachId) throws SQLException, ClassNotFoundException {
        Customer customer = customerDAO.search(seachId);
        CustomerDto customerDto = new CustomerDto(
                customer.getCustomerId(),
                customer.getCustomerName(),
                customer.getCustomerAddress(),
                customer.getCustomerTelephone(),
                customer.getUserId(),
                customer.getCustomerEmail()
        );
        return customerDto;
    }

    public ArrayList<CustomerDto> loadAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomer = customerDAO.loadAll();
        ArrayList<CustomerDto> customerDTOS = new ArrayList<>();
        for (Customer c : allCustomer) {
            customerDTOS.add(new CustomerDto(c.getCustomerId(), c.getCustomerName(), c.getCustomerAddress(), c.getCustomerTelephone(), c.getUserId(), c.getCustomerEmail()));
        }
        return customerDTOS;
    }


    public String getLastCustomerId() throws SQLException, ClassNotFoundException {
        return customerDAO.getLastId();

//        ResultSet rst = SQLUtil.execute("SELECT customerId FROM customer ORDER BY customerId DESC LIMIT 1");
//        if (rst.next()){
//            return rst.getString(1);
//        }
//        return "";
    }
}
