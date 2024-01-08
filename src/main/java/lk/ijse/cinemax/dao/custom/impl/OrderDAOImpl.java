package lk.ijse.cinemax.dao.custom.impl;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.OrderDAO;
import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.entity.Movie;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
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
    public boolean save(String orderId, String customerId, LocalDate date) throws SQLException, ClassNotFoundException {
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
    public boolean save(MysqlxCrud.Order dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(MysqlxCrud.Order dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Movie search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<MysqlxCrud.Order> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean saveOrder(String orderId, String customerId, LocalDate date) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO orders VALUES(?, ?, ?)",
                orderId, customerId, date);
    }
}
