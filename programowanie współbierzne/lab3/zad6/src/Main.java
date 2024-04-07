import java.util.concurrent.Semaphore;

public class Main {
    public static Semaphore[] jadalnia=new Semaphore[5];
    public static Semaphore[] widelec=new Semaphore[5];

    public static class Filozof extends Thread
    {
        private int number;
        private int lewy;
        private int prawy;

        public Filozof(int number) {
            this.number=number;

            if(number==0)
                this.lewy=4;
            else
                this.lewy=number-1;
            this.prawy=number%5;

        }

        @Override
        public void run()
        {
            while(true)
            {
                try {
                    Thread.sleep((long) (Math.random()*1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                while(widelec[lewy].availablePermits()==0||widelec[prawy].availablePermits()==0)
                    Thread.yield();
                widelec[lewy].acquireUninterruptibly();
                widelec[prawy].acquireUninterruptibly();
                jadalnia[number].acquireUninterruptibly();
                System.out.println("Filozof "+number+" rozpoczyna jedzenie");
                try {
                    Thread.sleep((long) (Math.random()*2000+1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Filozof "+number+" kończy jedzenie");
                widelec[lewy].release();
                widelec[prawy].release();
                jadalnia[number].release();


            }
        }
    }
    public static void main(String[] args) {
        for(int i=0;i<5;i++)
        {
            jadalnia[i]=new Semaphore(1);
            widelec[i]=new Semaphore(1);
        }
        for(int i=0;i<5;i++)
        {
            new Filozof(i).start();
        }




    }
}