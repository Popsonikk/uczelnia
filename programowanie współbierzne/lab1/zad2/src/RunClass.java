public class RunClass implements Runnable{
    private long number;

    RunClass()
    {

    }
    @Override
    public void run() {
        Thread t =Thread.currentThread();
        number= t.threadId();
        System.out.println("Hello word from runnable "+number);
    }
}
