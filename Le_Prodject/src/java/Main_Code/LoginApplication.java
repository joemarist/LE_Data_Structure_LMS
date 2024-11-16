package Main_Code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginApplication extends Application {

    @Override
    public void start(Stage Stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login_view.fxml"));
        Scene scene = new Scene(root);
        Stage.setScene(scene);
        Stage.setTitle("LMS!");
        Stage.initStyle(StageStyle.TRANSPARENT);
        Stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
