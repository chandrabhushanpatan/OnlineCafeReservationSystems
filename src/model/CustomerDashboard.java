package model;

import dao.CustomerDAO;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerDashboard {
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Customer Dashboard");

        VBox layout = new VBox(10);
        Label welcomeLabel = new Label("Welcome, Customer!");
        Button bookTableButton = new Button("Book Table");
        Button placeOrderButton = new Button("Place Order");
        
        Button logoutButton = new Button("Logout");
        

        bookTableButton.setOnAction(e -> {
            // Example: Insert a new customer
            CustomerDAO customerDAO = new CustomerDAO();
            Customer customer = new Customer(0, "Ram ", "ram@example.com", "1234567890", " Lahan ");
            customerDAO.insertCustomer(customer);
        });

        placeOrderButton.setOnAction(e -> {
            System.out.println("Order placed!");
        });
        logoutButton.setOnAction(e -> {
            System.out.println("Logging out...");
            stage.close();
        });

        layout.getChildren().addAll(welcomeLabel, bookTableButton, placeOrderButton, logoutButton);
        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}