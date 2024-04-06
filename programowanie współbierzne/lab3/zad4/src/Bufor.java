import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Bufor {
    private volatile Queue<Integer> queue;
    private Semaphore konsument;
    private Semaphore producent;

    Bufor()
    {
        this.konsument=new Semaphore(0);
        this.producent=new Semaphore(10);
        this.queue=new LinkedList<>();
    }
    public synchronized void setValue(int a)
    {

        queue.add(a);
    }
    public synchronized  int getValue()
    {
        int n= queue.element();
        queue.remove();
        return n;
    }

    public synchronized Semaphore getKonsument() {
        return konsument;
    }

    public synchronized Semaphore getProducent() {
        return producent;
    }
}
