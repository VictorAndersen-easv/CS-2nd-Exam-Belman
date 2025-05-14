package dk.easv.exambelsign.DAL;

import dk.easv.exambelsign.BE.Order;
import dk.easv.exambelsign.BE.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final DBConnector dbConnector = new DBConnector();

    public UserDAO() throws IOException {
    }

    public List<User> getAllUsers() throws Exception {

        ArrayList<User> allUsers = new ArrayList<>();

        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM userstuff";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                //Get the data from the database
                String hashedpassword = rs.getString("hashedpassword");
                String username = rs.getString("username");
                int userID = rs.getInt("userid");
                String role = rs.getString("role");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String fullname = rs.getString("firstname") + " " + rs.getString("lastname");
                String email = rs.getString("email");

                User userthing = new User(hashedpassword, username, userID, role, firstname, lastname, fullname, email);
                allUsers.add(userthing);
            }
            //Return the list of orders
            return allUsers;

        } catch (SQLException ex){
                ex.printStackTrace();
                throw new Exception("Could not get users from database", ex);
            }
        }


        public User createUser (User user) throws Exception {
            // this method helps import the data from User to add to the userstuff table in the sql server
            String sql = "INSERT INTO dbo.userstuff (hashedpassword,username,userID,role,firstname,lastname,email) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
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
                return new User(user.getPassword(), user.getUsername(), user.getUserID(), user.getRole(), user.getFirstname(), user.getLastname(),user.getFullname(), user.getEmail());

            } catch (SQLException ex) {
                throw new Exception("Could not get users from database.", ex);
            }
        }
    }

