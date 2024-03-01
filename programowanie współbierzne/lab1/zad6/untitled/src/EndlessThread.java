public class EndlessThread implements Runnable{
    @Override
    public void run() {
        while(true)
        {
            System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().threadId());

        }
    }
}
