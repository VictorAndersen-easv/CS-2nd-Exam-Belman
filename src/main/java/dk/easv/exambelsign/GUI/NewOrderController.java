package dk.easv.exambelsign.GUI;

import dk.easv.exambelsign.BE.Order;
import dk.easv.exambelsign.BE.User;
import dk.easv.exambelsign.DAL.BCryptor;
import dk.easv.exambelsign.DAL.OrderDAO;
import dk.easv.exambelsign.DAL.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class NewOrderController {

    @FXML private TextField numberField;
    @FXML private TextField nameField;
    @FXML private TextField apprbyField;
    @FXML private TextField apprstatField;
    @FXML private TextField photoField;


    private void PNGpressed(){
        //This adds .png to the address so the user doesn't have to write it
        String currentText = photoField.getText();
        if (!currentText.toLowerCase().endsWith(".png")) {
            currentText += ".png";
        }
        photoField.setText(currentText);
    }



    public void finalCreateBtnClick(ActionEvent event) {
        //Create order and send to DB with info from user input.
        try {
            OrderDAO odao = new OrderDAO();

            int ordernumber = Integer.parseInt(numberField.getText());
            String ordername = nameField.getText();
            String apprby = apprbyField.getText();
            String apprstat = apprstatField.getText();
            String photoaddress = photoField.getText();


            odao.createOrder(new Order(ordernumber,ordername,apprby,apprstat,photoaddress));

            System.out.println("you made an order");
        }
        catch (Exception e) {
            System.out.println("something went wrong");
        }
    }

    public void cancelBtnClick(ActionEvent event) throws IOException {
        Parent orderspage = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/orderspage.fxml"));
        Scene scene = new Scene(orderspage);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void selectBtnClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            photoField.setText("SavedPics/" + selectedFile.getName()); //Store absolute path

//            String filename = selectedFile.getName().toLowerCase();
//            if (filename.endsWith(".png")) {
//                PNGpressed();
//            }

        }

    }
}
