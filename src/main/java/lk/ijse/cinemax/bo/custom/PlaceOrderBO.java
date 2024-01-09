package lk.ijse.cinemax.bo.custom;

import lk.ijse.cinemax.bo.SuperBO;
import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.PlaceOrderDto;
import lk.ijse.cinemax.entity.PlaceOrder;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO extends SuperBO {

    boolean savePlaceOrder(PlaceOrderDto dto) throws SQLException, ClassNotFoundException;

    boolean updatePlaceOrder(PlaceOrderDto dto) throws SQLException, ClassNotFoundException;

    boolean deletePlaceOrder(String id) throws SQLException, ClassNotFoundException;

    PlaceOrderDto searchPlaceOrder(String id) throws SQLException, ClassNotFoundException;

    ArrayList<PlaceOrderDto> loadAllPlaceOrder() throws SQLException, ClassNotFoundException;

    public boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException;
}
