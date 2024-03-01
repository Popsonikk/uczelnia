public class ThreadClass extends Thread{
    private long number;
    ThreadClass(){

    }
    @Override
    public void run()
    {
        Thread t=Thread.currentThread();
        number= t.threadId();
        System.out.println("Hello Word from thread "+number);

    }
}
