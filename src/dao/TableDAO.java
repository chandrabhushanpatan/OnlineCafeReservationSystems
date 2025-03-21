package dao;

import model.Table;
import Myjdbc.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableDAO {

    // Insert a new table
    public void insertTable(Table table) {
        String SQL = "INSERT INTO Tables (capacity, status) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, table.getCapacity());
            pstmt.setString(2, table.getStatus());
            pstmt.executeUpdate();
            System.out.println("Table inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting table.");
            e.printStackTrace();
        }
    }

    // Retrieve a table by ID
    public Table getTableById(int tableId) {
        String SQL = "SELECT * FROM Tables WHERE tableId = ?";
        Table table = null;
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, tableId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                table = new Table(
                    rs.getInt("tableId"),
                    rs.getInt("capacity"),
                    rs.getString("status")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving table.");
            e.printStackTrace();
        }
        return table;
    }

    // Update a table
    public void updateTable(Table table) {
        String SQL = "UPDATE Tables SET capacity = ?, status = ? WHERE tableId = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, table.getCapacity());
            pstmt.setString(2, table.getStatus());
            pstmt.setInt(3, table.getTableId());
            pstmt.executeUpdate();
            System.out.println("Table updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating table.");
            e.printStackTrace();
        }
    }

    // Delete a table
    public void deleteTable(int tableId) {
        String SQL = "DELETE FROM Tables WHERE tableId = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, tableId);
            pstmt.executeUpdate();
            System.out.println("Table deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting table.");
            e.printStackTrace();
        }
    }
}