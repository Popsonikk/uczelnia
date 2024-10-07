package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameCanvas gameCanvas= new GameCanvas();
        GridPane gridPane= new GridPane();
        gridPane.add(gameCanvas,0,0);
        primaryStage.setTitle("game");
        primaryStage.setScene(new Scene(gridPane));
        gameCanvas.initialize();
        gameCanvas.draw();
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
