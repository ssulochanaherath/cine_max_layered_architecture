package lk.ijse.cinemax.dao.custom;

import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dao.SuperDAO;
import lk.ijse.cinemax.entity.Supplier;

import java.sql.SQLException;

public interface SupplierDAO extends CrudDAO<Supplier> {
    String generateSupplierId() throws SQLException, ClassNotFoundException;

    int getAvailableSuppliersCount() throws SQLException, ClassNotFoundException;
}
