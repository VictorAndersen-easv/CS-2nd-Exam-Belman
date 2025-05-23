package dk.easv.exambelsign.GUI;

import dk.easv.exambelsign.BE.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AdminPageController implements Initializable {


    @FXML
    private ImageView image;

    public void logoutBtnClick(ActionEvent event) throws Exception {

        Parent loginpage = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/login.fxml"));
        Scene scene = new Scene(loginpage);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();



    }


    @FXML
    private void UsersBtnClick(ActionEvent event) throws Exception {

        UsersPageController usersPageController = new UsersPageController();
        Parent loginpage = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/userspage.fxml"));
        Scene scene = new Scene(loginpage);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
        usersPageController.initialize();

    }

    @FXML
    private void OrdersBtnClick(ActionEvent event) throws Exception {

            OrdersPageController ordersPageController = new OrdersPageController();
            Parent loginpage = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/orderspage.fxml"));
            Scene scene = new Scene(loginpage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image belmanImg = new Image(new File("C:\\Users\\Victor\\IdeaProjects\\CS-2nd-Exam-Belman\\Images\\Belman-expansion-joints_6_BELMAN.jpg").toURI().toString());
       image.setImage(belmanImg);
    }
}
