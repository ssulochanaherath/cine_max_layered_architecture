package lk.ijse.cinemax.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.cinemax.dto.LoginDto;
import lk.ijse.cinemax.model.LoginModel;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public TextField txtUserName;
    public TextField txtPassword;
//    public AnchorPane rootNode;


    public void btnSignUpOnAction(ActionEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();

        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/signup_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Signup Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnLoginOnAction(ActionEvent event) throws Exception{
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        LoginModel loginModel = new LoginModel();

        try{
            LoginDto loginDto = loginModel.searchUser (userName, password);

            if (loginDto != null) {
                clearFields();

                Parent rooNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
                Scene scene = new Scene(rooNode);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();

            } else {
                clearFields();
                new Alert(Alert.AlertType.INFORMATION, "Invalid username or password").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clearFields() {
        txtUserName.setText("");
        txtPassword.setText("");
    }
}
