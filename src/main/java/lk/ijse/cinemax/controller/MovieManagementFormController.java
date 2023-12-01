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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lk.ijse.cinemax.dto.MovieDto;
import lk.ijse.cinemax.dto.tm.MovieTm;
import lk.ijse.cinemax.model.MovieModel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    public TableColumn colImage;
    public ImageView imgMovie;
    public Label txtDate;
    public Label txtTime;
    public JFXTextField txtDescription;
    public TableColumn colDescription;

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

    private File selectedImageFile;

    public void btnSaveOnAction(ActionEvent event) {
        String movieId = txtMovieId.getText();
        String movieName = txtMovieName.getText();
        String movieGenre = txtMovieGenre.getText();
        String year = txtYear.getText();
        String description = txtDescription.getText();

        // Define the regex pattern for allowed movie names
        String allowedMovieNamesRegex = "(Avengers|Mission Impossible|Top Gun|Sherlock Holmes|Pirates|Hobbit)";

        // Check if the entered movieName matches the allowed pattern
        if (!movieName.matches(allowedMovieNamesRegex)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Movie Name! Please enter a valid Movie Name.").show();
            return; // Exit the method if validation fails
        }

        var dto = new MovieDto(movieId, movieName, movieGenre, year, null, description);

        dto.setImagePath(selectedImageFile != null ? selectedImageFile.getAbsolutePath() : null);

        try {
            boolean isSaved = movieModel.saveMovie(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Saved Movie!").show();
                clearFields();
                initialize(); // Move initialize() outside if statement
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void initialize() {
        setCellValueFctory();
        loadAllMovie();
        setDate();
        setTime();

        generateMovieId();
    }

    public void setDate(){
        txtDate.setText(String.valueOf(LocalDate.now()));
    }

    public void setTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        txtTime.setText(LocalTime.now().format(formatter));
    }

    private void generateMovieId() {
        try {
            String lastMovieId = movieModel.generateMovieId();

            String newMovieId = generateNewMovieId(lastMovieId, "M");

            txtMovieId.setText(newMovieId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private String generateNewMovieId(String lastMovieId, String M) {
        if (lastMovieId == null || lastMovieId.isEmpty()) {
            return M + "001";
        }

        int numericPart = Integer.parseInt(lastMovieId.substring(1)) + 1;
        return String.format("%s%03d", M, numericPart);
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
                                dto.getYear(),
                                dto.getImagePath(),
                                dto.getDescription()
                        )
                );
            }
            tblMovies.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private void setCellValueFctory() {
        if (colMovieId != null) {
            colMovieId.setCellValueFactory(new PropertyValueFactory<>("movieId"));
        }
        if (colMovieName != null) {
            colMovieName.setCellValueFactory(new PropertyValueFactory<>("movieName"));
        }
        if (colMovieGenre != null) {
            colMovieGenre.setCellValueFactory(new PropertyValueFactory<>("movieGenre"));
        }
        if (colYear != null) {
            colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        }
        if (colImage != null) {
            colImage.setCellValueFactory(new PropertyValueFactory<>("image"));
        }
        if (colDescription != null) {
            colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        }
    }


    private void clearFields() {
        txtMovieId.clear();
        txtMovieName.clear();
        txtMovieGenre.clear();
        txtYear.clear();
        txtMovieSearch.clear();
        selectedImageFile = null;
        txtDescription.clear();
    }

    public void btnUpdateOnAction(ActionEvent event) {
        String movieId = txtMovieId.getText();
        String movieName = txtMovieName.getText();
        String movieGenre = txtMovieGenre.getText();
        String year = txtYear.getText();
        String description = txtDescription.getText();

        var dto = new MovieDto(movieId, movieName, movieGenre, year, null, description);

        dto.setImagePath(selectedImageFile != null ? selectedImageFile.getAbsolutePath() : null);

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

    public void btnChooseImageOnAction(ActionEvent event) throws SQLException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        // Show open file dialog
        selectedImageFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

        if (selectedImageFile != null) {
            // You can display the selected image or perform any other action
            // For example, you can set the image path to a TextField or display it in an ImageView
            // For simplicity, let's just print the file path for now
            System.out.println("Selected Image File: " + selectedImageFile.getAbsolutePath());
        }
    }
}
