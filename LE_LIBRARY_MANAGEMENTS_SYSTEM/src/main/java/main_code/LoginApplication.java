package main_code;

import javafx.application.Application;
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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("login_view.fxml"));
        Parent root = loader.load();
        stage.setTitle("LMS!");

        Image icon = new Image(getClass().getResource("icons/icon_LMS.png").toExternalForm());
        stage.getIcons().add(icon);

        LoginController controller = loader.getController();
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.isShiftDown() && event.getCode() == KeyCode.S) {
                    try {
                        controller.adminLogin(event);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }
        });

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
