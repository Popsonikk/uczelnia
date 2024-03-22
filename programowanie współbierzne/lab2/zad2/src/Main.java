import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t0=new CustomThread(0);
        Thread t1= new CustomThread(1);
        t0.start();
        t1.start();
        // Thread.sleep(5000);
        // t0.interrupt();




    }
    static class CustomThread extends Thread
    {
        private int number;

        public CustomThread(int number) {
            this.number = number;
        }

        static volatile int critical0= 1;
        static volatile int critical1= 1;
        static volatile int czyjaKolej=0;

        @Override
        public void run()
        {

            if(number==0)
            {
                while(true)
                {
                    try {
                        Thread.sleep((long) (Math.random()*2000));
                        critical0=0;
                        while(critical1==0)
                        {
                            critical0=1;
                            while(czyjaKolej!=number)
                                Thread.yield();
                            critical0=0;
                        }
                        System.out.println(number+" in");

                        Thread.sleep((long) (Math.random()*1000));
                        System.out.println(number+" out");
                        critical0=1;
                        czyjaKolej=1-number;
                    } catch (InterruptedException e) {
                        System.out.println("zakończono");
                        break;
                    }
                }
            }
            else
            {
                while(true)
                {
                    try {
                        Thread.sleep((long) (Math.random()*2000));
                        critical1=0;
                        while(critical0==0)
                        {
                            critical1=1;
                            while(czyjaKolej!=number)
                                Thread.yield();
                            critical1=0;
                        }
                        System.out.println(number+" in");

                        Thread.sleep((long) (Math.random()*1000));
                        System.out.println(number+" out");
                        critical1=1;
                        czyjaKolej=1-number;
                    } catch (InterruptedException e) {
                        System.out.println("zakończono");
                        break;
                    }
                }
            }

        }
    }
}