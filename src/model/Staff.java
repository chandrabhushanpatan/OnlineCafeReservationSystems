package model;

public class Staff {
	 // Attributes
    private int staffId;
    private String fullName;
    

    // Constructor
    public Staff(int staffId, String fullName) {
        this.staffId = staffId;
        this.fullName = fullName;
    }

    // Getters and Setters
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}



