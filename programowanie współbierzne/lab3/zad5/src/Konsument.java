public class Konsument extends Thread{
    private Bufor [] bufors;


    public Konsument(Bufor bufor1,Bufor bufor2,Bufor bufor3) {
        bufors=new Bufor[3];
        bufors[0]=bufor1;
        bufors[1]=bufor2;
        bufors[2]=bufor3;

    }

    private void doMath(Bufor bufor)
    {
        int x=bufor.getValue();
        System.out.println("Wartość: "+x);
    }

    @Override
    public void run()
    {
        while (true)
        {
            for(Bufor bufor:bufors)
            {
                if (bufor.getKonsument().availablePermits()!=0)
                {
                    doMath(bufor);
                    bufor.getKonsument().acquireUninterruptibly();
                    bufor.getProducent().release();
                    try {
                        Thread.sleep((long) (Math.random()*2000+1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }



        }
    }
}