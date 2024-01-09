package lk.ijse.cinemax.dao.custom.impl;

import lk.ijse.cinemax.dao.custom.PlaceOrderDAO;
import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.entity.PlaceOrder;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {
    private OrderDAOImpl orderModel = new OrderDAOImpl();
    private ItemDAOImpl itemModel = new ItemDAOImpl();
    private OrderDetailDAOImpl orderDetailModel = new OrderDetailDAOImpl();
    public boolean placeOrder(PlaceOrder placeOrder) throws SQLException {
        System.out.println(placeOrder);

        String orderId = placeOrder.getOrderId();
        String customerId = placeOrder.getCustomerId();
        LocalDate date = placeOrder.getDate();

        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = orderModel.saveOrder(orderId, customerId, date);
            if (isOrderSaved) {
                boolean isUpdated = itemModel.updateItem(placeOrder.getCartTmList());
                if (isUpdated) {
                    boolean isOrderDetailSaved = orderDetailModel.saveOrderDetails(placeOrder.getOrderId(), placeOrder.getCartTmList());
                    if (isOrderDetailSaved) {
                        connection.commit();
                    }
                }
            }
            connection.rollback();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            connection.setAutoCommit(true);
        }
        return true;
    }

    @Override
    public boolean save(PlaceOrder dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(PlaceOrder dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public PlaceOrder search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<PlaceOrder> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
