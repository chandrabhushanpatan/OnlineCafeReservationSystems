package model;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class CustomerLoginWindow {
    private Map<String, String> users = new HashMap<>();

    public CustomerLoginWindow() {
        users.put("customer", "1234");
    }

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Customer Login");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label userLabel = new Label("Username:");
        TextField userField = new TextField();
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
        Button loginButton = new Button("Login");
        Button createAccountButton = new Button("Create Account");

        loginButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();

            if (users.containsKey(username) && users.get(username).equals(password)) {
                System.out.println("Login successful!");
                CustomerDashboard dashboard = new CustomerDashboard();
                dashboard.show();
                stage.close();
            } else {
                System.out.println("Invalid credentials");
            }
        });

        createAccountButton.setOnAction(e -> {
            Stage createAccountStage = new Stage();
            createAccountStage.setTitle("Create Account");

            GridPane createAccountGrid = new GridPane();
            createAccountGrid.setHgap(10);
            createAccountGrid.setVgap(10);

            Label nameLabel = new Label("Name:");
            TextField nameField = new TextField();
            Label newUserLabel = new Label("Username:");
            TextField newUserField = new TextField();
            Label newPassLabel = new Label("Password:");
            PasswordField newPassField = new PasswordField();
            Button saveButton = new Button("Save");

            saveButton.setOnAction(event -> {
                String name = nameField.getText();
                String username = newUserField.getText();
                String password = newPassField.getText();

                if (!username.isEmpty() && !password.isEmpty()) {
                    users.put(username, password);
                    System.out.println("Account created: " + name + ", " + username + ", " + password);
                    createAccountStage.close();
                } else {
                    System.out.println("Username and password cannot be empty!");
                }
            });

            createAccountGrid.add(nameLabel, 0, 0);
            createAccountGrid.add(nameField, 1, 0);
            createAccountGrid.add(newUserLabel, 0, 1);
            createAccountGrid.add(newUserField, 1, 1);
            createAccountGrid.add(newPassLabel, 0, 2);
            createAccountGrid.add(newPassField, 1, 2);
            createAccountGrid.add(saveButton, 1, 3);

            Scene createAccountScene = new Scene(createAccountGrid, 300, 200);
            createAccountStage.setScene(createAccountScene);
            createAccountStage.show();
        });

        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.add(createAccountButton, 1, 3);

        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}