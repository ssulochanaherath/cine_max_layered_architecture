package lk.ijse.cinemax.bo.custom;

import lk.ijse.cinemax.bo.SuperBO;
import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.SupplierDto;
import lk.ijse.cinemax.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {
    boolean saveSuppliers(SupplierDto dto) throws SQLException, ClassNotFoundException;

    boolean updateSuppliers(SupplierDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteSuppliers(String id) throws SQLException, ClassNotFoundException;

    SupplierDto searchSuppliers(String id) throws SQLException, ClassNotFoundException;

    ArrayList<SupplierDto> loadAllSuppliers() throws SQLException, ClassNotFoundException;

    String generateSupplierId() throws SQLException, ClassNotFoundException;

    int getAvailableSuppliersCount() throws SQLException, ClassNotFoundException;
}
