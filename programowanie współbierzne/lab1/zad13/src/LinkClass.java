import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class LinkClass extends Thread{

    private BlockingQueue<Integer> input;
    private BlockingQueue<Integer> output;

    public LinkClass(BlockingQueue<Integer> input, BlockingQueue<Integer> output) {
        this.input = input;
        this.output = output;
    }
    private int sort(int x1,int x2)
    {
        if(x1>x2)
            return x1;
        else
            return x2;

    }
    @Override
    public void run()
    {
        while(true){
            try {
                int x1 = input.take();
                int x2 = input.take();
                int x3 = input.take();
                int x = sort(x1, sort(x2, x3));
                output.put(x);
                System.out.println("Przekazano: "+x);
            } catch (InterruptedException e) {
                System.out.println("Wątek zakończony");
            }
        }

    }
}
