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

        static AtomicIntegerArray critical=new AtomicIntegerArray(2);
        static volatile int czyjaKolej=0;
        static{
            critical.set(0,1); //0-krytyczna , 1 lokalna
            critical.set(1,1);
        }
        @Override
        public void run()
        {

            while(true)
            {
                try {
                    Thread.sleep((long) (Math.random()*2000));
                    critical.set(number,0);
                    while(critical.get(1-number)==0)
                    {
                        critical.set(number,1);
                        while(czyjaKolej!=number)
                            Thread.yield();
                        critical.set(number,0);
                    }
                    System.out.println(number+" in");

                    Thread.sleep((long) (Math.random()*1000));
                    System.out.println(number+" out");
                    critical.set(number,1);
                    czyjaKolej=1-number;
                } catch (InterruptedException e) {
                    System.out.println("zakończono");
                    break;
                }
            }
        }
    }
}