package lk.ijse.cinemax.dao.custom;

import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.entity.PlaceOrder;

import java.sql.SQLException;

public interface PlaceOrderDAO extends CrudDAO<PlaceOrder> {
    boolean placeOrder(PlaceOrder placeOrder) throws SQLException;
}
