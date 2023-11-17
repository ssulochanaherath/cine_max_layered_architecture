package lk.ijse.cinemax.model;

import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.SupplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierModel {
    public String generateSupplierId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT supplierId FROM supplier ORDER BY supplierId DESC LIMIT 1";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                return  resultSet.getString(1);
            } else {
                return "";
            }
        }
    }

    public List<SupplierDto> loadAllSupplier() throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM supplier";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<SupplierDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(new SupplierDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        return dtoList;
    }

    public SupplierDto searchSupplier(String searchMovie) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM supplier WHERE supplierId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, searchMovie);

        ResultSet resultSet = pstm.executeQuery();

        SupplierDto dto = null;

        if (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String tele = resultSet.getString(4);

            dto = new SupplierDto(id, name, address, tele);
        }
        return dto;
    }

    public boolean deleteSupplier(String supplierId) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM supplier WHERE supplierId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, supplierId);

        return pstm.executeUpdate() > 0;
    }

    public boolean updateSupplier(SupplierDto dto) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE supplier SET name = ?, address = ?, tele = ? WHERE supplierId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getTele());
        pstm.setString(4, dto.getSupplierId());

        return pstm.executeUpdate() > 0;
    }

    public boolean saveSupplier(SupplierDto dto) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO supplier VALUES(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getSupplierId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getTele());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }
}
