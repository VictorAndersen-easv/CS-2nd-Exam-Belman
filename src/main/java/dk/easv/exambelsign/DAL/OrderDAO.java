package dk.easv.exambelsign.DAL;

import dk.easv.exambelsign.BE.Order;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    private final DBConnector dbConnector = new DBConnector();

    public OrderDAO() throws IOException {
    }

    public List<Order> getAllOrders() throws Exception {
        //this method gets all the orders from the database
        ArrayList<Order> allOrders = new ArrayList<>();

        try (Connection connection = dbConnector.getConnection()) {
            String sqlstr = "SELECT * FROM orderstuff";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlstr);

            while (rs.next()) {
                //Get the data from the database
                int ordernumber = rs.getInt("ordernumber");
                String ordername = rs.getString("ordername");
                String approvedby = rs.getString("approvedby");
                String approvalstatus = rs.getString("approvalstatus");
                String photoaddress = rs.getString("photoaddress");
                String frontphoto = rs.getString("frontphoto");
                String leftphoto = rs.getString("leftphoto");
                String rightphoto = rs.getString("rightphoto");
                String topphoto = rs.getString("topphoto");
                String bottomphoto = rs.getString("bottomphoto");
                String backphoto = rs.getString("backphoto");

                Order orderthing = new Order(ordernumber, ordername, approvedby, approvalstatus, photoaddress, frontphoto, leftphoto, rightphoto, topphoto, backphoto, bottomphoto);
                allOrders.add(orderthing);
            }
            //Return the list of orders
            return allOrders;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Could not get orders from database", ex);
        }
    }

    public Order createOrder (Order order) throws Exception {
        // this method helps import the data from Order to add to the orderstuff table in the sql server
        String sql = "INSERT INTO dbo.orderstuff (ordernumber, ordername, approvedby, approvalstatus, photoaddress, frontphoto, leftphoto, rightphoto, topphoto, backphoto, bottomphoto) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        DBConnector dbConnector = new DBConnector();

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, order.getOrdernumber());
            stmt.setString(2, order.getOrdername());
            stmt.setString(3, order.getApprovedby());
            stmt.setString(4, order.getApprovalstatus());
            stmt.setString(5, order.getPhotoaddress());
            stmt.setString(6, order.getFrontphoto());
            stmt.setString(7, order.getLeftphoto());
            stmt.setString(8, order.getRightphoto());
            stmt.setString(9, order.getTopphoto());
            stmt.setString(10, order.getBackphoto());
            stmt.setString(11, order.getBottomphoto());


            //Run the SQL statement
            stmt.executeUpdate();
            //Get the generated keys
            ResultSet rs = stmt.getGeneratedKeys();
            int id = 0;

            //If there is a key, set the id to the key
            if (rs.next()) {
                id = rs.getInt(1);
            }

            return new Order(order.getOrdernumber(),
                                order.getOrdername(),
                                order.getApprovedby(),
                                order.getApprovalstatus(),
                                order.getPhotoaddress(),
                                order.getFrontphoto(),
                                order.getLeftphoto(),
                                order.getRightphoto(),
                                order.getTopphoto(),
                                order.getBackphoto(),
                                order.getBottomphoto());


        } catch (SQLException ex) {
            throw new Exception("Could not get orders from database.", ex);
        }




        }


    }


