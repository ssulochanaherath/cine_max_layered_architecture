package lk.ijse.cinemax.controller;

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
import lk.ijse.cinemax.model.SignUpModel;
import lk.ijse.cinemax.dto.SignUpDto;

import java.awt.*;
import java.sql.SQLException;

public class SignupFormController {

    public TextField txtFristName;
    public TextField txtLastName;
    public TextField txtUserName;
    public TextField txtPassword;

    private SignUpModel signUpModel = new SignUpModel();

    public void btnCreateAccountOnAction(ActionEvent event) throws SQLException {
        String fristName = txtFristName.getText();
        String lastName = txtLastName.getText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        var dto = new SignUpDto(fristName,lastName,userName,password);

        try {
            boolean isSaved = signUpModel.saveUser(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Created An Account!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void clearFields() {
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
