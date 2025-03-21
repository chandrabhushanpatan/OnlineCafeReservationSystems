package model;


public class Table {
    // Attributes
    private int tableId;
    private int capacity;
    private String status; // e.g., "Available", "Reserved"

    // Constructor
    public Table(int tableId, int capacity, String status) {
        this.tableId = tableId;
        this.capacity = capacity;
        this.status = status;
    }

    // Getters and Setters
    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
