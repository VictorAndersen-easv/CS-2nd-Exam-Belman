package dk.easv.exambelsign.DAL;

import dk.easv.exambelsign.BE.Order;
import dk.easv.exambelsign.BE.User;

import java.io.IOException;
import java.sql.*;

public class OrderDAO {

    private final DBConnector dbConnector = new DBConnector();

    public OrderDAO() throws IOException {
    }

    public void getAllOrders() throws Exception {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM orderstuff";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        }
    }


    public Order createOrder (Order order) throws Exception {
        // this method helps import the data from Order to add to the orderstuff table in the sql server
        String sql = "INSERT INTO dbo.orderstuff (ordernumber, ordername, approvedby, approvalstatus) VALUES ( ?, ?, ?, ?)";
        DBConnector dbConnector = new DBConnector();

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, order.getOrdernumber());
            stmt.setString(2, order.getOrdername());
            stmt.setString(3, order.getApprovedby());
            stmt.setString(4, order.getApprovalstatus());


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
            return new Order(order.getOrdernumber(), order.getOrdername(), order.getApprovedby(), order.getApprovalstatus());

        } catch (SQLException ex) {
            throw new Exception("Could not get orders from database.", ex);
        }
    }
}

