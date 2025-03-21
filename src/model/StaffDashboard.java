package model;

import dao.ReservationDAO;
import dao.OrderDAO;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StaffDashboard {
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Staff Dashboard");

        VBox layout = new VBox(10);
        Label welcomeLabel = new Label("Welcome, Staff!");
        Button viewReservationsButton = new Button("View Reservations");
        Button viewOrdersButton = new Button("View Orders");
        Button logoutButton = new Button("Logout");

        // View Reservations Button Action
        viewReservationsButton.setOnAction(e -> {
            System.out.println("Viewing reservations...");
            ReservationDAO reservationDAO = new ReservationDAO();
            // Example: Retrieve a reservation by ID
            Reservation reservation = reservationDAO.getReservationById(1);
            if (reservation != null) {
                System.out.println("Reservation ID: " + reservation.getReservationId());
                System.out.println("Customer ID: " + reservation.getCustomerId());
                System.out.println("Table ID: " + reservation.getTableId());
                System.out.println("Reservation Time: " + reservation.getReservationTime());
                System.out.println("Status: " + reservation.getStatus());
            } else {
                System.out.println("Reservation not found.");
            }
        });

        // View Orders Button Action
        viewOrdersButton.setOnAction(e -> {
            System.out.println("Viewing orders...");
            OrderDAO orderDAO = new OrderDAO();
            // Example: Retrieve an order by ID
            Order order = orderDAO.getOrderById(1);
            if (order != null) {
                System.out.println("Order ID: " + order.getOrderID());
                System.out.println("Item Name: " + order.getItemName());
            } else {
                System.out.println("Order not found.");
            }
        });
        logoutButton.setOnAction(e -> {
            System.out.println("Logging out...");
            stage.close();
        });

        layout.getChildren().addAll(welcomeLabel, viewReservationsButton, viewOrdersButton,logoutButton);
        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}