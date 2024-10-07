package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class GameCanvas extends javafx.scene.canvas.Canvas{
    private GraphicsContext graphicsContext = this.getGraphicsContext2D();
    private  Paddle paddle;
    private Ball ball;
    private List<Brick> brickList;
    private Boolean isRunning = false;
    public void initialize(){
        paddle = new Paddle();
        ball=new Ball();
        brickList = new ArrayList<>();
        Color[] colors=new Color[]{Color.BLUE,Color.GREEN,Color.GREY,Color.YELLOW,Color.ORANGE};
        Brick.setGrid(20,10);
        for(int i=0;i<5;i++){
            for(int j=0;j<Brick.getGridCols();j++){
                brickList.add(new Brick(j,i+2,colors[i]));
            }
        }
    }
    public GameCanvas() {
        super(640,800);
        GraphicsItem.setCanvasSize(getWidth(),getHeight());
        this.setOnMouseMoved(mouseEvent -> {
            paddle.setPosition(mouseEvent.getX());
            draw();
            if(!isRunning){
                ball.setPosition(new Point2D(mouseEvent.getX(),paddle.getY()));
            }
        });
        this.setOnMouseClicked(mouseEvent -> {
            isRunning = true;
            animationTimer.start();
        });
    }

    public void draw(){
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0,0,getWidth(),getHeight());
        paddle.draw(graphicsContext);
        ball.draw(graphicsContext);
        for(Brick b : brickList){
            b.draw(graphicsContext);
        }
    }
    private AnimationTimer animationTimer = new AnimationTimer() {
        private long lastUpdate;
        @Override
        public void handle(long now) {
            double sec = (now-lastUpdate)/1_000_000_000.;
            ball.updatePosition(sec);
            draw();
            lastUpdate = now;
            if(shouldBallBounceVertically()) ball.bounceVertically();
            if(shouldBallBounceHorizontally()|| shouldBallBounceFromPaddle()) ball.bounceHorizontally();
        }

        @Override
        public void start() {
            super.start();
            lastUpdate = System.nanoTime();
        }
    };
    private boolean shouldBallBounceHorizontally(){
        return ball.getLasty()>0 && ball.y<=0;
    };
    private boolean shouldBallBounceVertically(){
        return  (ball.x <= 0 && ball.getLastx() > 0)
                || (ball.x+ball.width >= getWidth() - 1 && ball.getLastx()+ball.width < getWidth() - 1);
    };
    private boolean shouldBallBounceFromPaddle(){
        return ball.getLasty()+ ball.height < paddle.y && ball.y+ ball.height >= paddle.y
                && ball.x >=paddle.x && ball.x <= paddle.x+paddle.width;
    };
}
