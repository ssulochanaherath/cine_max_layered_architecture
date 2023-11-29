package lk.ijse.cinemax.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.cinemax.db.DbConnection;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {
    public Label txtDate;
    public Label txtSeatsCount;
    public Label txtMovieCount;
    public Label txtSuppliers;
    public Label txtFood;
    public Label txtQty;
    public Label txtFood1;
    public Label txtQty1;
    public Label txtFood2;
    public Label txtQty2;
    public Label txtFood3;
    public Label txtQty3;
    public Label txtFood4;
    public Label txtQty4;
    public Label txtTime;
    public Label txtUserName;


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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showUserName();
        availableSeats();
        setDate();
        setTime();
        availableMovies();
        availableSuppliers();

        showItemInfo("qty_on_hand", txtQty, "F001"); // for quantity
        showItemInfo("description", txtFood, "F001"); // for description
        showItemInfo("qty_on_hand", txtQty1, "F002"); // for quantity
        showItemInfo("description", txtFood1, "F002"); // for description
        showItemInfo("qty_on_hand", txtQty2, "F003"); // for quantity
        showItemInfo("description", txtFood2, "F003"); // for description
        showItemInfo("qty_on_hand", txtQty3, "F004"); // for quantity
        showItemInfo("description", txtFood3, "F004"); // for description
        showItemInfo("qty_on_hand", txtQty4, "F005"); // for quantity
        showItemInfo("description", txtFood4, "F005"); // for description
    }

    private void showUserName() {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT fristName FROM user WHERE userId = 'U001'";
            try (PreparedStatement pstm = connection.prepareStatement(sql);
                 ResultSet resultSet = pstm.executeQuery()) {

                if (resultSet.next()) {
                    String fristName = resultSet.getString(1);
                    txtUserName.setText(String.valueOf(fristName));
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "No available seats found.");
                    alert.show();
                }
            }
        } catch (SQLException e) {
            if (e instanceof SQLNonTransientConnectionException) {
                // Handle connection closed exception
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error accessing database: Connection closed.");
                alert.show();
            } else {
                e.printStackTrace(); // Handle other SQLExceptions appropriately
                Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected database error occurred.");
                alert.show();
            }
        }
    }

    private void availableSuppliers() {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT COUNT(*) FROM supplier";
            try (PreparedStatement pstm = connection.prepareStatement(sql);
                 ResultSet resultSet = pstm.executeQuery()) {

                if (resultSet.next()) {
                    int availableSeatsCount = resultSet.getInt(1);
                    txtSuppliers.setText(String.valueOf(availableSeatsCount));
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "No available seats found.");
                    alert.show();
                }
            }
        } catch (SQLException e) {
            if (e instanceof SQLNonTransientConnectionException) {
                // Handle connection closed exception
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error accessing database: Connection closed.");
                alert.show();
            } else {
                e.printStackTrace(); // Handle other SQLExceptions appropriately
                Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected database error occurred.");
                alert.show();
            }
        }
    }

    private void showItemInfo(String column, Label targetTextField, String itemCode) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT " + column + " FROM item WHERE code = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, itemCode);

                try (ResultSet resultSet = pstm.executeQuery()) {
                    if (resultSet.next()) {
                        String value = resultSet.getString(column);
                        targetTextField.setText(String.valueOf(value));
                    } else {
                        System.out.println("No data found for item with code: " + itemCode);
                        // Display a message without showing an error alert
                        targetTextField.setText("N/A");
                    }
                }
            }
        } catch (SQLException e) {
            if (e instanceof SQLNonTransientConnectionException) {
                // Handle connection closed exception
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error accessing database: Connection closed.");
                alert.show();
            } else {
                e.printStackTrace(); // Handle other SQLExceptions appropriately
                Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected database error occurred.");
                alert.show();
            }
        }
    }

    private void availableMovies() {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT COUNT(*) FROM movie";
            try (PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery()) {

                if (resultSet.next()) {
                    int availableMoviesCount = resultSet.getInt(1);
                    txtMovieCount.setText(String.valueOf(availableMoviesCount));
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "No available movies found.");
                    alert.show();
                }
            }
        } catch (SQLException e) {
            if (e instanceof SQLNonTransientConnectionException) {
                // Handle connection closed exception
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error accessing database: Connection closed.");
                alert.show();
            } else {
                e.printStackTrace(); // Handle other SQLExceptions appropriately
                Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected database error occurred.");
                alert.show();
            }
        }
    }

    public void availableSeats() {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT COUNT(*) FROM seats WHERE status = 'available'";
            try (PreparedStatement pstm = connection.prepareStatement(sql);
                 ResultSet resultSet = pstm.executeQuery()) {

                if (resultSet.next()) {
                    int availableSeatsCount = resultSet.getInt(1);
                    txtSeatsCount.setText(String.valueOf(availableSeatsCount));
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "No available seats found.");
                    alert.show();
                }
            }
        } catch (SQLException e) {
            if (e instanceof SQLNonTransientConnectionException) {
                // Handle connection closed exception
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error accessing database: Connection closed.");
                alert.show();
            } else {
                e.printStackTrace(); // Handle other SQLExceptions appropriately
                Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected database error occurred.");
                alert.show();
            }
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
