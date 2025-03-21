

package dao;

import model.Customer;
import Myjdbc.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    // Insert a new customer into the database
    public void insertCustomer(Customer customer) {
        String SQL = "INSERT INTO Customers (fullName, email, phone, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, customer.getFullName());
            pstmt.setString(2, customer.getEmail());
            pstmt.setString(3, customer.getPhone());
            pstmt.setString(4, customer.getAddress());
            pstmt.executeUpdate();
            System.out.println("Customer inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting customer.");
            e.printStackTrace();
        }
    }

    // Retrieve a customer by ID
    public Customer getCustomerById(int customerId) {
        String SQL = "SELECT * FROM Customers WHERE customerId = ?";
        Customer customer = null;
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                customer = new Customer(
                    rs.getInt("customerId"),
                    rs.getString("fullName"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving customer.");
            e.printStackTrace();
        }
        return customer;
    }

    // Update a customer's details
    public void updateCustomer(Customer customer) {
        String SQL = "UPDATE Customers SET fullName = ?, email = ?, phone = ?, address = ? WHERE customerId = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, customer.getFullName());
            pstmt.setString(2, customer.getEmail());
            pstmt.setString(3, customer.getPhone());
            pstmt.setString(4, customer.getAddress());
            pstmt.setInt(5, customer.getCustomerId());
            pstmt.executeUpdate();
            System.out.println("Customer updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating customer.");
            e.printStackTrace();
        }
    }

    // Delete a customer by ID
    public void deleteCustomer(int customerId) {
        String SQL = "DELETE FROM Customers WHERE customerId = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, customerId);
            pstmt.executeUpdate();
            System.out.println("Customer deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting customer.");
            e.printStackTrace();
        }
    }
}