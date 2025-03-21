package dao;

import model.Reservation;
import Myjdbc.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO {

    // Insert a new reservation into the database
    public void insertReservation(Reservation reservation) {
        String SQL = "INSERT INTO Reservations (customerId, tableId, reservationTime, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, reservation.getCustomerId());
            pstmt.setInt(2, reservation.getTableId());
            pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(reservation.getReservationTime()));
            pstmt.setString(4, reservation.getStatus());
            pstmt.executeUpdate();
            System.out.println("Reservation inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting reservation.");
            e.printStackTrace();
        }
    }

    // Retrieve a reservation by ID
    public Reservation getReservationById(int reservationId) {
        String SQL = "SELECT * FROM Reservations WHERE reservationId = ?";
        Reservation reservation = null;
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, reservationId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                reservation = new Reservation(
                    rs.getInt("reservationId"),
                    rs.getInt("customerId"),
                    rs.getInt("tableId"),
                    rs.getTimestamp("reservationTime").toLocalDateTime(),
                    rs.getString("status")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving reservation.");
            e.printStackTrace();
        }
        return reservation;
    }

    // Update a reservation's details
    public void updateReservation(Reservation reservation) {
        String SQL = "UPDATE Reservations SET customerId = ?, tableId = ?, reservationTime = ?, status = ? WHERE reservationId = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, reservation.getCustomerId());
            pstmt.setInt(2, reservation.getTableId());
            pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(reservation.getReservationTime()));
            pstmt.setString(4, reservation.getStatus());
            pstmt.setInt(5, reservation.getReservationId());
            pstmt.executeUpdate();
            System.out.println("Reservation updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating reservation.");
            e.printStackTrace();
        }
    }

    // Delete a reservation by ID
    public void deleteReservation(int reservationId) {
        String SQL = "DELETE FROM Reservations WHERE reservationId = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, reservationId);
            pstmt.executeUpdate();
            System.out.println("Reservation deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting reservation.");
            e.printStackTrace();
        }
    }
}