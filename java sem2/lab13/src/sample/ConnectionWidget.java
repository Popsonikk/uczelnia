package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ConnectionWidget extends GridPane {//dziedziczenie po klasie od rysowania
     private TextField address;
     private Label addressLabel;
     private Button createGame;
     private Button joinGame;

    public ConnectionWidget() {
        this.address= new TextField("localhost");
        this.addressLabel = new Label("adres");
        this.createGame= new Button("Create");
        this.joinGame= new Button("Join");
        add(addressLabel,0,1);//int określa pozycje na siatce
        add(address,1,1);
        add(joinGame,0,2);
        add(createGame,0,0);
    }
    public  void setCreateListener(Main.CreateListener listener)
    {
        createGame.setOnAction(actionEvent -> {
            listener.method();
        });
    }
    public  void setJoinListener(Main.JoinListener listener)
    {
        joinGame.setOnAction(actionEvent -> {
            listener.method(address.getText());
        });
    }
}
