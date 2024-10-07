package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Arrays;

public class GameWidget extends Canvas {// canvas daje graphiccontext
    public GameWidget() {
        super(300,300);//rozmiar okna
        for(Symbol row[]:fields)
            Arrays.fill(row,Symbol.Empty);
        setOnMouseClicked(mouseEvent -> {
            double x= mouseEvent.getX();
            double y =mouseEvent.getY();
            int  posx= (int) (x/(getWidth()/3));
            int posy= (int) (y/(getHeight()/3));
            setSymbol(Symbol.X,posx,posy);
            draw();
        });
        draw();

    }
    void setSymbol(Symbol symbol, int x,int y) throws IndexOutOfBoundsException
    {
        fields[x][y]=symbol;
    }
    void draw()
    {
        GraphicsContext graphicsContext= getGraphicsContext2D();// służy do rysowania
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0,0,getWidth(),getHeight());//rysowanie prostokata
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.setFont(Font.font(30));// czcionka
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                switch(fields[i][j]){
                    case O: graphicsContext.fillText("O",getWidth()/3*i+getWidth()/6,getHeight()/3*j+getHeight()/6); break;
                    case X: graphicsContext.fillText("X",getWidth()/3*i+getWidth()/6,getHeight()/3*j+getHeight()/6);  break;
                }
            }
        }
    }
    enum Symbol{X,O,Empty};
    Symbol [][]fields= new Symbol[3][3];//plansza w sumie
}
