package lk.ijse.cinemax.dao.custom;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.PlaceOrderDto;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface OrderDAO extends CrudDAO<MysqlxCrud.Order> {
    boolean save(String orderId, String customerId, LocalDate date) throws SQLException, ClassNotFoundException;

    boolean saveOrders(String orderId, String customerId, LocalDate date) throws SQLException, ClassNotFoundException;

    String splitOrderId(String currentOrderId);

    String getLastOrderId() throws SQLException, ClassNotFoundException;

    boolean saveOrders(MysqlxCrud.Order dto) throws SQLException, ClassNotFoundException;

    boolean saveOrders(PlaceOrderDto dto) throws SQLException, ClassNotFoundException;

    boolean updateOrders(MysqlxCrud.Order dto) throws SQLException, ClassNotFoundException;

    boolean updateOrders(PlaceOrderDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteOrders(String id) throws SQLException, ClassNotFoundException;

    PlaceOrderDto searchOrders(String id) throws SQLException, ClassNotFoundException;

    ArrayList<MysqlxCrud.Order> loadAllOrders() throws SQLException, ClassNotFoundException;
}
