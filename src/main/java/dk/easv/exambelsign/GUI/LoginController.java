package dk.easv.exambelsign.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private String mockUsername = "Victor";
    private String mockPassword = "Andersen";


    @FXML
    private TextField enterUsernameField;
    @FXML
    private TextField enterPasswordField;
    @FXML
    private Button loginBtn;
    @FXML
    private Label invalidLoginTxt;

    public void loginBtnAction(ActionEvent event) throws IOException {
        String enteredUsername = enterUsernameField.getText();
        String enteredPassword = enterPasswordField.getText();

        if (enteredUsername.equals("Victor") && enteredPassword.equals("Andersen")) {
            System.out.println("You are logged in");
            Parent homepage = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Scene scene = new Scene(homepage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }


    }




}