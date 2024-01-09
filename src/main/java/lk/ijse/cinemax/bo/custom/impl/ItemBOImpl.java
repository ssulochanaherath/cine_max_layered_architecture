package lk.ijse.cinemax.bo.custom.impl;

import lk.ijse.cinemax.bo.custom.ItemBO;
import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.ItemDAO;
import lk.ijse.cinemax.dto.ItemDto;
import lk.ijse.cinemax.dto.tm.CartTm;
import lk.ijse.cinemax.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {


    public ArrayList<ItemDto> loadAllItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM item");
        ArrayList<ItemDto> itemList = new ArrayList<>();

        while(rst.next()){
            itemList.add(new ItemDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getInt(4)
            ));
        }
        return itemList;
    }


    public ItemDto searchItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM item WHERE code = ?", code);
        rst.next();
        return new ItemDto(
                rst.getString(1),
                rst.getString(2),
                rst.getDouble(3),
                rst.getInt(4)
        );
    }

    @Override
    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        boolean isSaved = SQLUtil.execute("INSERT INTO item VALUES(?,?,?,?)",
                dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
        return isSaved;
    }

    public boolean updateItem(ItemDto itemDto) throws SQLException, ClassNotFoundException {
        boolean isUpdated = SQLUtil.execute("UPDATE item SET description = ?, unit_price = ?, qty_on_hand = ? WHERE code = ?",
                itemDto.getDescription(),itemDto.getUnitPrice(),itemDto.getQtyOnHand(),itemDto.getCode());
        return isUpdated;
    }

    public boolean updateItem(ArrayList<CartTm> cartTmList) throws SQLException, ClassNotFoundException {
        for(CartTm tm : cartTmList) {
            System.out.println("Item: " + tm);
            if(!updateQtyItem(tm.getCode(), tm.getQty())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateQtyItem(String code, int qty) throws SQLException, ClassNotFoundException {
        boolean isUpdated = SQLUtil.execute("UPDATE item SET qty_on_hand = qty_on_hand - ? WHERE code = ?", qty, code);
        return isUpdated;
    }

    public String generateFoodId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM item ORDER BY code DESC LIMIT 1");

        if(rst.next()){
            String id = rst.getString(1);
            int newId = Integer.parseInt(id.replace("I", "")) + 1;
            return String.format("I%03d", newId);
        } else {
            return "I001";
        }



//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT code FROM item ORDER BY code DESC LIMIT 1";
//
//        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
//            ResultSet resultSet = pstm.executeQuery();
//
//            if (resultSet.next()) {
//                return  resultSet.getString(1);
//            } else {
//                return "";
//            }
//        }
    }

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM item WHERE code = ?", code);
    }

    public String getItemInfo(String column, String itemCode) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT " + column + " FROM item WHERE code = ?", itemCode);


//        String value = null;
//        try {
//            Connection connection = DbConnection.getInstance().getConnection();
//            String sql = "SELECT " + column + " FROM item WHERE code = ?";
//
//            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
//                pstm.setString(1, itemCode);
//
//                try (ResultSet resultSet = pstm.executeQuery()) {
//                    if (resultSet.next()) {
//                        value = resultSet.getString(column);
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle other SQLExceptions appropriately
//        }
//        return value;
    }
}
