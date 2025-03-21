package model;

import dao.ManagerDAO;
import dao.OrderDAO;
import dao.ReservationDAO;
import dao.StaffDAO;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagerDashboard {
    private Stage stage;

    public ManagerDashboard() {
        stage = new Stage();
        stage.setTitle("Manager Dashboard");
        
        VBox layout = new VBox(10);
        
        Button viewReservationsButton = new Button("View Reservations");
        Button viewOrdersButton = new Button("View Orders");
        

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

        GridPane grid = new GridPane();
        grid.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label welcomeLabel = new Label("Welcome to the Manager Dashboard!");
        grid.add(welcomeLabel, 0, 0);

        Button addStaffButton = new Button("Add Staff");
        grid.add(addStaffButton, 0, 1);

        Button viewStaffButton = new Button("View Staff");
        grid.add(viewStaffButton, 0, 2);
        
        Button viewOrderButton = new Button("View Order");
        grid.add(viewOrderButton, 0, 3);
        
        Button viewReservationButton = new Button("View Reservation");
        grid.add(viewReservationButton, 0, 4);

        

        Button logoutButton = new Button("Logout");
        grid.add(logoutButton, 0, 5);

        addStaffButton.setOnAction(e -> {
            // Example: Insert a new manager
            ManagerDAO managerDAO = new ManagerDAO();
            Manager manager = new Manager(0, "Jane Doe");
            managerDAO.insertManager(manager);
        });

        viewStaffButton.setOnAction(e -> {
            // Example: Retrieve a manager by ID
            StaffDAO staffDAO = new StaffDAO();
            Staff staff = staffDAO.getStaffById(1);
            if (staff != null) {
                System.out.println("Staff: " + staff.getFullName());
            }
        });

        logoutButton.setOnAction(e -> {
            System.out.println("Logging out...");
            stage.close();
        });

        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}