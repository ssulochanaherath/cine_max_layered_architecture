package lk.ijse.cinemax.bo.custom.impl;

import lk.ijse.cinemax.bo.custom.ItemBO;
import lk.ijse.cinemax.dao.DAOFactory;
import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.ItemDAO;
import lk.ijse.cinemax.dto.ItemDto;
import lk.ijse.cinemax.dto.tm.CartTm;
import lk.ijse.cinemax.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDao = (ItemDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ITEM);
    public ArrayList<ItemDto> loadAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<Item> items = itemDao.loadAll();
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : items) {
            itemDtos.add(new ItemDto(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
        }
        return itemDtos;
    }


    public ItemDto searchItem(String code) throws SQLException, ClassNotFoundException {
        Item item = itemDao.search(code);
        ItemDto itemDto = new ItemDto(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
        return itemDto;
    }

    @Override
    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.save(new Item(dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
    }

    public boolean updateItem(ItemDto itemDto) throws SQLException, ClassNotFoundException {
        return itemDao.update(new Item(itemDto.getCode(), itemDto.getDescription(), itemDto.getUnitPrice(), itemDto.getQtyOnHand()));
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
        return itemDao.updateQty(code, qty);
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
        return itemDao.delete(code);
    }

    public String getItemInfo(String column, String itemCode) throws SQLException, ClassNotFoundException {
        return itemDao.getItemInfo(column, itemCode);

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
