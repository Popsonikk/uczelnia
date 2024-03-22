import java.util.concurrent.atomic.AtomicIntegerArray;

public class ThreadClass extends Thread{
    static AtomicIntegerArray wybor= new AtomicIntegerArray(8);
    static AtomicIntegerArray numer= new AtomicIntegerArray(8);
    static {
        for(int i=0;i<8;i++)
        {
            wybor.set(i,0);
            numer.set(i,0);
        }
    }
    private final int id;

    public ThreadClass(int id) {
        this.id = id;
    }
    private int maxvalue()
    {
        int max=0;
        for(int i=0;i<8;i++)
        {
            int a=numer.get(i);
            if(a>max)
                max=a;
        }
        return max;
    }
    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                Thread.sleep((long) (2000*Math.random()));
                wybor.set(id,1);
                numer.set(id,1+maxvalue());
                wybor.set(id,0);
                for(int j=0;j<8;j++)
                {
                    if(j!=id)
                    {
                        while(wybor.get(j)!=0)
                            Thread.yield();
                        while(numer.get(j)!=0&&numer.get(id)>numer.get(j)&&!(numer.get(id)==numer.get(j)&&id<j))
                        {
                            Thread.yield();
                        }

                    }
                }
                System.out.println(id+" in");
                Thread.sleep((long) (1000*Math.random()));
                System.out.println(id+" out");
                numer.set(id,0);
            }

        }
        catch (InterruptedException e)
        {
            System.out.println("Wątek zakończony");
        }
    }

}
