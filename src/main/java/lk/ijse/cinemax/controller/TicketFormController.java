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
import javafx.stage.Stage;
import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.*;
import lk.ijse.cinemax.dto.tm.TicketTm;
import lk.ijse.cinemax.model.SeatModel;
import lk.ijse.cinemax.model.TicketModel;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
    public JFXTextField txtCustomerEmail;
    public Label txtDate;
    public Label txtTime;
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
            setDate();
            setTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDate(){
        txtDate.setText(String.valueOf(LocalDate.now()));
    }

    public void setTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        txtTime.setText(LocalTime.now().format(formatter));
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
            List<CustomerDto> customerList = ticketModel.loadAllCustomerIds(); // Assume there is a method to load all customer details

            for (CustomerDto dto : customerList) {
                obList.add(dto.getUserId());
            }
            cmbCustomerIds.setItems(obList);

            // Add a listener to cmbCustomerIds to automatically load the customer email when a customer is selected
            cmbCustomerIds.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, selectedCustomerId) -> {
                if (selectedCustomerId != null) {
                    try {
                        String customerEmail = ticketModel.getCustomerEmail(selectedCustomerId); // Assume there is a method to get customer email by ID
                        txtCustomerEmail.setText(customerEmail);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


//    public void cmbLoadCustomerIds(ActionEvent event) {
//        ObservableList<String> obList = FXCollections.observableArrayList();
//
//        try {
//            List<CustomerDto> customerList = ticketModel.loadAllCustomerIds();
//
//            for (CustomerDto dto : customerList) {
//                obList.add(dto.getUserId());
//            }
//            cmbCustomerIds.setItems(obList);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }

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

//

//    public void btnTicketBookingOnAction(ActionEvent event) {
//        String ticketId = txtTicketId.getText();
//        String cusId = cmbCustomerIds.getValue();
//        String movieId = cmbMovieId.getValue();
//        String seatId = cmbSeatIds.getValue();
//        String showTimeId = cmbShowtimeId.getValue();
//        String price = txtTicketPrice.getText();
//
//        var dto = new TicketDto(ticketId, cusId, movieId, seatId, showTimeId, price);
//
//        Connection connection = null;
//
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine_max", "root", "Ijse@1234");
//            connection.setAutoCommit(false);
//
//            // Perform ticket booking
//            boolean isBooked = ticketModel.saveTicket(connection, dto);
//
//            // Perform seat deletion
//            boolean isSeatDeleted = seatModel.deleteSeat(connection, seatId);
//
//            if (isBooked && isSeatDeleted) {
//                connection.commit();
//                new Alert(Alert.AlertType.CONFIRMATION, "Ticket Booked Successfully! Seat Deleted.").show();
//                clearFields();
//            } else {
//                connection.rollback();
//                new Alert(Alert.AlertType.WARNING, "Transaction failed. Ticket and seat changes rolled back.").show();
//            }
//        } catch (SQLException e) {
//            try {
//                if (connection != null) {
//                    connection.rollback();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//
//            e.printStackTrace();
//            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.setAutoCommit(true);
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        initialize();
//    }

    public void btnTicketBookingOnAction(ActionEvent event) {
        String ticketId = txtTicketId.getText();
        String cusId = cmbCustomerIds.getValue();
        String movieId = cmbMovieId.getValue();
        String seatId = cmbSeatIds.getValue();
        String showTimeId = cmbShowtimeId.getValue();
        String price = txtTicketPrice.getText();

        String email = txtCustomerEmail.getText();

        var dto = new TicketDto(ticketId, cusId, movieId, seatId, showTimeId, price);

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine_max", "root", "Ijse@1234");
            connection.setAutoCommit(false);

            // Perform ticket booking
            boolean isBooked = ticketModel.saveTicket(connection, dto);

            // Perform seat hide
            boolean isHide = seatModel.hideSeat(connection, seatId);

            if (isBooked && isHide) {
                connection.commit();

                String emailContent = "Thank you for being our customer. Your ticket details are send with this email."
                        + "\n\nTicket Details:"
                        + "\n\nID: " + cusId
                        + "\nMovie: " + movieId
                        + "\nSeat: " + seatId
                        + "\nShowtime: " + showTimeId
                        + "\nPrice: " + price;

                sendEmail(email, "Ticket Booked!", emailContent);

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

    private void sendEmail(String to, String subject, String content) {
        final String username = "hallwembley@gmail.com"; // Replace with your Gmail username
        final String password = "nopvwkcbxpxhvjji"; // Replace with your Gmail password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }



    private void clearFields() {
        txtTicketId.clear();
        cmbCustomerIds.setValue(null);
        cmbMovieId.setValue(null);
        cmbSeatIds.setValue(null);
        cmbShowtimeId.setValue(null);
        txtTicketPrice.clear();
        txtCustomerEmail.clear();
    }

    public void cmbLoadShowtimeIds(ActionEvent event) throws SQLException{
        ObservableList<String> obList = FXCollections.observableArrayList();

        List<ShowTimeDto> idList = ticketModel.loadAllShowtimeIds();

        for (ShowTimeDto dto : idList) {
            obList.add(dto.getShowTimeId());
        }

        cmbShowtimeId.setItems(obList);
    }

    public void btnTicketCancelOnAction(ActionEvent event) {
        clearFields();
    }

    public void btnSeatsBookingOnAction(ActionEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/seats_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Seats Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }
}
