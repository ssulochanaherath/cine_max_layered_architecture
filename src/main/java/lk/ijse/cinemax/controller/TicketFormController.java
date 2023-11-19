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
import lk.ijse.cinemax.dto.*;
import lk.ijse.cinemax.dto.tm.TicketTm;
import lk.ijse.cinemax.model.SeatModel;
import lk.ijse.cinemax.model.TicketModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketFormController {
    public JFXComboBox<String> cmbCustomerIds;
    public JFXTextField txtTicketId;
    public JFXComboBox<String> cmbMovieId;
    public JFXTextField txtTicketPrice;
    public JFXComboBox<String> cmbSeatIds;
    public TableView<TicketTm> tblTickets;
    public TableColumn colTicketId;
    public TableColumn colCustomerId;
    public TableColumn colMovieId;
    public TableColumn colSeatId;
    public TableColumn colTicketPrice;
    public JFXComboBox<String> cmbShowtimeId;
    public TableColumn colShowTimeIds;
    public JFXTextField txtMOvieId;
    private TicketModel ticketModel = new TicketModel();

    private SeatModel seatModel = new SeatModel();

    public void btnLogOutOnAction(MouseEvent event) throws Exception {
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

    public void btnCustomerOnAction(MouseEvent event) throws Exception {
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

    public void btnDashboardOnAction(MouseEvent event) throws Exception {
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

    public void btnMoviesOnAction(MouseEvent event) throws Exception {
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

    public void btnTicketOnAction(MouseEvent event) throws Exception {
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

    public void btnSupplierOnAction(MouseEvent event) throws Exception {
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

    public void btnItemOnAction(MouseEvent event) throws Exception {
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

    public void btnReportOnAction(MouseEvent event) throws Exception {
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

    public void btnFoodOnAction(MouseEvent event) throws Exception {
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
        loadAllTickets();

        try {
            cmbLoadCustomerIds(null); // Load customer IDs into cmbCustomerIds
            cmbLoadMovieIds(null);    // Load movie IDs into cmbMovieId
            cmbLoadSeatNos(null);      // Load row IDs into cmbRowIds
            cmbLoadShowtimeIds(null);

            generateTicketId();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void generateTicketId() {
        try {
            // Retrieve the last generated ticket ID from the database or file
            String lastTicketId = ticketModel.getLastTicketId();

            // Generate the next ticket ID
            String newTicketId = generateNextId(lastTicketId, "T");

            // Set the generated ID to the txtTicketId field
            txtTicketId.setText(newTicketId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private String generateNextId(String lastId, String prefix) {
        if (lastId == null || lastId.isEmpty()) {
            return prefix + "001";
        }

        int numericPart = Integer.parseInt(lastId.substring(1)) + 1;
        return String.format("%s%03d", prefix, numericPart);
    }

    private void loadAllTickets() {
        var model = new TicketModel();

        ObservableList<TicketTm> ticketTms = FXCollections.observableArrayList();

        try {
            List<TicketDto> ticketList = model.loadAllTickets();

            for (TicketDto ticketDto : ticketList) {
                ticketTms.add(
                        new TicketTm(
                                ticketDto.getTicketId(),
                                ticketDto.getCustomerId(),
                                ticketDto.getMovieId(),
                                ticketDto.getSeatNo(),
                                ticketDto.getShowTimeID(),
                                ticketDto.getPrice()
                        )
                );
            }
            tblTickets.setItems(ticketTms);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colTicketId.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colMovieId.setCellValueFactory(new PropertyValueFactory<>("movieId"));
        colSeatId.setCellValueFactory(new PropertyValueFactory<>("seatNo"));
        colShowTimeIds.setCellValueFactory(new PropertyValueFactory<>("showtimeID"));
        colTicketPrice.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
    }

    public void cmbLoadCustomerIds(ActionEvent event) {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<CustomerDto> customerList = ticketModel.loadAllCustomerIds();

            for (CustomerDto dto : customerList) {
                obList.add(dto.getUserId());
            }
            cmbCustomerIds.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void cmbLoadMovieIds(ActionEvent event) {
        ObservableList<String> obmList = FXCollections.observableArrayList();

        try {
            List<MovieDto> movieList = ticketModel.loadAllMovieIds();

            for (MovieDto dto : movieList) {
                obmList.add(dto.getMovieId());
            }
            cmbMovieId.setItems(obmList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void cmbLoadSeatNos(ActionEvent event) {
        ObservableList<String> obsList = FXCollections.observableArrayList();

        try {
            List<SeatDto> seatList = ticketModel.loadAllSeatNos();

            for (SeatDto dto : seatList) {
                obsList.add(dto.getSeatId());
            }
            cmbSeatIds.setItems(obsList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

//    public void btnTicketBookingOnAction(ActionEvent event) {
//        String ticketId = txtTicketId.getText();
//        String customerId = cmbCustomerIds.getValue();
//        String movieId = cmbMovieId.getValue();
//        String seatNo = cmbSeatIds.getValue();
//        String showtimeId = cmbShowtimeId.getValue();
//        String ticketPrice = txtTicketPrice.getText();
//
//        var dto = new TicketDto(ticketId, customerId, movieId, seatNo, showtimeId, ticketPrice);
//
//        try {
//            boolean isAdded = ticketModel.addTicket(dto);
//
//            if (isAdded) {
//                new Alert(Alert.AlertType.INFORMATION, "Ticket Added").show();
//                clearFields();
//            }
//        } catch (SQLException e) {
//            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
//        }
//        initialize();
//    }

    public void btnTicketBookingOnAction(ActionEvent event) {
        String ticketId = txtTicketId.getText();
        String cusId = cmbCustomerIds.getValue();
        String movieId = cmbMovieId.getValue();
        String seatId = cmbSeatIds.getValue();
        String showTimeId = cmbShowtimeId.getValue();
        String price = txtTicketPrice.getText();

        var dto = new TicketDto(ticketId, cusId, movieId, seatId, showTimeId, price);

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine_max", "root", "Ijse@1234");
            connection.setAutoCommit(false);

            // Perform ticket booking
            boolean isBooked = ticketModel.saveTicket(connection, dto);

            // Perform seat deletion
            boolean isSeatDeleted = seatModel.deleteSeat(connection, seatId);

            if (isBooked && isSeatDeleted) {
                connection.commit();
                new Alert(Alert.AlertType.CONFIRMATION, "Ticket Booked Successfully! Seat Deleted.").show();
                clearFields();
            } else {
                connection.rollback();
                new Alert(Alert.AlertType.WARNING, "Transaction failed. Ticket and seat changes rolled back.").show();
            }
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        initialize();
    }

    private void clearFields() {
        txtTicketId.clear();
        cmbCustomerIds.setValue(null);
        cmbMovieId.setValue(null);
        cmbSeatIds.setValue(null);
        cmbShowtimeId.setValue(null);
        txtTicketPrice.clear();
    }

    public void cmbLoadShowtimeIds(ActionEvent event) throws SQLException{
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<ShowTimeDto> idList = ticketModel.loadAllShowtimeIds();

            for (ShowTimeDto dto : idList) {
                obList.add(dto.getShowTimeId());
            }

            cmbShowtimeId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
