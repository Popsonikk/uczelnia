package sample;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Widget widget= new Widget();
        AnchorPane anchorPane= new AnchorPane();
        anchorPane.getChildren().add(widget);
        primaryStage.setTitle("Kolokwium2");
        primaryStage.setScene(new Scene(anchorPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
