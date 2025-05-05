package dk.easv.exambelsign.DAL;

import dk.easv.exambelsign.BE.User;

import java.io.IOException;
import java.sql.*;

public class UserDAO {

    private final DBConnector dbConnector = new DBConnector();

    public UserDAO() throws IOException {
    }

    public void getAllUsers() throws Exception {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM userstuff";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            }
    }


        public User createUser (User user) throws Exception {
            // this method helps import the data from User to add to the userstuff table in the sql server
            String sql = "INSERT INTO dbo.userstuff (hashedpassword,username,userID,role,firstname,lastname) VALUES ( ?, ?, ?, ?, ?, ?)";
            DBConnector dbConnector = new DBConnector();

            try (Connection connection = dbConnector.getConnection()) {
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                stmt.setString(1, user.getPassword());
                stmt.setString(2, user.getUsername());
                stmt.setInt(3, user.getUserID());
                stmt.setString(4, user.getRole());
                stmt.setString(5, user.getFirstname());
                stmt.setString(6, user.getLastname());


                //Run the SQL statement
                stmt.executeUpdate();
                //Get the generated keys
                ResultSet rs = stmt.getGeneratedKeys();
                int id = 0;

                //If there is a key, set the id to the key
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                //Create user and send up the layers
                return new User(user.getPassword(), user.getUsername(), user.getUserID(), user.getRole(), user.getFirstname(), user.getLastname());

            } catch (SQLException ex) {
                throw new Exception("Could not get users from database.", ex);
            }
        }
    }

