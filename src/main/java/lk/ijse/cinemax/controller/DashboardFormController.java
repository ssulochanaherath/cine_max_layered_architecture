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
import lk.ijse.cinemax.model.*;

import java.io.IOException;
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

    private void availableSuppliers() {
        try {
            SupplierModel supplierModel = new SupplierModel();
            int availableSuppliersCount = supplierModel.getAvailableSuppliersCount();

            if (availableSuppliersCount > 0) {
                txtSuppliers.setText(String.valueOf(availableSuppliersCount));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No available suppliers found.");
                alert.show();
            }
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected error occurred.");
            alert.show();
        }
    }

    private void showItemInfo(String column, Label targetTextField, String itemCode) {
        try {
            ItemModel itemModel = new ItemModel();
            String value = itemModel.getItemInfo(column, itemCode);

            if (value != null) {
                targetTextField.setText(value);
            } else {
                System.out.println("No data found for item with code: " + itemCode);
                // Display a message without showing an error alert
                targetTextField.setText("N/A");
            }
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected error occurred.");
            alert.show();
        }
    }

    private void availableMovies() {
        try {
            MovieModel movieModel = new MovieModel();
            int availableMoviesCount = movieModel.getAvailableMoviesCount();

            if (availableMoviesCount > 0) {
                txtMovieCount.setText(String.valueOf(availableMoviesCount));
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "No available movies found.");
                alert.show();
            }
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected error occurred.");
            alert.show();
        }
    }

    public void availableSeats() {
        try {
            SeatModel seatModel = new SeatModel();
            int availableSeatsCount = seatModel.getAvailableSeatsCount();

            if (availableSeatsCount > 0) {
                txtSeatsCount.setText(String.valueOf(availableSeatsCount));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No available seats found.");
                alert.show();
            }
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected error occurred.");
            alert.show();
        }
    }

    public void setDate(){
        txtDate.setText(String.valueOf(LocalDate.now()));
    }

    public void setTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        txtTime.setText(LocalTime.now().format(formatter));
    }

    public void btnMovieNavigateOnAction(MouseEvent event) throws Exception {
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
}
