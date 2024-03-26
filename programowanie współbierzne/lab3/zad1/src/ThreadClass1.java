public class ThreadClass1 implements Runnable{

    private int number;

    public ThreadClass1(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Wątek "+number+" rozpoczyna pracę");
        try
        {
            while(true)
            {
                System.out.println("Wątek "+number+" czeka");
                Thread.sleep((long) (5000*Math.random()));
                Main.s.acquireUninterruptibly();

                System.out.println("Wątek "+number+" zaczyna sekcje krytyczną");
                Thread.sleep((long) (3000*Math.random()));
                System.out.println("Wątek "+number+" opuszcza sekcję krytyczną");
                Main.s.release();
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Wątek zakończony");
        }


    }
}
