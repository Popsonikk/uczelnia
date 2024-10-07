package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
   //opcjonalnie
    @FunctionalInterface //interfejs,który jest wykorzystywany gdzie funkcjonał jest potrzebny np wyrarzenia lanba, dokładnie 1 medoda abstrakcyjna
    public interface  CreateListener{
        void method();
    }
    @FunctionalInterface //interfejs,który jest wykorzystywany gdzie funkcjonał jest potrzebny np wyrarzenia lanba, dokładnie 1 medoda abstrakcyjna
    public interface  JoinListener{
        void method(String address);
    }
    void showGameWidget()
    {
        Stage stage=new Stage();//tworzenie okienka gry
        GameWidget gameWidget = new GameWidget();
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(gameWidget);
        stage.setScene(new Scene(anchorPane));
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        CreateListener createListener=()->{//przycisk create, obsluga interfejsu
            Server server= new Server(3000,this);
            server.start();
            Client client= new Client(3000,"localhost");
            //showGameWidget();

        };
        ConnectionWidget connectionWidget = new ConnectionWidget();
        connectionWidget.setCreateListener(createListener);
        connectionWidget.setJoinListener( (address)->{//obsluga interfejsu
            Client client= new Client(3000,address);
            showGameWidget();
        });
        primaryStage.setTitle("Gra");
        primaryStage.setScene(new Scene(connectionWidget, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
