package main_code;

import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
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

        // Get the controller instance from the FXMLLoader
        LoginController controller = loader.getController();
        Scene scene = new Scene(root);


        scene.setOnKeyPressed(event -> {
            // Check if Control + Shift + S is pressed, and that path is not "login"
            if (event.isControlDown() && event.isShiftDown() && event.getCode() == KeyCode.S) {

                try {
                    // Check if path is NOT "login" before triggering adminLogin
                    if (controller.getPath() < 1 ){  // Use the getter for path
                        controller.adminLogin(event); // Perform admin login action
                    } else {
                        // Optionally handle the case where path is "login"
                        System.out.println("Currently on login view, no action taken.");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });



        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);

        // Show the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
