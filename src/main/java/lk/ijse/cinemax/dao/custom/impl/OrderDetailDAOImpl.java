package lk.ijse.cinemax.dao.custom.impl;

import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.OrderDetailDAO;
import lk.ijse.cinemax.dto.TicketDto;
import lk.ijse.cinemax.dto.tm.CartTm;
import lk.ijse.cinemax.entity.PlaceOrder;
import lk.ijse.cinemax.entity.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
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
    public TicketDto search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Ticket> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
