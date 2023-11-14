package lk.ijse.cinemax.controller;

import com.jfoenix.controls.JFXTextField;
import com.sun.source.tree.TryTree;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.cinemax.dto.MovieDto;
import lk.ijse.cinemax.dto.tm.MovieTm;
import lk.ijse.cinemax.model.MovieModel;

import java.awt.*;
import java.rmi.AlreadyBoundException;
import java.sql.SQLException;
import java.util.List;

public class MovieManagementFormController {
    public JFXTextField txtMovieId;
    public JFXTextField txtMovieName;
    public JFXTextField txtYear;
    public JFXTextField txtMovieGenre;
    public TableView tblMovies;
    public TableColumn colMovieId;
    public TableColumn colMovieName;
    public TableColumn colMovieGenre;
    public TableColumn colYear;
    public TextField txtMovieSearch;

    private MovieModel movieModel = new MovieModel();

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
        String movieId = txtMovieId.getText();
        String movieName = txtMovieName.getText();
        String movieGenre = txtMovieGenre.getText();
        String year = txtYear.getText();

        var dto = new MovieDto(movieId, movieName, movieGenre, year);

        try {
            boolean isSaved = movieModel.saveMovie(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Saved Movie!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        initialize();
    }

    public void initialize() {
        setCellValueFctory();
        loadAllMovie();
    }

    private void loadAllMovie() {
        var movieModel = new MovieModel();

        ObservableList<MovieTm> obList = FXCollections.observableArrayList();

        try {
            List<MovieDto> dtoList = movieModel.loadAllMovies();

            for (MovieDto dto : dtoList) {
                obList.add(
                        new MovieTm(
                                dto.getMovieId(),
                                dto.getMovieName(),
                                dto.getMovieGenre(),
                                dto.getYear()
                        )
                );
            }
            tblMovies.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private void setCellValueFctory() {
        colMovieId.setCellValueFactory(new PropertyValueFactory<>("movieId"));
        colMovieName.setCellValueFactory(new PropertyValueFactory<>("movieName"));
        colMovieGenre.setCellValueFactory(new PropertyValueFactory<>("movieGenre"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
    }

    private void clearFields() {
        txtMovieId.clear();
        txtMovieName.clear();
        txtMovieGenre.clear();
        txtYear.clear();
        txtMovieSearch.clear();
    }

    public void btnUpdateOnAction(ActionEvent event) {
        String movieId = txtMovieId.getText();
        String movieName = txtMovieName.getText();
        String movieGenre = txtMovieGenre.getText();
        String year = txtYear.getText();

        var dto = new MovieDto(movieId, movieName, movieGenre, year);

        try {
            boolean isUpdated = movieModel.updateMovie(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Updated Movie!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        initialize();
    }

    public void btnDeleteOnAction(ActionEvent event) {
        String movieId = txtMovieId.getText();

        try {
            boolean isDeleted = movieModel.deleteMovie(movieId);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Movie Deleted!").show();
                loadAllMovie();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Movie Not Deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void btnSearchMovieOnAction(MouseEvent mouseEvent) {
        String searchMovie = txtMovieSearch.getText();

        try {
            MovieDto movieDto = movieModel.searchMovie(searchMovie);

            if (movieDto != null) {
                txtMovieId.setText(movieDto.getMovieId());
                txtMovieName.setText(movieDto.getMovieName());
                txtMovieGenre.setText(movieDto.getMovieGenre());
                txtYear.setText(movieDto.getYear());
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Movie Not Found").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnClearOnAction(ActionEvent event) {
        clearFields();
    }
}