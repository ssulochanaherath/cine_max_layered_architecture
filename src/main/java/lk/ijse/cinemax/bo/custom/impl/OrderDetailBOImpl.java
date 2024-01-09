package lk.ijse.cinemax.bo.custom.impl;

import lk.ijse.cinemax.bo.custom.OrderDetailBO;
import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dto.PlaceOrderDto;
import lk.ijse.cinemax.dto.tm.CartTm;
import lk.ijse.cinemax.entity.PlaceOrder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailBOImpl implements OrderDetailBO {
    public boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException, ClassNotFoundException {
        for(CartTm tm : cartTmList) {
            if(!saveOrderDetails(orderId, tm)) {
                return false;
            }
        }
        return true;
    }

    public boolean saveOrderDetails(String orderId, CartTm tm) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO order_detail VALUES(?, ?, ?, ?)",
                orderId, tm.getCode(), tm.getQty(), tm.getUnitPrice());
    }

    public boolean saveOrderDetails(PlaceOrderDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    public boolean updateOrderDetails(PlaceOrderDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteOrderDetails(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public PlaceOrderDto searchOrderDetails(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<PlaceOrderDto> loadAllOrderDetails() throws SQLException, ClassNotFoundException {
        return null;
    }
}
