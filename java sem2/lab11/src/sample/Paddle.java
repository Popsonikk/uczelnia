package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Paddle extends GraphicsItem{

    public Paddle()
    {
        height=canvasHeight*0.02;
        width=canvasWidth*0.2;         //ustawianie współrzędnych platformy
        x=(canvasWidth-width)/2;
        y=canvasHeight*0.9;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(x,y,width,height);//rysowanie prostokąta
    }
    public  static  double clamp(double value,double min,double max)
    {
        return Math.max(min,Math.min(value,max));
    }
    public  void setPosition(double x)
    {
        this.x=clamp(x-width/2,0,canvasWidth-width);
    }
}
