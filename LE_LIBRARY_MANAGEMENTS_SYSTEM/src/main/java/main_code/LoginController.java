package main_code;

import javafx.animation.*;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button close;

    public void close() {
        System.exit(0);
    }

    @FXML
    private Button exit;

    @FXML
    private AnchorPane container;

    @FXML
    private Button staffLog;

    @FXML
    private PasswordField passwordtextfield;

    @FXML
    private TextField passwordTextVisible;

    @FXML
    private Button passButton;

    @FXML
    private ImageView passwordIcon;

    private boolean isPasswordVisible = false;

    @FXML
    public void togglePasswordVisibility() {
        if (isPasswordVisible) {
            // Hide plain text and show PasswordField
            passwordTextVisible.setVisible(false);
            passwordtextfield.setText(passwordTextVisible.getText());
            passwordtextfield.setVisible(true);

            // Update the icon
            passwordIcon.setImage(new Image(getClass().getResourceAsStream("icons/passIconeyeshow.png")));
        } else {
            // Show plain text and hide PasswordField
            passwordtextfield.setVisible(false);
            passwordTextVisible.setText(passwordtextfield.getText());
            passwordTextVisible.setVisible(true);

            // Update the icon
            passwordIcon.setImage(new Image(getClass().getResourceAsStream("icons/passIconeyehide.png")));
        }
        isPasswordVisible = !isPasswordVisible;
    }
    @FXML
    private AnchorPane pContainer;


    @FXML
    private void switchLogin(ActionEvent event) throws IOException {
        // Load the new scene (scene1.fxml)
        Parent root = FXMLLoader.load(getClass().getResource("login_view.fxml"));

        // Get the current scene and set the initial position of the new root
        Scene scene = exit.getScene();
        root.translateXProperty().set(-scene.getWidth()); // Start outside the left edge

        // Get the parent container (assumes StackPane is the root)
        AnchorPane pContainer = (AnchorPane) exit.getScene().getRoot();

        // Add the new root to the parent container
        pContainer.getChildren().add(root);

        // Create a timeline animation for sliding from left to right
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_BOTH); // Smooth slide to center
        KeyFrame kf = new KeyFrame(Duration.seconds(0.6), kv); // Slightly faster and smoother
        timeline.getKeyFrames().add(kf);

        // Remove the old scene after the animation completes
        timeline.setOnFinished(t -> {
            pContainer.getChildren().remove(container);
        });

        // Play the animation
        timeline.play();
    }

    public void switchStaff(ActionEvent event)throws IOException  {
        // Load the new scene
        Parent root = FXMLLoader.load(getClass().getResource("staffLogin_view.fxml"));

        // Get the current scene and its width
        Scene currentScene = ((Node) event.getSource()).getScene();
        double sceneWidth = currentScene.getWidth();

        // Add the new scene to the container
        root.translateXProperty().set(sceneWidth); // Start new scene off-screen to the right
        pContainer.getChildren().add(root); // Assuming pContainer is an AnchorPane

        // Create the animation timeline
        Timeline timeline = new Timeline();

        // Animate the new scene sliding in
        KeyValue kvIn = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_BOTH); // Smooth slide to center
        KeyFrame kfIn = new KeyFrame(Duration.seconds(0.6), kvIn); // Slightly faster and smoother
        timeline.getKeyFrames().add(kfIn);

        // When the animation finishes
        timeline.setOnFinished(t -> {
            // Remove the old scene from the container
            Node container = pContainer.getChildren().get(0); // First child is the current scene
            pContainer.getChildren().remove(container); // Remove old scene
        });

        // Play the animation
        timeline.play();
    }

    public void switchUser(ActionEvent event)throws IOException  {
        // Load the new scene
        Parent root = FXMLLoader.load(getClass().getResource("userLogin_view.fxml"));

        // Get the current scene and its width
        Scene currentScene = ((Node) event.getSource()).getScene();
        double sceneWidth = currentScene.getWidth();

        // Add the new scene to the container
        root.translateXProperty().set(sceneWidth); // Start new scene off-screen to the right
        pContainer.getChildren().add(root); // Assuming pContainer is an AnchorPane

        // Create the animation timeline
        Timeline timeline = new Timeline();

        // Animate the new scene sliding in
        KeyValue kvIn = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_BOTH); // Smooth slide to center
        KeyFrame kfIn = new KeyFrame(Duration.seconds(0.6), kvIn); // Slightly faster and smoother
        timeline.getKeyFrames().add(kfIn);

        // When the animation finishes
        timeline.setOnFinished(t -> {
            // Remove the old scene from the container
            Node container = pContainer.getChildren().get(0); // First child is the current scene
            pContainer.getChildren().remove(container); // Remove old scene
        });

        // Play the animation
        timeline.play();
    }
}