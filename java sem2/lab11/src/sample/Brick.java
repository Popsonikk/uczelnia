package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Brick extends GraphicsItem{
    private static int gridRows;
    private static int gridCols;
    private Color color;
    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(color);
        graphicsContext.fillRect(x,y,width,height);
        graphicsContext.setStroke(color.brighter());
        graphicsContext.strokeLine(x,y, x+width, y);
        graphicsContext.strokeLine(x,y, x, y+height);
        graphicsContext.setStroke(color.darker());
        graphicsContext.strokeLine(x,y+height, x+width, y+height);
        graphicsContext.strokeLine(x+width,y, x+width, y+height);
    }
    public static void setGrid(int a,int b)
    {
        Brick.gridRows=a;
        Brick.gridCols=b;
    }
    public Brick(int gridX,int gridY, Color color)
    {
        this.color=color;
        width=canvasWidth/gridCols;
        height=canvasHeight/gridRows;
        x=gridX*width;
        y=gridY*height;
    }

    public static int getGridRows() {
        return gridRows;
    }

    public static int getGridCols() {
        return gridCols;
    }
}
