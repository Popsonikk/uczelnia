import java.util.Random;

public class Producent extends Thread{
    private Bufor bufor;

    public Producent(Bufor bufor) {
        this.bufor = bufor;
    }
    private int generate()
    {
        Random random=new Random();
        int sum=0;
        for(int i=0;i<20;i++)
            sum+=random.nextInt(100);
        return sum/20;
    }
    @Override
    public void run()
    {
        while(true)
        {

            while (bufor.getProducent().availablePermits()==0)
            {
                Thread.yield();
            }

            int x=generate();
            bufor.setValue(x);
            System.out.println("Wstawiłem liczbę: "+x);
            bufor.getProducent().acquireUninterruptibly();
            bufor.getKonsument().release();

            try {
                Thread.sleep((long) (Math.random()*2000+1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
