import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ThreadGroup tg =new ThreadGroup("group");

        for(int i=0;i<3;i++)
        {
            new Thread(tg,()->{
                System.out.println("Watek: "+Thread.currentThread().getName()+ " został uruchomiony");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Watek został przerwany");
                }
                System.out.println("Watek: "+Thread.currentThread().getName()+ " został zakończony");
            }).start();
        }

        System.out.println("Liczba aktywnych wątków w grupie: "+tg.activeCount());
        Thread[] threads = new Thread[tg.activeCount()];
        tg.enumerate(threads);
        System.out.println();
        System.out.println("Aktywne wątki w grupie:");
        for (Thread t : threads) {
            System.out.println(t.getName());
        }
        System.out.println();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tg.interrupt();


    }
}