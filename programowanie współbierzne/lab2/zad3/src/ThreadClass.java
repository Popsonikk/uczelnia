public class ThreadClass extends Thread {
    static volatile int w0=1;
    static volatile int w1=1;
    static volatile int ostatni=0;
    private final int number;

    public ThreadClass(int number) {
        this.number = number;
    }
    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                Thread.sleep((long) (2000*Math.random()));
                if(number==0)
                {
                    w0=1;
                    ostatni=0;
                    while(w1!=0&&ostatni==0)
                        Thread.yield();
                }
                else
                {
                    w1=1;
                    ostatni=1;
                    while(w0!=0&&ostatni==1)
                        Thread.yield();
                }



                System.out.println(number+" in");
                Thread.sleep((long) (1000*Math.random()));
                System.out.println(number+" out");
                if(number==0)
                    w0=0;
                else
                    w1=0;
            }

        }
        catch (InterruptedException  e)
        {
            System.out.println("Wątek zakończony");
        }

    }

}
