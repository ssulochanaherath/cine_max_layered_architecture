package lk.ijse.cinemax.dao.custom;

import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.tm.CartTm;
import lk.ijse.cinemax.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item> {
    public String generateFoodId() throws SQLException, ClassNotFoundException;

    public String getItemInfo(String column, String itemCode) throws SQLException, ClassNotFoundException;

    public boolean updateItem(ArrayList<CartTm> cartTmList) throws SQLException, ClassNotFoundException;
    public boolean updateQty(String code, int qty) throws SQLException, ClassNotFoundException;
}
