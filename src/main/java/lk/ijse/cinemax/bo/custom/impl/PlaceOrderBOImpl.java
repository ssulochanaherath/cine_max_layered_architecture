package lk.ijse.cinemax.bo.custom.impl;

import lk.ijse.cinemax.bo.custom.PlaceOrderBO;
import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.PlaceOrderDto;
import lk.ijse.cinemax.entity.PlaceOrder;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    private OrderBOImpl orderModel = new OrderBOImpl();
    private ItemBOImpl itemModel = new ItemBOImpl();
    private OrderDetailBOImpl orderDetailModel = new OrderDetailBOImpl();
    public boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException {
        System.out.println(placeOrderDto);

        String orderId = placeOrderDto.getOrderId();
        String customerId = placeOrderDto.getCustomerId();
        LocalDate date = placeOrderDto.getDate();

        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = orderModel.saveOrder(orderId, customerId, date);
            if (isOrderSaved) {
                boolean isUpdated = itemModel.updateItem(placeOrderDto.getCartTmList());
                if (isUpdated) {
                    boolean isOrderDetailSaved = orderDetailModel.saveOrderDetails(placeOrderDto.getOrderId(), placeOrderDto.getCartTmList());
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
    public boolean savePlaceOrder(PlaceOrderDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updatePlaceOrder(PlaceOrderDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deletePlaceOrder(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public PlaceOrderDto searchPlaceOrder(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<PlaceOrderDto> loadAllPlaceOrder() throws SQLException, ClassNotFoundException {
        return null;
    }
}
