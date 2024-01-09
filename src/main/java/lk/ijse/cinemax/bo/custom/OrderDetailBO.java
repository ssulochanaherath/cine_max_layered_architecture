package lk.ijse.cinemax.bo.custom;

import lk.ijse.cinemax.bo.SuperBO;
import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.PlaceOrderDto;
import lk.ijse.cinemax.dto.tm.CartTm;
import lk.ijse.cinemax.entity.PlaceOrder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface OrderDetailBO extends SuperBO {
    boolean saveOrderDetails(PlaceOrderDto dto) throws SQLException, ClassNotFoundException;

    boolean updateOrderDetails(PlaceOrderDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteOrderDetails(String id) throws SQLException, ClassNotFoundException;

    PlaceOrderDto searchOrderDetails(String id) throws SQLException, ClassNotFoundException;

    ArrayList<PlaceOrderDto> loadAllOrderDetails() throws SQLException, ClassNotFoundException;

    public boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException, ClassNotFoundException;

    public boolean saveOrderDetails(String orderId, CartTm tm) throws SQLException, ClassNotFoundException;
}
