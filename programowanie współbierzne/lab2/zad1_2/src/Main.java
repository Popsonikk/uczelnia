import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        AtomicInteger czyjaKolej= new AtomicInteger(0);
        Thread t1=new Thread(()->{
            while(true)
            {
                try {
                    Thread.sleep((long) (Math.random()*2000));
                    while(czyjaKolej.get() !=0)
                    {
                        Thread.yield();
                    }
                    System.out.println("0 in");
                    Thread.sleep((long) (Math.random()*1000));
                    System.out.println("0 out");
                    czyjaKolej.set(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        Thread t2=new Thread(()->{
            while(true)
            {
                try {
                    Thread.sleep((long) (Math.random()*2000));
                    while(czyjaKolej.get() !=1)
                    {
                        Thread.yield();
                    }
                    System.out.println("1 in");
                    Thread.sleep((long) (Math.random()*1000));
                    System.out.println("1 out");
                    czyjaKolej.set(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        t1.start();
        t2.start();
    }
}