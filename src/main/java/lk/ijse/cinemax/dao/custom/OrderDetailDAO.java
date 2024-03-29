package lk.ijse.cinemax.dao.custom;

import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.tm.CartTm;
import lk.ijse.cinemax.entity.PlaceOrder;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO extends CrudDAO<PlaceOrder> {
    boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException, ClassNotFoundException;

    boolean saveOrderDetails(String orderId, CartTm tm) throws SQLException, ClassNotFoundException;
}
