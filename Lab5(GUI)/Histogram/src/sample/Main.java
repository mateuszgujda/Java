package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Histogram");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene my = new Scene(root);
        primaryStage.setScene(my);
        my.setFill(Color.ALICEBLUE);


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
