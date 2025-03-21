package dao;

import model.Order;
import Myjdbc.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {

    // Insert a new order
    public void insertOrder(Order order) {
        String SQL = "INSERT INTO Orders (itemName) VALUES (?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, order.getItemName());
            pstmt.executeUpdate();
            System.out.println("Order inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting order.");
            e.printStackTrace();
        }
    }

    // Retrieve an order by ID
    public Order getOrderById(int orderId) {
        String SQL = "SELECT * FROM Orders WHERE orderId = ?";
        Order order = null;
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                order = new Order(
                    rs.getInt("orderId"),
                    rs.getString("itemName")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving order.");
            e.printStackTrace();
        }
        return order;
    }

    // Update an order
    public void updateOrder(Order order) {
        String SQL = "UPDATE Orders SET itemName = ? WHERE orderId = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, order.getItemName());
            pstmt.setInt(2, order.getOrderID());
            pstmt.executeUpdate();
            System.out.println("Order updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating order.");
            e.printStackTrace();
        }
    }

    // Delete an order
    public void deleteOrder(int orderId) {
        String SQL = "DELETE FROM Orders WHERE orderId = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
            System.out.println("Order deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting order.");
            e.printStackTrace();
        }
    }
}
