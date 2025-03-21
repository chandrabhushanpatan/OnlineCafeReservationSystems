package model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CafeReservationSystem extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cafe Reservation System");

        Button customerButton = new Button("Customer");
        Button staffButton = new Button("Staff");
        Button managerButton = new Button("Manager");

        customerButton.setOnAction(e -> {
            CustomerLoginWindow customerLogin = new CustomerLoginWindow();
            customerLogin.show();
        });

        staffButton.setOnAction(e -> {
            StaffLoginWindow staffLogin = new StaffLoginWindow();
            staffLogin.show();
        });

        managerButton.setOnAction(e -> {
            ManagerLoginWindow managerLogin = new ManagerLoginWindow();
            managerLogin.show();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(20));
        layout.getChildren().addAll(customerButton, staffButton, managerButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}