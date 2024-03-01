import java.util.ArrayList;
import java.util.List;


public class Main {
    private static class ThreadClass implements Runnable
    {


        public ThreadClass() {

        }

        @Override
        public void run() {
            System.out.println("Start "+Thread.currentThread().getName());
            for(int j=0;j<5;j++)
            {
                System.out.println(Thread.currentThread().getName()+" : " +j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("proces "+Thread.currentThread().getName()+" został zabity");
                }
            }
            System.out.println("End "+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {



        ThreadGroup threadGroup=new ThreadGroup("threads");
        List<Thread> list=new ArrayList<>();

        for (int i=0;i<5;i++)
        {
            list.add(new Thread(threadGroup,new ThreadClass()));

        }
        for(Thread thread:list)
        {
            thread.start();
        }
        threadGroup.interrupt();
    }
}