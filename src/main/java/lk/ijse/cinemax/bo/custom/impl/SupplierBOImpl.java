package lk.ijse.cinemax.bo.custom.impl;

import lk.ijse.cinemax.bo.custom.SupplierBO;
import lk.ijse.cinemax.dao.DAOFactory;
import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.SupplierDAO;
import lk.ijse.cinemax.dto.SupplierDto;
import lk.ijse.cinemax.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.SUPPLIER);
    public String generateSupplierId() throws SQLException, ClassNotFoundException {
        return supplierDAO.generateSupplierId();
//        ResultSet rst =  SQLUtil.execute("SELECT supplierId FROM supplier ORDER BY supplierId DESC LIMIT 1");
//
//        if (rst.next()){
//            String id = rst.getString(1);
//            int newId = Integer.parseInt(id.replace("S", "")) + 1;
//            return String.format("S%03d", newId);
//        } else {
//            return "S001";
//        }
    }

    public ArrayList<SupplierDto> loadAllSuppliers() throws SQLException, ClassNotFoundException {
        ArrayList<Supplier> supplier = supplierDAO.loadAll();
        ArrayList<SupplierDto> supplierDTOS = new ArrayList<>();
        for (Supplier s : supplier) {
            supplierDTOS.add(new SupplierDto(s.getSupplierId(), s.getName(), s.getAddress(), s.getTele()));
        }
        return supplierDTOS;
//        ResultSet rst = SQLUtil.execute("SELECT * FROM supplier");
//        ArrayList<SupplierDto> suppliers = new ArrayList<>();
//
//        while (rst.next()){
//            suppliers.add(new SupplierDto(
//                    rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getString(4)
//            ));
//        }
//        return suppliers;
    }

    public SupplierDto searchSuppliers(String searchMovie) throws SQLException, ClassNotFoundException {
        Supplier supplier = supplierDAO.search(searchMovie);
        SupplierDto supplierDto = new SupplierDto(supplier.getSupplierId(), supplier.getName(), supplier.getAddress(), supplier.getTele());
        return supplierDto;
//        ResultSet rst = SQLUtil.execute("SELECT * FROM supplier WHERE supplierId = ?", searchMovie);
//        rst.next();
//        return new SupplierDto(searchMovie, rst.getString(2), rst.getString(3), rst.getString(4));
    }

    public boolean deleteSuppliers(String supplierId) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(supplierId);
//        return SQLUtil.execute("DELETE FROM supplier WHERE supplierId = ?", supplierId);
    }

    public boolean updateSuppliers(SupplierDto dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(new Supplier(
                dto.getSupplierId(),
                dto.getName(),
                dto.getAddress(),
                dto.getTele()
        ));
//        return SQLUtil.execute("UPDATE supplier SET name = ?, address = ?, tele = ? WHERE supplierId = ?",
//                dto.getName(), dto.getAddress(), dto.getTele(), dto.getSupplierId());
    }

    public boolean saveSuppliers(SupplierDto dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.save(new Supplier(
                dto.getSupplierId(),
                dto.getName(),
                dto.getAddress(),
                dto.getTele()
        ));
//        return SQLUtil.execute("INSERT INTO supplier VALUES(?,?,?,?)",
//                dto.getSupplierId(),dto.getName(),dto.getAddress(),dto.getTele());
    }

    public int getAvailableSuppliersCount() throws SQLException, ClassNotFoundException {
        return supplierDAO.getAvailableSuppliersCount();
//        int count = 0;
//        ResultSet rst = SQLUtil.execute("SELECT COUNT(*) FROM supplier");
//        try {
//            if (rst.next()) {
//                count = rst.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle other SQLExceptions appropriately
//        }
//        return count;

//        try {
//            Connection connection = DbConnection.getInstance().getConnection();
//            String sql = "SELECT COUNT(*) FROM supplier";
//            try (PreparedStatement pstm = connection.prepareStatement(sql);
//                 ResultSet resultSet = pstm.executeQuery()) {
//
//                if (resultSet.next()) {
//                    count = resultSet.getInt(1);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle other SQLExceptions appropriately
//        }
//        return count;
    }
}
