package lk.ijse.cinemax.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.cinemax.bo.BOFactory;
import lk.ijse.cinemax.bo.custom.CustomerBO;
import lk.ijse.cinemax.bo.custom.ItemBO;
import lk.ijse.cinemax.bo.custom.OrderBO;
import lk.ijse.cinemax.bo.custom.PlaceOrderBO;
import lk.ijse.cinemax.dto.CustomerDto;
import lk.ijse.cinemax.dto.ItemDto;
import lk.ijse.cinemax.dto.PlaceOrderDto;
import lk.ijse.cinemax.dto.tm.CartTm;
import lk.ijse.cinemax.entity.Customer;
//import lk.ijse.cinemax.model.CustomerModel;
//import lk.ijse.cinemax.model.ItemModel;
//import lk.ijse.cinemax.model.OrderModel;
//import lk.ijse.cinemax.model.PlaceOrderModel;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FoodsFormController {
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.CUSTOMER);
    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.ITEM);
    OrderBO orderBO = (OrderBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.ORDER);
    PlaceOrderBO placeOrderBO = (PlaceOrderBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.PLACEORDER);
    public JFXTextField txtQty;
    public JFXButton btnAddToCart;
    public TableView tblOrderCart;
    public TableColumn colItemCode;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public TableColumn colTotal;
    public JFXTextField txtOrderId;
    //public JFXTextField txtDate;
    public JFXTextField txtDescription;
    public JFXTextField txtUnitPrice;
    public JFXTextField txtQtyOnHand;
    public JFXTextField txtCustomerName;
    public JFXTextField txtNetTotal;
    public TextField txtSearchOrder;
    public Label txtTime;
    public Label txtDate;
    public JFXTextField txtCustomerEmail;
    private Label lblCustomerName;
    private Label lblDescription;
    private Label lblOrderDate;
    private Label lblOrderId;
    private Label lblQtyOnHand;
    private Label lblUnitPrice;
    private Label lblNetTotal;

    public JFXComboBox<String> cmbCustomerId;
    public JFXComboBox<String> cmbItemCode;
//    private CustomerModel customerModel = new CustomerModel();
//    private ItemModel itemModel = new ItemModel();
//    private OrderModel orderModel = new OrderModel();
//    private PlaceOrderModel placeOrderModel = new PlaceOrderModel();
    private ObservableList<CartTm> obList = FXCollections.observableArrayList();

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

    public void btnFoodsManageOnAction(ActionEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/foods_manage_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Foods Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }
    public void initialize() {
        setCellValueFactory();
        generateOrderId();
        setDate();
        setTime();
        loadCustomerIds();
        loadItemCodes();
    }

    public void setDate(){
        txtDate.setText(String.valueOf(LocalDate.now()));
    }

    public void setTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        txtTime.setText(LocalTime.now().format(formatter));
    }

    private void loadItemCodes() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<ItemDto> itemDtos = itemBO.loadAllItem();

            for (ItemDto dto : itemDtos) {
                obList.add(dto.getCode());
            }
            cmbItemCode.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCustomerIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            ArrayList<Customer> idList = customerBO.getAllCustomer();

            for (Customer dto : idList) {
                obList.add(dto.getUserId());
            }

            cmbCustomerId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateOrderId() {
        try {

            String lastId = orderBO.getLastOrderId();
            if(lastId != null){
                String newId = generateNextOrderId(lastId, "O");
                txtOrderId.setText(newId);
            }else{
                System.out.println("Last order id is null");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateNextOrderId(String lastId, String prefix){
        if(lastId == null || lastId.isEmpty()){
            return prefix + "001";
        }

        int numericPart = Integer.parseInt(lastId.substring(1)) + 1;
        return String.format("%s%03d", prefix, numericPart);
    }

    private void setCellValueFactory() {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("tot"));
    }

    public void btnAddToCartOnAction(ActionEvent event) {
        String code = cmbItemCode.getValue();
        String description = txtDescription.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        double tot = unitPrice * qty;

        if (!obList.isEmpty()) {
            for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
                if (colItemCode.getCellData(i).equals(code)) {
                    int col_qty = (int) colQty.getCellData(i);
                    qty += col_qty;
                    tot = unitPrice * qty;

                    obList.get(i).setQty(qty);
                    obList.get(i).setTot(tot);

                    calculateTotal();
                    tblOrderCart.refresh();
                    return;
                }
            }
        }
        var cartTm = new CartTm(code, description, qty, unitPrice, tot);

        obList.add(cartTm);

        tblOrderCart.setItems(obList);
        calculateTotal();
        txtQty.clear();
    }
    private void calculateTotal() {
        double total = 0;
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            total += (double) colTotal.getCellData(i);
        }
        txtNetTotal.setText(String.valueOf(total));
    }

    public void btnPlaceOrderOnAction(ActionEvent event) {
        String orderId = txtOrderId.getText();
        LocalDate date = LocalDate.parse(txtDate.getText());
        String customerId = cmbCustomerId.getValue();

        List<CartTm> cartTmList = new ArrayList<>();
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            CartTm cartTm = obList.get(i);

            cartTmList.add(cartTm);
        }

        //System.out.println("Place order form controller: " + cartTmList);
        var placeOrderDto = new PlaceOrderDto(orderId, date, customerId, cartTmList);
        try {
            boolean isSuccess = placeOrderBO.placeOrder(placeOrderDto);
            if (isSuccess) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order Success!").show();

                sendOrderConfirmationEmail(customerId, placeOrderDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendOrderConfirmationEmail(String customerId, PlaceOrderDto placeOrderDto) {
        // Replace placeholders with your actual email configurations
        String username = "hallwembley@gmail.com";
        String password = "nopvwkcbxpxhvjji";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(String.valueOf(txtCustomerEmail.getText())));
            message.setSubject("Order Confirmation");

            // Customize the email body based on your requirements
            String emailBody = "Thank you for placing your order with us.\n\n";
            emailBody += "Order ID: " + placeOrderDto.getOrderId() + "\n";
            emailBody += "Date: " + placeOrderDto.getDate() + "\n";
            emailBody += "\n\nDetails of your order:\n";

            for (CartTm cartTm : placeOrderDto.getCartTmList()) {
                emailBody += "Item: " + cartTm.getCode() + "\n";
                emailBody += "Description: " + cartTm.getDescription() + "\n";
                emailBody += "Quantity: " + cartTm.getQty() + "\n";
                emailBody += "Unit Price: " + cartTm.getUnitPrice() + "\n";
                emailBody += "Total: " + cartTm.getTot() + "\n\n";
            }

            message.setText(emailBody);

            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void cmbItemOnAction(ActionEvent event) {
        String code = cmbItemCode.getValue();

        txtQty.requestFocus();
        try {
            ItemDto dto = itemBO.searchItem(code);
            txtDescription.setText(dto.getDescription());
            txtUnitPrice.setText(String.valueOf(dto.getUnitPrice()));
            txtQtyOnHand.setText(String.valueOf(dto.getQtyOnHand()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void txtQtyOnAction(ActionEvent event) {
        btnAddToCartOnAction(event);
    }

    public void cmbCustomerOnAction(ActionEvent event) {
        String id = cmbCustomerId.getValue();
//        CustomerModel customerModel = new CustomerModel();
        try {
            CustomerDto customerDto = customerBO.searchCustomer(id);
            txtCustomerName.setText(customerDto.getCustomerName());
            txtCustomerEmail.setText(customerDto.getCustomerEmail());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnNewOrderOnAction(ActionEvent event) throws Exception{
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
}
