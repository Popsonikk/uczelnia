import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class GenerateClass extends Thread {

    private Queue<Integer> queue;

    public GenerateClass(Queue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run()
    {
        Random random=new Random();
        while (true)
        {
            try
            {
                int x=random.nextInt(1000);
                System.out.println(Thread.currentThread().threadId()+": "+x);
                synchronized (queue) {
                    queue.add(x);
                    queue.notify();
                }
                    Thread.sleep((long) (random.nextDouble()*2000+1000));
            }
            catch (InterruptedException e) {
                System.out.println("Wątek zakończony");
                break;
            }

        }
    }
}
