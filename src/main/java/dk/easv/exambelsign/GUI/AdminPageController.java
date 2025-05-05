package dk.easv.exambelsign.GUI;

import dk.easv.exambelsign.BE.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class AdminPageController {


    public void logoutBtnClick(ActionEvent event) throws IOException {

        Parent loginpage = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/login.fxml"));
        Scene scene = new Scene(loginpage);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();

    }


    @FXML
    private void UsersBtnClick(ActionEvent actionEvent) {
    }

    @FXML
    private void OrdersBtnClick(ActionEvent event) throws Exception {



            Parent loginpage = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/orderspage.fxml"));
            Scene scene = new Scene(loginpage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();



    }
}
