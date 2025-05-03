package dk.easv.exambelsign.GUI;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import dk.easv.exambelsign.DAL.BCryptor;
import dk.easv.exambelsign.DAL.DBConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    private String mockUsername = "Victor";
    private String mockPassword = "Andersen";


    @FXML
    private TextField enterUsernameField;
    @FXML
    private TextField enterPasswordField;
    @FXML
    private Button loginBtn;
    @FXML
    private Label invalidLoginTxt;




    public void loginBtnAction(ActionEvent event) throws IOException, SQLServerException, NullPointerException {

        if (validateLogin()) {
            invalidLoginTxt.setVisible(false);
            System.out.println("You are logged in");

            Parent homepage = FXMLLoader.load(getClass().getResource("/dk/easv/exambelsign/adminpage.fxml"));
            Scene scene = new Scene(homepage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();

        }

        else {
            invalidLoginTxt.setVisible(true);
        }
    }


    public boolean validateLogin () throws IOException, SQLServerException, NullPointerException {

        DBConnector conn = new DBConnector();
        Connection conne = conn.getConnection();

        String query = "SELECT * FROM userstuff WHERE username = '" + enterUsernameField.getText() + "'";

        try {

            Statement stmt = conne.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            if (rs.next()) {
                String hash = rs.getString("hashedpassword");
               return BCryptor.checkPassword(enterPasswordField.getText(), hash);
            }
            else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            return false;
        }
    }
}


