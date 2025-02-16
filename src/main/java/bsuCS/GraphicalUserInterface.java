package bsuCS;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GraphicalUserInterface extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        VBox parent = new VBox();
        parent.getChildren().add(new Label("yo"));

        HBox articleInputArea = new HBox(new Label("Input an article title: "));
        TextField inputTextField = new TextField();
        articleInputArea.getChildren().add(inputTextField);
        parent.getChildren().add(articleInputArea);

        TextField outputTextField = new TextField();
        outputTextField.autosize();
        parent.getChildren().add(outputTextField);

        Button button = new Button("find edit history");
        parent.getChildren().add(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    String userInput = wikiPullModel.pullEditHistory(inputTextField.getText());
                    outputTextField.setText(userInput);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });



        primaryStage.setTitle("test");
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
    public static void main(String[] args) {launch(args);}
}
