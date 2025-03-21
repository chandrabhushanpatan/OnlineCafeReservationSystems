package dao;

import model.Manager;
import Myjdbc.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAO {

    // Insert a new manager
    public void insertManager(Manager manager) {
        String SQL = "INSERT INTO Managers (fullName) VALUES (?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, manager.getFullName());
            pstmt.executeUpdate();
            System.out.println("Manager inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting manager.");
            e.printStackTrace();
        }
    }

    // Retrieve a manager by ID
    public Manager getManagerById(int managerId) {
        String SQL = "SELECT * FROM Managers WHERE managerId = ?";
        Manager manager = null;
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, managerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                manager = new Manager(
                    rs.getInt("managerId"),
                    rs.getString("fullName")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving manager.");
            e.printStackTrace();
        }
        return manager;
    }

    // Update a manager
    public void updateManager(Manager manager) {
        String SQL = "UPDATE Managers SET fullName = ? WHERE managerId = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, manager.getFullName());
            pstmt.setInt(2, manager.getManagerId());
            pstmt.executeUpdate();
            System.out.println("Manager updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating manager.");
            e.printStackTrace();
        }
    }

    // Delete a manager
    public void deleteManager(int managerId) {
        String SQL = "DELETE FROM Managers WHERE managerId = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, managerId);
            pstmt.executeUpdate();
            System.out.println("Manager deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting manager.");
            e.printStackTrace();
        }
    }
}
