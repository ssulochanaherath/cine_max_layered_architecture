package lk.ijse.cinemax.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.cinemax.dto.CustomerDto;
import lk.ijse.cinemax.dto.tm.CustomerTm;
import lk.ijse.cinemax.model.CustomerModel;

import java.sql.SQLException;
import java.util.List;

public class CustomerFormController {
    public TableView<CustomerTm>tblCustomer;
    public TableColumn colUserId;
    public TableColumn colCustomerId;
    public TableColumn colCustomerName;
    public TableColumn colCustomerAddress;
    public TableColumn colCustomerTele;
    public JFXTextField txtCustomerId;
    public JFXTextField txtCustomerName;
    public JFXTextField txtCustomerTelephone;
    public JFXTextField txtCustomerAddress;
    public JFXTextField txtUserId;

    private CustomerModel cusModel = new CustomerModel();

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

    public void btnSaveOnAction(ActionEvent event) {
        String userId = txtUserId.getText();
        String customerId = txtCustomerId.getText();
        String customerName = txtCustomerName.getText();
        String customerAddress = txtCustomerAddress.getText();
        String customerTelephone = txtCustomerTelephone.getText();

        var dto = new CustomerDto(userId,customerId,customerName,customerAddress,customerTelephone);

        try {
            boolean isSaved = cusModel.saveCustomer(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Saved Customer!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        initialize();
    }

    public void initialize() {
        setCellValueFctory();
        loadAllCustomer();
    }

    private void loadAllCustomer() {
        var model = new CustomerModel();

        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

        try {
            List<CustomerDto> dtoList = model.getAllCustomer();

            for (CustomerDto dto : dtoList) {
                obList.add(
                        new CustomerTm(
                                dto.getUserId(),
                                dto.getCustomerId(),
                                dto.getCustomerName(),
                                dto.getCustomerAddress(),
                                dto.getCustomerTelephone()
                        )
                );
            }
            tblCustomer.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFctory() {
        colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        colCustomerTele.setCellValueFactory(new PropertyValueFactory<>("customerTelephone"));
    }

    private void clearFields() {
    }

    public void btnUpdateOnAction(ActionEvent event) {
    }

    public void btnDeleteOnAction(ActionEvent event) {
    }

    public void btnClearOnAction(ActionEvent event) {
    }

    public void cmbUserIdOnAction(ActionEvent event) {
    }
}
