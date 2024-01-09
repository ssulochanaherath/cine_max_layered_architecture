package lk.ijse.cinemax.bo.custom.impl;

import lk.ijse.cinemax.bo.custom.OrderBO;
import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dto.PlaceOrderDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderBOImpl implements OrderBO {
    public String getLastOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1");

        if (rst.next()) {
            return rst.getString(1);
        } else {
            // If no customer has been generated yet, return an empty string
            return "";
        }
    }

    @Override
    public boolean saveOrders(String orderId, String customerId, LocalDate date) throws SQLException, ClassNotFoundException {
        return false;
    }

    public String splitOrderId(String currentOrderId) {
        if(currentOrderId != null) {
            String[] split = currentOrderId.split("O0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "O00" + id;
        } else {
            return "O001";
        }
    }

    @Override
    public boolean saveOrders(PlaceOrderDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateOrders(PlaceOrderDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteOrders(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public PlaceOrderDto searchOrders(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<PlaceOrderDto> loadAllOrders() throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean saveOrder(String orderId, String customerId, LocalDate date) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO orders VALUES(?, ?, ?)",
                orderId, customerId, date);
    }
}
