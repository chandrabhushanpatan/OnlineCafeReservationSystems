package model;

import java.time.LocalDateTime;

public class Reservation {
    // Attributes
    private int reservationId;
    private int customerId;
    private int tableId;
    private LocalDateTime reservationTime;
    private String status; // e.g., "Confirmed", "Cancelled"

    // Constructor
    public Reservation(int reservationId, int customerId, int tableId, LocalDateTime reservationTime, String status) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.tableId = tableId;
        this.reservationTime = reservationTime;
        this.status = status;
    }

    // Getters and Setters
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
