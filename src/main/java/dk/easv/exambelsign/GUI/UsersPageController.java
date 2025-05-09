package dk.easv.exambelsign.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;

public class UsersPageController {


    @FXML
    public void logoutBtnClick(ActionEvent event) throws IOException {

        Parent loginpage = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/login.fxml"));
        Scene scene = new Scene(loginpage);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();

    }

    @FXML
    private void HomeBtnClick(ActionEvent event) throws IOException {
        Parent loginpage = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/adminpage.fxml"));
        Scene scene = new Scene(loginpage);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void EditBtnClick(ActionEvent actionEvent) {
    }

    @FXML
    private void newUserBtnClick(ActionEvent event) throws IOException {
        Parent smackem = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/newuserpopup.fxml"));
        Scene scene = new Scene(smackem);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
}
