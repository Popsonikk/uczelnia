import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

    public static Semaphore[] ubijacz;
    public static Semaphore[] zapałka;

    public static class Palacz extends Thread
    {
        private int number;

        public Palacz(int number) {
            this.number = number;
        }
        @Override
        public  void run()
        {
            while(true)
            {
                boolean ubity=false;
                for(int i=0;i<ubijacz.length;i++ )
                {
                    if(ubijacz[i].availablePermits()>0)
                    {
                        ubijacz[i].acquireUninterruptibly();
                        System.out.println("Palacz "+ number+" ubija fajkę");
                        ubity=true;
                        try {
                            Thread.sleep((long) (Math.random()*2000+1000));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        ubijacz[i].release();

                    }
                }
                if(!ubity)
                    continue;
                for(int i=0;i<zapałka.length;i++ )
                {
                    if(zapałka[i].availablePermits()>0)
                    {
                        zapałka[i].acquireUninterruptibly();
                        System.out.println("Palacz "+ number+" pali fajkę");

                        try {
                            Thread.sleep((long) (Math.random()*2000+1000));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        zapałka[i].release();

                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k= scanner.nextInt();
        int u= scanner.nextInt();
        int z= scanner.nextInt();
        ubijacz=new Semaphore[u];
        zapałka=new Semaphore[z];
        for(int i=0;i<u;i++)
            ubijacz[i]=new Semaphore(1);
        for(int i=0;i<z;i++)
            zapałka[i]=new Semaphore(1);
        for(int i=0;i<k;i++)
            new Palacz(i).start();


    }
}