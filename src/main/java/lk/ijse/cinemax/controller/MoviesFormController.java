package lk.ijse.cinemax.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.cinemax.dto.MovieDto;
import lk.ijse.cinemax.model.MovieModel;
import lk.ijse.cinemax.model.TicketModel;
import javafx.scene.image.Image;

import java.net.URL;
import java.sql.*;

import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MoviesFormController implements Initializable {
    public TextField txtMovieName;
    public ImageView imgOne;
    public ImageView imgTwo;
    public ImageView imgThree;
    public ImageView imgFour;
    public ImageView imgFive;
    public ImageView imgSix;
    public Label txtDate;
    public Label txtTime;
    private TicketModel ticketModel = new TicketModel();
    private MovieModel movieModel = new MovieModel();
    private MovieDto movieDto = new MovieDto();

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

    public void btnMissionImpossibleOnAction(MouseEvent event) throws Exception {
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/mission_impossible_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Avengers Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }


    public void btnAvengersOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/avengers_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Avengers Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnPiratesOfTheCarribeanOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/pirates_caribean_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Pirates of the Caribbean Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnTopGunOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/topgun_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Top Gun Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnSherlockHolmesOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/sherlock_holmes_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Sherlock Holmes Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnHobbitOnAction(MouseEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/hobbit_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("The Hobbit Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnSearchOnAction(MouseEvent event) {
        String txtMovie = txtMovieName.getText();

        if ("Mission Impossible".equals(txtMovie)) {
            try {
                Node source = (Node) event.getSource();
                Stage oldStage = (Stage) source.getScene().getWindow();

                Parent rootNode = FXMLLoader.load(getClass().getResource("/view/mission_impossible_form.fxml"));
                Scene scene = new Scene(rootNode);
                Stage newStage = new Stage();
                newStage.setTitle("Avengers Form");
                newStage.setScene(scene);
                newStage.show();

                oldStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("Avengers".equals(txtMovie)) {
            try {
                Node source = (Node) event.getSource();
                Stage oldStage = (Stage) source.getScene().getWindow();

                Parent rootNode = FXMLLoader.load(getClass().getResource("/view/avengers_form.fxml"));
                Scene scene = new Scene(rootNode);
                Stage newStage = new Stage();
                newStage.setTitle("Avengers Form");
                newStage.setScene(scene);
                newStage.show();

                oldStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("Pirates of the Caribbean".equals(txtMovie)) {
            try {
                Node source = (Node) event.getSource();
                Stage oldStage = (Stage) source.getScene().getWindow();

                Parent rootNode = FXMLLoader.load(getClass().getResource("/view/pirates_caribean_form.fxml"));
                Scene scene = new Scene(rootNode);
                Stage newStage = new Stage();
                newStage.setTitle("Avengers Form");
                newStage.setScene(scene);
                newStage.show();

                oldStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ("Top Gun".equals(txtMovie)) {
            try {
                Node source = (Node) event.getSource();
                Stage oldStage = (Stage) source.getScene().getWindow();

                Parent rootNode = FXMLLoader.load(getClass().getResource("/view/topgun_form.fxml"));
                Scene scene = new Scene(rootNode);
                Stage newStage = new Stage();
                newStage.setTitle("Avengers Form");
                newStage.setScene(scene);
                newStage.show();

                oldStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ("Sherlock Holmes".equals(txtMovie)) {
            try {
                Node source = (Node) event.getSource();
                Stage oldStage = (Stage) source.getScene().getWindow();

                Parent rootNode = FXMLLoader.load(getClass().getResource("/view/sherlock_holmes_form.fxml"));
                Scene scene = new Scene(rootNode);
                Stage newStage = new Stage();
                newStage.setTitle("Avengers Form");
                newStage.setScene(scene);
                newStage.show();

                oldStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ("Hobbit".equals(txtMovie)) {
            try {
                Node source = (Node) event.getSource();
                Stage oldStage = (Stage) source.getScene().getWindow();

                Parent rootNode = FXMLLoader.load(getClass().getResource("/view/hobbit_form.fxml"));
                Scene scene = new Scene(rootNode);
                Stage newStage = new Stage();
                newStage.setTitle("Avengers Form");
                newStage.setScene(scene);
                newStage.show();

                oldStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void btnMovieManagementOnAction(ActionEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/movie_management_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Movie Mangement Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Load the default image when the interface is loaded

        loadImageAvengers();
        loadImageMission();
        loadImagePirates();
        loadImageTopGun();
        loadImageSherlock();
        loadImageHobbit();

        setDate();
        setTime();
    }

    private void loadImageHobbit() {
        try {
            byte[] imageBytes = MovieModel.getImageData("Hobbit");

            if (imageBytes != null) {
                Image image = new Image(new ByteArrayInputStream(imageBytes));
                imgSix.setImage(image);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private void loadImageSherlock() {
        try {
            byte[] imageBytes = MovieModel.getImageData("Sherlock");

            if (imageBytes != null) {
                Image image = new Image(new ByteArrayInputStream(imageBytes));
                imgFive.setImage(image);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private void loadImageTopGun() {
        try {
            byte[] imageBytes = MovieModel.getImageData("Top Gun");

            if (imageBytes != null) {
                Image image = new Image(new ByteArrayInputStream(imageBytes));
                imgFour.setImage(image);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private void loadImagePirates() {
        try {
            byte[] imageBytes = MovieModel.getImageData("Pirates");

            if (imageBytes != null) {
                Image image = new Image(new ByteArrayInputStream(imageBytes));
                imgThree.setImage(image);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private void loadImageMission() {
        try {
            byte[] imageBytes = MovieModel.getImageData("Mission Impossible");

            if (imageBytes != null) {
                Image image = new Image(new ByteArrayInputStream(imageBytes));
                imgTwo.setImage(image);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private void loadImageAvengers() {
        try {
            byte[] imageBytes = MovieModel.getImageData("Avengers");

            if (imageBytes != null) {
                Image image = new Image(new ByteArrayInputStream(imageBytes));
                imgOne.setImage(image);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }


    private void handleSQLException(SQLException e) {
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


    public void setDate(){
        txtDate.setText(String.valueOf(LocalDate.now()));
    }

    public void setTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        txtTime.setText(LocalTime.now().format(formatter));
    }
}
