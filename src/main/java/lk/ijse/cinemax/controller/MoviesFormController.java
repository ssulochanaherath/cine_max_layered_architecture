package lk.ijse.cinemax.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.MovieDto;
import lk.ijse.cinemax.model.MovieModel;
import lk.ijse.cinemax.model.TicketModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.URL;
import java.sql.*;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MoviesFormController implements Initializable {
    public TextField txtMovieName;
    public ImageView imgAvengers;
    public ImageView imgMissionImpossible;
    public ImageView imgTopGun;
    public ImageView imgSherlockHolmes;
    public ImageView imgHobbit;
    public ImageView imgPirates;
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
        loadAvengersImage();
        loadMissionImpossibleImage();
        loadPiratesImage();
        loadTopGunImage();
        loadSherlockImage();
        loadHobbitImage();
    }

    private void loadAvengersImage() {
        // You can set a default image path or URL
        String defaultImagePath = "/images/Avengers.jpg";

        // Load the image and set it to the ImageView
        Image defaultImage = new Image(getClass().getResourceAsStream(defaultImagePath));
        imgAvengers.setImage(defaultImage);
    }

    private void loadMissionImpossibleImage() {
        // You can set a default image path or URL
        String defaultImagePath = "/images/Mission-Impossible.jpg";

        // Load the image and set it to the ImageView
        Image defaultImage = new Image(getClass().getResourceAsStream(defaultImagePath));
        imgMissionImpossible.setImage(defaultImage);
    }

    private void loadPiratesImage() {
        // You can set a default image path or URL
        String defaultImagePath = "/images/Pirates-of-the-Carribean.jpg";

        // Load the image and set it to the ImageView
        Image defaultImage = new Image(getClass().getResourceAsStream(defaultImagePath));
        imgPirates.setImage(defaultImage);
    }

    private void loadTopGunImage() {
        // You can set a default image path or URL
        String defaultImagePath = "/images/Top-Gun-Maverick.jpg";

        // Load the image and set it to the ImageView
        Image defaultImage = new Image(getClass().getResourceAsStream(defaultImagePath));
        imgTopGun.setImage(defaultImage);
    }

    private void loadSherlockImage() {
        // You can set a default image path or URL
        String defaultImagePath = "/images/Sherloch-Holmes.jpg";

        // Load the image and set it to the ImageView
        Image defaultImage = new Image(getClass().getResourceAsStream(defaultImagePath));
        imgSherlockHolmes.setImage(defaultImage);
    }

    private void loadHobbitImage() {
        // You can set a default image path or URL
        String defaultImagePath = "/images/The-Hobbit.jpg";

        // Load the image and set it to the ImageView
        Image defaultImage = new Image(getClass().getResourceAsStream(defaultImagePath));
        imgHobbit.setImage(defaultImage);
    }
}
