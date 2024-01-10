package lk.ijse.cinemax.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import lk.ijse.cinemax.model.SignUpModel;
import lk.ijse.cinemax.bo.BOFactory;
import lk.ijse.cinemax.bo.custom.SignUpBO;
import lk.ijse.cinemax.dto.SignUpDto;

import java.awt.*;
import java.sql.SQLException;

public class SignupFormController {
    SignUpBO signUpBO = (SignUpBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.SIGNUP);

    public TextField txtUserId;
    public TextField txtFristName;
    public TextField txtLastName;
    public TextField txtUserName;
    public TextField txtPassword;


    //private SignUpModel signUpModel = new SignUpModel();

    public void initialize() {
        generateUserId();
    }

    private void generateUserId() {
        try {
            String lastId = signUpBO.getLastUserId();

            String newId = generateNextId(lastId, "U");

            txtUserId.setText(newId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private String generateNextId(String lastId, String u) {
        if (lastId == null || lastId.isEmpty()) {
            return u + "001";
        }

        int numericPart = Integer.parseInt(lastId.substring(1)) + 1;
        return String.format("%s%03d", u, numericPart);
    }

    public void btnCreateAccountOnAction(ActionEvent event) throws SQLException {
        String userId = txtUserId.getText();
        String fristName = txtFristName.getText();
        String lastName = txtLastName.getText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        String userIdRegex = "U\\d{3}";
        String firstNameRegex = "[A-Z][a-z]*";
        String lastNameRegex = "[A-Z][a-z]*";
        String userNameRegex = "[a-z]+"; // Only simple letters
        String passwordRegex = "\\d+"; // Only numbers

        if (!userId.matches(userIdRegex)) {
            new Alert(Alert.AlertType.ERROR, "Invalid User Id! Please enter a valid User Id.").show();
            return;
        }

        if (!fristName.matches(firstNameRegex)) {
            new Alert(Alert.AlertType.ERROR, "Invalid First Name! Please use Capital Letter for the First Letter.").show();
            return;
        }

        if (!lastName.matches(lastNameRegex)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Last Name! Please use Capital Letter for the First Letter.").show();
            return;
        }

        if (!userName.matches(userNameRegex)) {
            new Alert(Alert.AlertType.ERROR, "Invalid User Name! Please enter a valid User Name with simple letters.").show();
            return;
        }

        if (!password.matches(passwordRegex)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Password! Please enter a valid Password with only numbers.").show();
            return;
        }

        if (fristName.isEmpty() || lastName.isEmpty() || userName.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill in all the fields.").show();
            return;
        }

        var dto = new SignUpDto(userId,fristName,lastName,userName,password);

        try {
            boolean isSaved = signUpBO.save(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Created An Account!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFields() {
        txtUserId.setText("");
        txtFristName.setText("");
        txtLastName.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
    }

    public void btnSignInOnAction(ActionEvent event) throws Exception{
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
}
