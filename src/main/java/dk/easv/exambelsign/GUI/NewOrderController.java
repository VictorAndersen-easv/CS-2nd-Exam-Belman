package dk.easv.exambelsign.GUI;

import dk.easv.exambelsign.BE.Order;
import dk.easv.exambelsign.BE.User;
import dk.easv.exambelsign.DAL.BCryptor;
import dk.easv.exambelsign.DAL.OrderDAO;
import dk.easv.exambelsign.DAL.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class NewOrderController implements Initializable {

    @FXML private Label messageLabel;

    @FXML private TextField numberField;
    @FXML private TextField nameField;
    @FXML private TextField apprbyField;
    @FXML private TextField apprstatField;
    @FXML private TextField frontphotoField;
    @FXML private TextField leftphotoField;
    @FXML private TextField rightphotoField;
    @FXML private TextField topphotoField;
    @FXML private TextField backphotoField;
    @FXML private TextField bottomphotoField;



    public void finalCreateBtnClick(ActionEvent event) {
        //Create order and send to DB with info from user input.
        try {
            OrderDAO odao = new OrderDAO();

            int ordernumber = Integer.parseInt(numberField.getText());
            String ordername = nameField.getText();
            String apprby = apprbyField.getText();
            String apprstat = apprstatField.getText();
            String photoaddress = "unused";
            String frontphoto = frontphotoField.getText();
            String leftphoto = leftphotoField.getText();
            String rightphoto = rightphotoField.getText();
            String topphoto = topphotoField.getText();
            String backphoto = backphotoField.getText();
            String bottomphoto = bottomphotoField.getText();


            odao.createOrder(new Order(ordernumber,ordername,apprby,apprstat,photoaddress,frontphoto,leftphoto,rightphoto,topphoto,backphoto,bottomphoto));

            System.out.println("you made an order");
            messageLabel.setText("Order successfully created");
            messageLabel.setVisible(true);
        }
        catch (Exception e) {
            System.out.println("something went wrong");
            messageLabel.setText("Error: Something went wrong");
            messageLabel.setVisible(true);
        }
    }

    public void cancelBtnClick(ActionEvent event) throws IOException {
        Parent orderspage = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/orderspage.fxml"));
        Scene scene = new Scene(orderspage);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        messageLabel.setVisible(false);
    }

    @FXML
    private void frontselectBtnClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            frontphotoField.setText("SavedPics/" + selectedFile.getName()); //Store relative path
        }
    }

    @FXML
    private void leftselectBtnClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            leftphotoField.setText("SavedPics/" + selectedFile.getName()); //Store relative path
        }
    }

    @FXML
    private void rightselectBtnClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            rightphotoField.setText("SavedPics/" + selectedFile.getName()); //Store relative path
        }
    }

    @FXML
    private void topselectBtnClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            topphotoField.setText("SavedPics/" + selectedFile.getName()); //Store relative path
        }
    }

    @FXML
    private void backselectBtnClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            backphotoField.setText("SavedPics/" + selectedFile.getName()); //Store relative path
        }
    }

    @FXML
    private void bottomselectBtnClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            bottomphotoField.setText("SavedPics/" + selectedFile.getName()); //Store relative path
        }
    }
}
