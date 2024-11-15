package Main_Code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;








import javafx.scene.layout.StackPane;
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

    public void switchLogin(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login_view.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchStaff(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("staffLogin_view.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }









}


