package sample;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class GraphicsItem {
    protected  static double canvasWidth,canvasHeight;
    protected    double x,y,width,height;
    public static void setCanvasSize(double canvasWidth,double canvasHeight) {
        GraphicsItem.canvasWidth = canvasWidth;
        GraphicsItem.canvasHeight = canvasHeight;
    }
    public abstract void draw(GraphicsContext graphicsContext);

    public  double getX() {
        return x;
    }

    public  double getY() {
        return y;
    }

    public  double getWidth() {
        return width;
    }

    public  double getHeight() {
        return height;
    }
}
