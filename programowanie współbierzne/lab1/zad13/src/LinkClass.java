import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class LinkClass extends Thread{

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private Queue<Integer> q3;
    private Queue<Integer> output;

    public LinkClass(Queue<Integer> q1, Queue<Integer> q2, Queue<Integer> q3, Queue<Integer> output) {
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.output = output;
    }

    private int sort(int x1, int x2)
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
            try{
                while(q1.isEmpty())
                {

                    synchronized (q1)
                    {
                        q1.wait();
                    }

                }
                int x1 = q1.poll();
                while(q2.isEmpty())
                {

                    synchronized (q2)
                    {
                        q2.wait();
                    }

                }
                int x2 = q2.poll();
                while(q3.isEmpty())
                {

                    synchronized (q3)
                    {
                        q3.wait();
                    }

                }
                int x3 = q3.poll();
                int x = sort(x1, sort(x2, x3));
                synchronized (output)
                {
                    output.add(x);
                    output.notify();
                }

                System.out.println("Przekazano: "+x);

            }
            catch (InterruptedException e)
            {
                System.out.println("Wątek zakończony");
                break;
            }

        }

    }
}
