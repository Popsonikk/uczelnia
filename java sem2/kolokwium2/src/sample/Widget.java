package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
public class Widget extends Canvas {

    GraphicsContext graphicsContext = getGraphicsContext2D();
    Server server;
    List <ClientThread> clientThreads= new ArrayList<>();
    public Widget() {
        super(500, 500);

        this.server= new Server(5000);
        server.start();
        this.clientThreads=server.getList();
        draw();

    }

    public void draw() {

        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, getWidth(), getHeight());
        graphicsContext.setFill(Color.BLACK);
        for(ClientThread client:clientThreads)
        {
            drawLine(client.getMessage());
        }

    }
    public void drawLine(String message) {

        if (message.length() == 6) {
            graphicsContext.setFill(Color.web(message));
        } else {
            String[] arr = message.split(" ",4);
            float[] values = new float[4];
            for (int i=0;i<4;i++) {
                values[i]=Float.parseFloat(arr[i]);
            }
            graphicsContext.strokeLine( values[0], values[1], values[2], values[3]);
        }
    }

}
