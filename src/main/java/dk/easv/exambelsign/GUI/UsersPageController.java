package dk.easv.exambelsign.GUI;

import dk.easv.exambelsign.BE.Order;
import dk.easv.exambelsign.BE.User;
import dk.easv.exambelsign.DAL.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;

public class UsersPageController {

    @FXML private TableView<User> UserTable;
    @FXML private TableColumn<User, String> usnamCol;
    @FXML private TableColumn<User, String> emailCol;
    @FXML private TableColumn<User, String> fullnamCol;
    @FXML private TableColumn<User, String> rolCol;


    private ObservableList<User> usersToBeViewed = FXCollections.observableArrayList();

    UserDAO udao = new UserDAO();


    public UsersPageController() throws IOException {

    }
    public ObservableList<User> getObservableUsers() {return usersToBeViewed;}

    public void initialize() throws Exception {
        usersToBeViewed.addAll(udao.getAllUsers());
        UserTable.setItems(usersToBeViewed);
        usnamCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        fullnamCol.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        rolCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        UserTable.setItems(usersToBeViewed);
    }


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
        //Go to fxml page
    }

    @FXML
    private void newUserBtnClick(ActionEvent event) throws IOException {
        Parent newuspop = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/newuserpopup.fxml"));
        Scene scene = new Scene(newuspop);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
}
