package dk.easv.exambelsign.GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;


public class NewUserController {

    @FXML private TextField firstnameField;
    @FXML private TextField lastnameField;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private TextField roleField;
    @FXML private Button finalCreateBtn;
    @FXML private Button cancelBtn;


    @FXML
    private void finalCreateBtnClick(ActionEvent actionEvent) {

        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String role = roleField.getText();


    }

    @FXML
    private void cancelBtnClick(ActionEvent event) throws IOException {
        Parent loginpage = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/userspage.fxml"));
        Scene scene = new Scene(loginpage);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
}
