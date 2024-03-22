public class ThreadClass extends Thread{
    static volatile boolean chce1=false;
    static volatile boolean chce2=false;
    static volatile int ktoCzeka=1;

    private int id;

    public ThreadClass(int id) {
        this.id = id;
    }
    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                Thread.sleep((long) (Math.random()*2000));
                if(id==1)
                {
                    chce1=true;
                    if(chce2)
                    {
                        if(ktoCzeka==1)
                        {
                            chce1=false;
                            while (ktoCzeka==1)
                                Thread.yield();
                            chce1=true;
                        }
                        while(chce2)
                            Thread.yield();
                    }
                }
                else {
                    chce2=true;
                    if(chce1)
                    {
                        if(ktoCzeka==2)
                        {
                            chce2=false;
                            while (ktoCzeka==2)
                                Thread.yield();
                            chce2=true;
                        }
                        while(chce1)
                            Thread.yield();
                    }
                }
                System.out.println(id+" in");
                Thread.sleep((long) (Math.random()*1000));
                System.out.println(id+" out");
                if(id==1)
                {
                    chce1=false;
                    ktoCzeka=1;
                }
                else
                {
                    chce2=false;
                    ktoCzeka=2;
                }
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Wątek zakończony");
        }
    }
}
