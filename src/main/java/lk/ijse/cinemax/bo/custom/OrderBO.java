package lk.ijse.cinemax.bo.custom;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lk.ijse.cinemax.bo.SuperBO;
import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.PlaceOrderDto;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface OrderBO extends SuperBO {
    boolean saveOrders(PlaceOrderDto dto) throws SQLException, ClassNotFoundException;

    boolean updateOrders(PlaceOrderDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteOrders(String id) throws SQLException, ClassNotFoundException;

    PlaceOrderDto searchOrders(String id) throws SQLException, ClassNotFoundException;

    ArrayList<PlaceOrderDto> loadAllOrders() throws SQLException, ClassNotFoundException;

    public String getLastOrderId() throws SQLException, ClassNotFoundException;

    boolean saveOrders(String orderId, String customerId, LocalDate date) throws SQLException, ClassNotFoundException;

    public String splitOrderId(String currentOrderId);

    public boolean saveOrder(String orderId, String customerId, LocalDate date) throws SQLException, ClassNotFoundException;
}
