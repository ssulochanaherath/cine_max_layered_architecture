package lk.ijse.cinemax.dao.custom;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lk.ijse.cinemax.dao.CrudDAO;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO extends CrudDAO<MysqlxCrud.Order> {
    boolean save(String orderId, String customerId, LocalDate date) throws SQLException, ClassNotFoundException;

    String splitOrderId(String currentOrderId);

    String getLastOrderId() throws SQLException, ClassNotFoundException;
}
