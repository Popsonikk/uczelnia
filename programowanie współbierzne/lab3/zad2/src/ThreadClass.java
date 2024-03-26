import java.util.concurrent.Semaphore;

public class ThreadClass implements Runnable{

    private int number;
    private Semaphore block;
    private Semaphore start;

    public ThreadClass(int number, Semaphore block, Semaphore start) {
        this.number = number;
        this.block = block;
        this.start = start;
    }

    @Override
    public void run() {
        System.out.println("Wątek "+number+" rozpoczyna pracę");
        start.release();
        start.acquireUninterruptibly();
        start.release();

        try
        {
            while(true)
            {
                System.out.println("Wątek "+number+" czeka");
                Thread.sleep((long) (5000*Math.random()));
                block.acquireUninterruptibly();

                System.out.println("Wątek "+number+" zaczyna sekcje krytyczną");
                Thread.sleep((long) (3000*Math.random()));
                System.out.println("Wątek "+number+" opuszcza sekcję krytyczną");
                block.release();
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Wątek zakończony");
        }


    }
}

