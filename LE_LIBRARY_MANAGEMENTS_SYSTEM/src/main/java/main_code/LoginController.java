package main_code;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.animation.Interpolator;
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
    private AnchorPane setframe;

    @FXML
    private AnchorPane sidedoor;







    private void slideOutAndSwitch(String fxmlFile, Node slidingPane, Node currentNode, boolean slideLeft) {
        // Get the width of the slidingPane
        double paneWidth = slidingPane.getLayoutBounds().getWidth();

        // Create a slide-out transition
        TranslateTransition slideOut = new TranslateTransition(Duration.millis(500), slidingPane);
        slideOut.setByX(slideLeft ? -paneWidth : paneWidth); // Slide left or right based on direction
        slideOut.setInterpolator(Interpolator.EASE_BOTH);

        // Create a fade-out effect for the sliding pane
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), slidingPane);
        fadeOut.setToValue(0); // Fade out to transparency

        // Play both transitions together
        slideOut.setOnFinished(event -> {
            try {
                // Set the sliding pane to its final position (off-screen)
                slidingPane.setTranslateX(slideLeft ? -paneWidth : paneWidth);

                // Make `setframe` visible with a fade-in effect
                setframe.setVisible(true);
                FadeTransition fadeIn = new FadeTransition(Duration.millis(500), setframe);
                fadeIn.setFromValue(0); // Start fully transparent
                fadeIn.setToValue(1);   // End fully opaque
                fadeIn.play();

                // Optionally load the new scene (if required)
                Parent newRoot = FXMLLoader.load(getClass().getResource(fxmlFile));
                Scene newScene = new Scene(newRoot);
                Stage stage = (Stage) currentNode.getScene().getWindow();
                stage.setScene(newScene);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Play both slide and fade animations
        slideOut.play();
        fadeOut.play();
    }

    @FXML
    public void switchLogin(ActionEvent event) {
        slideOutAndSwitch("login_view.fxml", sidedoor, container, false); // Slide out to the right
    }

    @FXML
    public void switchStaff(ActionEvent event) {
        slideOutAndSwitch("staffLogin_view.fxml", sidedoor, container, true); // Slide out to the left
    }
}