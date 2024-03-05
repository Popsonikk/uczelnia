public class Main {
    public static void main(String[] args) {

        Thread thread2=new Thread(new EndThread());
        Thread thread3=new Thread(new EndThread());
        thread2.start();
        thread3.start();

        Thread thread=new Thread(new EndlessThread());
        Thread thread1=new Thread(new EndlessThread());
        thread1.start();
        thread.start();



    }
}