package dk.easv.exambelsign.GUI;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import dk.easv.exambelsign.BE.Order;
import dk.easv.exambelsign.DAL.DBConnector;
import dk.easv.exambelsign.DAL.OrderDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class OrdersPageController implements Initializable {

    @FXML
    private TableView<Order> OrderTable;
    @FXML
    private TableColumn<Order, Integer> ordnumCol;
    @FXML
    private TableColumn<Order, String> ordnamCol;
    @FXML
    private TableColumn<Order, String> apprbyCol;
    @FXML
    private TableColumn<Order, String> apprstatCol;

    private ObservableList<Order> ordersToBeViewed = FXCollections.observableArrayList();

    OrderDAO odao = new OrderDAO();

    public OrdersPageController() throws Exception {
    }

    public ObservableList<Order> getObservableOrders() {return ordersToBeViewed;}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ordersToBeViewed.addAll(odao.getAllOrders());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ordnumCol.setCellValueFactory(new PropertyValueFactory<>("ordernumber"));
        ordnamCol.setCellValueFactory(new PropertyValueFactory<>("ordername"));
        apprbyCol.setCellValueFactory(new PropertyValueFactory<>("approvedby"));
        apprstatCol.setCellValueFactory(new PropertyValueFactory<>("approvalstatus"));
        OrderTable.setItems(ordersToBeViewed);
    }









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
    private void EditBtnClick(ActionEvent event) throws IOException {

        Parent editordpop = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/editorderpopup.fxml"));
        Scene scene = new Scene(editordpop);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();

    }

    @FXML
    public void neworderBtnClick(ActionEvent event) throws IOException {
        Parent newordpop = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/neworderpopup.fxml"));
        Scene scene = new Scene(newordpop);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void inspectPhotosBtnClick(ActionEvent actionEvent) {
        Order selectedOrder = (Order) OrderTable.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            File file = new File(selectedOrder.getPhotoaddress());
            if (Desktop.isDesktopSupported()) {
                try {
                    //Opens the photo file using the default system application
                    Desktop.getDesktop().open(file);
                    refreshOrders();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void inspectUserBtnClick(ActionEvent actionEvent) {
    }

    private void refreshOrders() throws Exception {
        ordersToBeViewed.clear();
        ordersToBeViewed.addAll(odao.getAllOrders());
    }


}
