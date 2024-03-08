import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class GenerateClass extends Thread {

    private BlockingQueue<Integer> queue;

    public GenerateClass(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run()
    {
        Random random=new Random();
        while (true)
        {

            int x=random.nextInt(1000);
            System.out.println(Thread.currentThread().threadId()+": "+x);
            try {
               queue.put(x);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep((long) (random.nextDouble()*2000+1000));
            } catch (InterruptedException e) {
                System.out.println("Wątek zakończony");
            }

        }
    }
}
