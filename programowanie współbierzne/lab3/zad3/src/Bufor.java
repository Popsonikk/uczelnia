import java.util.concurrent.Semaphore;

public class Bufor {
    private volatile int n;
    private Semaphore konsument;
    private Semaphore producent;

    Bufor()
    {
        this.konsument=new Semaphore(0);
        this.producent=new Semaphore(1);
    }
    public synchronized void setValue(int a)
    {

        this.n=a;
    }
    public synchronized  int getValue()
    {
        return n;
    }

    public synchronized Semaphore getKonsument() {
        return konsument;
    }

    public synchronized Semaphore getProducent() {
        return producent;
    }
}
