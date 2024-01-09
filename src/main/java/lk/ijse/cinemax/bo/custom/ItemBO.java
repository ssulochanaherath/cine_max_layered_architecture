package lk.ijse.cinemax.bo.custom;

import lk.ijse.cinemax.bo.SuperBO;
import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.CustomerDto;
import lk.ijse.cinemax.dto.ItemDto;
import lk.ijse.cinemax.dto.tm.CartTm;
import lk.ijse.cinemax.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

    ItemDto searchItem(String id) throws SQLException, ClassNotFoundException;

    ArrayList<ItemDto> loadAllItem() throws SQLException, ClassNotFoundException;

    public boolean updateItem(ArrayList<CartTm> cartTmList) throws SQLException, ClassNotFoundException;

    public boolean updateQtyItem(String code, int qty) throws SQLException, ClassNotFoundException;

    public String generateFoodId() throws SQLException, ClassNotFoundException;

    public String getItemInfo(String column, String itemCode) throws SQLException, ClassNotFoundException;
}
