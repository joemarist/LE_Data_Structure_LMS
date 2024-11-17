package main_code;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
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
import javafx.util.Duration;


public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button close;

    public void close(){
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

            // Update the icon (if you want to change the icon dynamically)
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

    public void switchLogin(ActionEvent event) throws Exception {
        // Get the current stage and scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("login_view.fxml"));

        // Create a fade-out transition for the current scene
        Scene currentScene = stage.getScene();
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), currentScene.getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        // Set the on-finished event to load the new scene after fade-out
        fadeOut.setOnFinished(e -> {
            // Set the new scene
            Scene newScene = new Scene(newRoot);
            stage.setScene(newScene);

            // Create a fade-in transition for the new scene
            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newRoot);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });

        // Play the fade-out transition
        fadeOut.play();
    }





    public void switchStaff(ActionEvent event) throws Exception {
        // Get the current stage and scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("staffLogin_view.fxml"));

        // Create a fade-out transition for the current scene
        Scene currentScene = stage.getScene();
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), currentScene.getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        // Set the on-finished event to load the new scene after fade-out
        fadeOut.setOnFinished(e -> {
            // Set the new scene
            Scene newScene = new Scene(newRoot);
            stage.setScene(newScene);

            // Create a fade-in transition for the new scene
            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newRoot);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });

        // Play the fade-out transition
        fadeOut.play();
    }




}


