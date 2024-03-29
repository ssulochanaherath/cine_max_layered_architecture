package lk.ijse.cinemax.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.cinemax.bo.BOFactory;
import lk.ijse.cinemax.bo.custom.SupplierBO;
import lk.ijse.cinemax.dto.SupplierDto;
import lk.ijse.cinemax.dto.tm.SupplierTm;
//import lk.ijse.cinemax.model.SupplierModel;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SupplierFormController {
    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.SUPPLIER);
    public TextField txtMovieSearch;
    public TableView tblSupplier;
    public TableColumn colSupplierId;
    public TableColumn colSupplierName;
    public TableColumn colSupplierAddress;
    public TableColumn colSupplierTele;
    public JFXTextField txtSupplierId;
    public JFXTextField txtSupplierName;
    public JFXTextField txtSupplierTele;
    public JFXTextField txtSupplierAddress;
    public Label txtDate;
    public Label txtTime;
    //private SupplierModel supplierModel = new SupplierModel();

    public void btnLogOutOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Login Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnCustomerOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/customer_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Customer Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnDashboardOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Customer Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnMoviesOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/movies_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Movies Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnTicketOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/ticket_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Ticket Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnSupplierOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/supplier_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Supplier Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnItemOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/item_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Item Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnReportOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/report_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Ticket Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnFoodOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/foods_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Foods Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void initialize() {
        setCellValueFactory();
        loadAllSupplier();
        setDate();
        setTime();

        generateSupplierId();
    }

    public void setDate(){
        txtDate.setText(String.valueOf(LocalDate.now()));
    }

    public void setTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        txtTime.setText(LocalTime.now().format(formatter));
    }

    private void loadAllSupplier() {
        //var supplierModel = new SupplierModel();

        ObservableList<SupplierTm> obList = FXCollections.observableArrayList();

        try {
            List<SupplierDto> dtoList = supplierBO.loadAllSuppliers();

            for (SupplierDto dto : dtoList) {
                obList.add(
                        new SupplierTm(
                                dto.getSupplierId(),
                                dto.getName(),
                                dto.getAddress(),
                                dto.getTele()
                        )
                );
            }
            tblSupplier.setItems(obList);
        } catch (SQLException e) {
            throw  new RuntimeException();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colSupplierName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSupplierAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSupplierTele.setCellValueFactory(new PropertyValueFactory<>("tele"));
    }

    private void generateSupplierId() {
        try {
            String lastSupplierId = supplierBO.generateSupplierId();

            String newSupplierId = generateNewSupplierId(lastSupplierId, "S");

            txtSupplierId.setText(newSupplierId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateNewSupplierId(String lastSupplierId, String S) {
        if (lastSupplierId == null || lastSupplierId.isEmpty()) {
            return S + "001";
        }

        int numericPart = Integer.parseInt(lastSupplierId.substring(1)) + 1;
        return String.format("%s%03d", S, numericPart);

    }

    public void btnSearchSupplierOnAction(MouseEvent mouseEvent) {
        String searchMovie  = txtMovieSearch.getText();

        try {
            SupplierDto supplierDto = supplierBO.searchSuppliers(searchMovie);

            if(supplierDto != null){
                txtSupplierId.setText(supplierDto.getSupplierId());
                txtSupplierName.setText(supplierDto.getName());
                txtSupplierAddress.setText(supplierDto.getAddress());
                txtSupplierTele.setText(supplierDto.getTele());
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Movie Not Found").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    public void btnDeleteOnAction(ActionEvent event) {
        String supplierId = txtSupplierId.getText();

        try {
            boolean isDeleted = supplierBO.deleteSuppliers(supplierId);

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Deleted Supplier!").show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Movie Not Deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        initialize();
    }

    public void btnUpdateOnAction(ActionEvent event) {
        String supplierId = txtSupplierId.getText();
        String name = txtSupplierName.getText();
        String address = txtSupplierAddress.getText();
        String tele = txtSupplierTele.getText();

        var dto = new SupplierDto(supplierId, name, address, tele);

        try {
            boolean isUpdated = supplierBO.updateSuppliers(dto);

            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Updated Supplier!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        initialize();
    }

    public void btnSaveOnAction(ActionEvent event) {
        String supplierId = txtSupplierId.getText();
        String name = txtSupplierName.getText();
        String address = txtSupplierAddress.getText();
        String tele = txtSupplierTele.getText();

        var dto = new SupplierDto(supplierId, name, address, tele);

        try {
            boolean isSaved = supplierBO.saveSuppliers(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Saved Supplier!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        initialize();
    }

    private void clearFields() {
        txtSupplierId.clear();
        txtSupplierName.clear();
        txtSupplierAddress.clear();
        txtSupplierTele.clear();
        txtMovieSearch.clear();
    }
}
