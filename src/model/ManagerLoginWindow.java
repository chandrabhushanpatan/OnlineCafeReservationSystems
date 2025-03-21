package model;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ManagerLoginWindow {
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Manager Login");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label userLabel = new Label("Username:");
        TextField userField = new TextField();
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            // Validate credentials (dummy validation)
            if (userField.getText().equals("manager") && passField.getText().equals("1234")) {
                ManagerDashboard dashboard = new ManagerDashboard();
                dashboard.show();
                stage.close();
            } else {
                System.out.println("Invalid credentials");
            }
        });

        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(loginButton, 1, 2);

        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}