package sample;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends  GraphicsItem{
    private Point2D moveVector= new Point2D(1,-1).normalize();
    private  double velocity=200;

    public double getLastx() {
        return lastx;
    }

    public double getLasty() {
        return lasty;
    }

    private double lastx,lasty;
    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillOval(x,y,width,height); //rysowanie kółka

    }
    public void setPosition(Point2D point2D)
    {
        x=point2D.getX()-width/2;
        y=point2D.getY()-width/2;
    }

    public Ball() {
        width=height=canvasHeight*0.02;
    }
    public void updatePosition(double n)
    {
        lastx=x;
        lasty=y;
        x+=moveVector.getX()*velocity*n;
        y+=moveVector.getY()*velocity*n;
    }
    public void bounceHorizontally()
    {
        moveVector= new Point2D(moveVector.getX(),-moveVector.getY()).normalize();
    }
     public void bounceVertically()
     {
         moveVector= new Point2D(-moveVector.getX(),moveVector.getY()).normalize();
     }

}
