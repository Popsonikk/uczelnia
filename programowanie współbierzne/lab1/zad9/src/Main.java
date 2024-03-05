import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger number=new AtomicInteger();
        Thread t1=new Thread(()->{
            number.set(new Random().nextInt(10000));
            System.out.println(number.get());
        });
        Thread t2=new Thread(()->{
            number.set(number.get()+2);
        });
        Thread t3=new Thread(()->{
            System.out.println(number.get());
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();

    }
}