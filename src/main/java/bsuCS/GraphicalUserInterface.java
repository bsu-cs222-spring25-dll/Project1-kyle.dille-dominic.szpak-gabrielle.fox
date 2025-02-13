package bsuCS;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GraphicalUserInterface extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("test");
        Scene scene = new Scene(new javafx.scene.control.Label("foo"));
        primaryStage.show();
    }
    public static void main(String[] args) {launch(args);}
}
