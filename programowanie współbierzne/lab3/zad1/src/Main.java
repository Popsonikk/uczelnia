import java.util.concurrent.Semaphore;

public class Main {

    public static Semaphore s=new Semaphore(1);
    public static void main(String[] args) {

        new Thread(new ThreadClass1(1)).start();
        new Thread(new ThreadClass1(2)).start();


    }
}