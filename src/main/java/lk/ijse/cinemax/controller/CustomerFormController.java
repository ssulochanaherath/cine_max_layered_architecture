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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import lk.ijse.cinemax.bo.BOFactory;
import lk.ijse.cinemax.bo.custom.CustomerBO;
import lk.ijse.cinemax.bo.custom.SignUpBO;
import lk.ijse.cinemax.dto.CustomerDto;
import lk.ijse.cinemax.dto.SignUpDto;
import lk.ijse.cinemax.dto.tm.CustomerTm;
import lk.ijse.cinemax.entity.Customer;
//import lk.ijse.cinemax.model.CustomerModel;
//import lk.ijse.cinemax.model.SignUpModel;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerFormController {

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.CUSTOMER);
    SignUpBO signUpBO = (SignUpBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.SIGNUP);
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
//    public JFXTextField txtUserId;
    public TextField txtCustomerSearch;

    public JFXComboBox<String> txtUserId;
    public Rectangle recCustomerManagement;
    public Label txtDate;
    public Label txtTime;
    public JFXTextField txtCustomerEmail;
    public TableColumn colCustomerEmail;

//    private CustomerModel cusModel = new CustomerModel();
//    private SignUpModel signUpModel = new SignUpModel();

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
        String userId = txtUserId.getValue();
        String customerId = txtCustomerId.getText();
        String customerName = txtCustomerName.getText();
        String customerAddress = txtCustomerAddress.getText();
        String customerTelephone = txtCustomerTelephone.getText();
        String customerEmail = txtCustomerEmail.getText();

        String telephoneRegex = "^\\d{10}$"; // Assumes a 10-digit phone number; you can adjust the pattern as needed

        if (!customerTelephone.matches(telephoneRegex)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Telephone Number! Please enter a 10-digit number.").show();
            return; // Don't proceed with saving if the telephone number is invalid
        }

        var dto = new CustomerDto(userId,customerId,customerName,customerAddress,customerTelephone,customerEmail);

        try {
            boolean isSaved = customerBO.saveCustomer(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Saved Customer!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        initialize();
    }

    public void initialize() {
        setCellValueFctory();
        loadAllCustomer();
        loadAllUserIds();

        generateCustomerid();
        setDate();
        setTime();
    }

    private void generateCustomerid(){
        try {
            String lastId = customerBO.getLastCustomerId();

            String newId = generateNextId(lastId, "C");

            txtCustomerId.setText(newId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateNextId(String lastId, String C) {
        if (lastId == null || lastId.isEmpty()) {
            return C + "001";
        }

        int numericPart = Integer.parseInt(lastId.substring(1)) + 1;
        return String.format("%s%03d", C, numericPart);
    }

    private void loadAllUserIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<SignUpDto> idLIst = SignUpBO.loadAll();

            for (SignUpDto dto : idLIst) {
                obList.add(dto.getUserId());
            }
            txtUserId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAllCustomer() {
        //var model = new CustomerModel();

        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

        try {
            ArrayList<Customer> dtoList = customerBO.getAllCustomer();

            for (Customer dto : dtoList) {
                obList.add(
                        new CustomerTm(
                                dto.getUserId(),
                                dto.getCustomerId(),
                                dto.getCustomerName(),
                                dto.getCustomerAddress(),
                                dto.getCustomerTelephone(),
                                dto.getCustomerEmail()
                        )
                );
            }
            tblCustomer.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFctory() {
        colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        colCustomerTele.setCellValueFactory(new PropertyValueFactory<>("customerTelephone"));
        colCustomerEmail.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
    }

    private void clearFields() {
        txtUserId.setValue(null);
        txtCustomerId.clear();
        txtCustomerName.clear();
        txtCustomerAddress.clear();
        txtCustomerTelephone.clear();
        txtCustomerSearch.clear();
        txtCustomerEmail.clear();
    }

    public void btnUpdateOnAction(ActionEvent event) {
        String userId = txtUserId.getValue();
        String customerId = txtCustomerId.getText();
        String customerName = txtCustomerName.getText();
        String customerAddress = txtCustomerAddress.getText();
        String customerTelephone = txtCustomerTelephone.getText();
        String customerEmail = txtCustomerEmail.getText();

        var dto = new CustomerDto(userId,customerId,customerName,customerAddress,customerTelephone,customerEmail);

        try {
            boolean isUpdated = customerBO.updateCustomer(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Updated Customer!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        initialize();
    }

    public void btnDeleteOnAction(ActionEvent event) {
        String customerId = txtCustomerId.getText();

        try {
            boolean isDeleted = customerBO.deleteCustomer(customerId);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Deleted Customer!").show();
                loadAllCustomer();
                clearFields();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    public void btnSearchCustomerOnAction(MouseEvent mouseEvent) {
        String seachId = txtCustomerSearch.getText();

        try {
            CustomerDto customerDto = customerBO.searchCustomer(seachId);

            if (customerDto != null) {
                txtUserId.setValue(customerDto.getUserId());
                txtCustomerId.setText(customerDto.getCustomerId());
                txtCustomerName.setText(customerDto.getCustomerName());
                txtCustomerAddress.setText(customerDto.getCustomerAddress());
                txtCustomerTelephone.setText(customerDto.getCustomerTelephone());
                txtCustomerEmail.setText(customerDto.getCustomerEmail());
            } else {
                new Alert(Alert.AlertType.WARNING, "Customer not Found!").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDate(){
        txtDate.setText(String.valueOf(LocalDate.now()));
    }

    public void setTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        txtTime.setText(LocalTime.now().format(formatter));
    }
}
