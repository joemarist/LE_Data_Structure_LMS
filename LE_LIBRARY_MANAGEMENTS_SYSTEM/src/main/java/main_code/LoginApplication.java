package main_code;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;

import java.io.IOException;


public class LoginApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login_view.fxml"));
        Parent root = loader.load();

        // Set the title of the window
        stage.setTitle("LMS!");

        // Set the application icon
        Image icon = new Image(getClass().getResource("icons/icon_LMS.png").toExternalForm());
        stage.getIcons().add(icon);

        // Get the controller of the FXML file
        LoginController key = loader.getController();
        Scene scene = new Scene(root);

// Set up the key press event handler
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // Check if Ctrl, Shift, and S are pressed together
                if (event.isControlDown() && event.isShiftDown() && event.getCode() == KeyCode.S) {
                    // Call the function you want to execute for Ctrl + Shift + S
                    try {
                        key.adminLogin(event);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });


        // Set the scene and apply a transparent window style
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);

        // Show the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
