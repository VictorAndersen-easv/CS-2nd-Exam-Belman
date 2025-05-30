package dk.easv.exambelsign.GUI;

import dk.easv.exambelsign.BE.Order;
import dk.easv.exambelsign.DAL.OrderDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class PhotosController implements Initializable {

    Order selectedOrder = null;

    public Button InspectBtn;

    public ImageView FrontPhoto;
    public ImageView LeftPhoto;
    public ImageView RightPhoto;
    public ImageView TopPhoto;
    public ImageView BackPhoto;
    public ImageView BottomPhoto;

    public Image FrontPhotoImage;
    public Image LeftPhotoImage;
    public Image RightPhotoImage;
    public Image TopPhotoImage;
    public Image BackPhotoImage;
    public Image BottomPhotoImage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InspectBtn.setVisible(false);

    }

    public void setSelectedOrder(Order order) {
        FrontPhoto.setImage(loadImageFromFile(order.getFrontphoto()));
        LeftPhoto.setImage(loadImageFromFile(order.getLeftphoto()));
        RightPhoto.setImage(loadImageFromFile(order.getRightphoto()));
        TopPhoto.setImage(loadImageFromFile(order.getTopphoto()));
        BackPhoto.setImage(loadImageFromFile(order.getBackphoto()));
        BottomPhoto.setImage(loadImageFromFile(order.getBottomphoto()));
    }

    private Image loadImageFromFile(String relativePath) {
        if (relativePath == null || relativePath.isEmpty()) {
            System.out.println("Image path is empty or null");
            return null;
        }
        File imageFile = new File(relativePath);
        if (!imageFile.exists()) {
            System.out.println("Image file does not exist: " + relativePath);
            return null;
        }
        // Convert the file path to a proper file URI for JavaFX Image
        return new Image(imageFile.toURI().toString());
    }


    @FXML
    private void inspectPhotosBtnClick(ActionEvent actionEvent) {
//        Order selectedOrder = (Order) OrderTable.getSelectionModel().getSelectedItem();
//        if (selectedOrder != null) {
//            File file = new File(selectedOrder.getPhotoaddress());
//            if (Desktop.isDesktopSupported()) {
//                try {
//                    //Opens the photo file using the default system application
//                    Desktop.getDesktop().open(file);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    @FXML
    private void returnBtnClick(ActionEvent event) throws IOException {
        Parent orderpagus = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/orderspage.fxml"));
        Scene scene = new Scene(orderpagus);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void InspectBtnClick(ActionEvent actionEvent) {

    }
}
