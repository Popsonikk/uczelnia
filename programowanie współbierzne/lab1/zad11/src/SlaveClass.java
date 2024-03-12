import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class SlaveClass extends Thread {
    private boolean tryb;
    private int licznik;


    private BlockingQueue<Integer> queue;

    public SlaveClass(boolean tryb,BlockingQueue<Integer> queue) {
        this.tryb = tryb;

        this.queue=queue;


    }





    @Override
    public void run()
    {
        if(tryb)
            licznik=1;
        else
            licznik=2;
        while (true)
        {
            synchronized (queue)
            {
                try {
                    queue.put(licznik);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Wysłałem liczbę "+licznik);
            licznik+=2;
            try {
                Thread.sleep((long) (1000*new Random().nextDouble()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
