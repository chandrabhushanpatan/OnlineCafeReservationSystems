package model;


public class Manager {
    // Attributes
    private int managerId;
    private String fullName;

    // Constructor
    public Manager(int managerId, String fullName) {
        this.managerId = managerId;
        this.fullName = fullName;
    }

    // Getters and Setters
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
