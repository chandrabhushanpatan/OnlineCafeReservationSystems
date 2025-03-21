package dao;

import model.Staff;
import Myjdbc.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDAO {

    // Insert a new staff member
    public void insertStaff(Staff staff) {
        String SQL = "INSERT INTO Staff (fullName) VALUES (?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, staff.getFullName());
            pstmt.executeUpdate();
            System.out.println("Staff inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting staff.");
            e.printStackTrace();
        }
    }

    // Retrieve a staff member by ID
    public Staff getStaffById(int staffId) {
        String SQL = "SELECT * FROM Staff WHERE staffId = ?";
        Staff staff = null;
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, staffId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                staff = new Staff(
                    rs.getInt("staffId"),
                    rs.getString("fullName")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving staff.");
            e.printStackTrace();
        }
        return staff;
    }

    // Update a staff member
    public void updateStaff(Staff staff) {
        String SQL = "UPDATE Staff SET fullName = ? WHERE staffId = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, staff.getFullName());
            pstmt.setInt(2, staff.getStaffId());
            pstmt.executeUpdate();
            System.out.println("Staff updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating staff.");
            e.printStackTrace();
        }
    }

    // Delete a staff member
    public void deleteStaff(int staffId) {
        String SQL = "DELETE FROM Staff WHERE staffId = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, staffId);
            pstmt.executeUpdate();
            System.out.println("Staff deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting staff.");
            e.printStackTrace();
        }
    }
}