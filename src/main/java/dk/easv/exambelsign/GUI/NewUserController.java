package dk.easv.exambelsign.GUI;
import dk.easv.exambelsign.BE.User;
import dk.easv.exambelsign.DAL.BCryptor;
import dk.easv.exambelsign.DAL.UserDAO;
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
    @FXML private TextField emailField;
    @FXML private Button finalCreateBtn;
    @FXML private Button cancelBtn;


    @FXML
    private void finalCreateBtnClick(ActionEvent actionEvent) throws Exception {
        //Create user and send to DB with info from user input. Also, BCrypts password.
        try {
            UserDAO udao = new UserDAO();

            String password = passwordField.getText();
            String username = usernameField.getText();
            int userID = 2;
            String role = roleField.getText();
            String firstname = firstnameField.getText();
            String lastname = lastnameField.getText();
            String fullname = firstname + " " + lastname;
            String email = emailField.getText();

            udao.createUser(new User(BCryptor.bcryption(password), username, userID, role, firstname, lastname, fullname, email));

            System.out.println("you dun made a guy");
        }
        catch (Exception e) {
            System.out.println("ah shit its all fucked up");
        }

    }

    @FXML
    private void cancelBtnClick(ActionEvent event) throws IOException {
        Parent userspage = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/userspage.fxml"));
        Scene scene = new Scene(userspage);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
}
