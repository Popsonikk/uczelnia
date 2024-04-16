public class Magazyn {
    private int size;
    private volatile int aCount;
    private volatile int bCount;
    private  volatile int cCount;

    public Magazyn(int size) {
        this.size = size;
    }
    public synchronized void setA() throws InterruptedException {
        while((cCount+aCount+bCount)>=size||aCount*3+1>=size)
            wait();
        aCount++;
        System.out.println("Włożono A z wątku: "+Thread.currentThread().threadId()+" liczba A: "+aCount);
        notifyAll();
    }
    public synchronized void setB() throws InterruptedException {
        while((cCount+aCount+bCount)>=size||bCount*3+1>=size)
            wait();
        bCount++;
        System.out.println("Włożono B z wątku: "+Thread.currentThread().threadId()+" liczba B: "+bCount);
        notifyAll();
    }
    public synchronized void setC() throws InterruptedException {
        while((cCount+aCount+bCount)>=size||cCount*3+1>=size)
            wait();
        cCount++;
        System.out.println("Włożono c z wątku: "+Thread.currentThread().threadId()+" liczba c: "+cCount);
        notifyAll();
    }
    public synchronized void create() throws InterruptedException {
        while(aCount==0||bCount==0||cCount==0)
            wait();
        aCount--;
        bCount--;
        cCount--;
        System.out.println("stworzono przedmiot a: "+aCount+" b: "+bCount+" c: "+cCount);
    }

}
