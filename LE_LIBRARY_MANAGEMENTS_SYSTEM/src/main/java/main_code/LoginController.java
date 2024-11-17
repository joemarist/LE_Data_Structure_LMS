package main_code;

import javafx.animation.*;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LoginController {

    @FXML
    private AnchorPane adminside;

    @FXML
    private Button close;

    @FXML
    private AnchorPane container;

    @FXML
    public AnchorPane pContainer;

    @FXML
    private AnchorPane sidedoor;

    @FXML
    private Button staffLog;

    @FXML
    private Button userLog;

    @FXML
    private Button exit;

    @FXML
    private PasswordField passwordtextfield;

    @FXML
    private TextField passwordTextVisible;

    @FXML
    private Button passButton;

    @FXML
    private ImageView passwordIcon;

    public void close() {
        System.exit(0);
    }

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

    @FXML
    void adminLogin(KeyEvent event) throws IOException {
        // Load the new scene (adminLogin_view.fxml)
        Parent root = FXMLLoader.load(getClass().getResource("adminLogin_view.fxml"));

        // Access the parent container directly (from controller)
        AnchorPane pContainer = this.pContainer;  // Using the pContainer from the controller

        // Set the initial position of the new root off-screen to the left (or right, depending on your preference)
        root.translateXProperty().set(-pContainer.getWidth()); // Start off-screen

        // Add the new root to the parent container
        pContainer.getChildren().add(root);

        // Create a timeline animation for sliding the new scene
        Timeline slideTimeline = new Timeline();
        KeyValue slideIn = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_BOTH); // Smooth slide to center
        KeyFrame slideKeyFrame = new KeyFrame(Duration.seconds(0.6), slideIn); // Slide in smoothly
        slideTimeline.getKeyFrames().add(slideKeyFrame);

        // Create a fade-in effect
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1.0), root);
        fadeIn.setFromValue(0);  // Start fully transparent
        fadeIn.setToValue(1);    // Fade in to fully opaque
        fadeIn.setInterpolator(Interpolator.EASE_BOTH);

        // When the slide and fade animations finish, remove the old scene
        slideTimeline.setOnFinished(t -> {
            pContainer.getChildren().remove(container); // Removes the old scene/container
        });

        // Play both animations simultaneously
        slideTimeline.play();

    }




@FXML
    public void initialize() {
        System.out.println("pContainer: " + pContainer);  // Check if it's null
    }
    @FXML
    public void switchLogins(ActionEvent event) throws IOException {
        // Load the new scene's root node
        Parent root = FXMLLoader.load(getClass().getResource("login_view.fxml"));

        // Get the current scene and its width
        Scene scene = exit.getScene();
        double sceneWidth = scene.getWidth();

        // Set the initial position of the new root off-screen to the right
        root.translateXProperty().set(sceneWidth);

        // Get the parent container (AnchorPane)
        AnchorPane pContainer = (AnchorPane) exit.getScene().getRoot();

        // Add the new root to the parent container
        pContainer.getChildren().add(root);

        // Create the animation timeline for the new scene sliding in from the right
        Timeline timeline = new Timeline();

        // Animate the new scene sliding in from the right to the center
        KeyValue kvIn = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame kfIn = new KeyFrame(Duration.seconds(0.6), kvIn); // Slide in faster and smoother
        timeline.getKeyFrames().add(kfIn);

        // Animate the old scene sliding out to the left
        KeyValue kvOut = new KeyValue(pContainer.getChildren().get(0).translateXProperty(), -sceneWidth, Interpolator.EASE_BOTH);
        KeyFrame kfOut = new KeyFrame(Duration.seconds(0.6), kvOut); // Slide out smoothly
        timeline.getKeyFrames().add(kfOut);

        // When the animation finishes, remove the old scene from the container
        timeline.setOnFinished(t -> {
            // Get the old scene (first child) and remove it
            Node oldRoot = pContainer.getChildren().get(0); // Assuming the old root is the first child
            pContainer.getChildren().remove(oldRoot); // Remove the old root
        });

        // Play the animation
        timeline.play();
    }


}