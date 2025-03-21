package model;

public class Order {
	// Attributes
    private int orderID;
    private String itemName;
    
    

    // Constructor
    public Order(int orderID, String itemName) {
    	this.orderID = orderID;
        this.itemName = itemName;
        
    }

    // Getters and Setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

      
}



