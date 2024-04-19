import java.util.Random;

public class Czytelnik extends Thread{
    private Biblioteka biblioteka;
    int number;

    public Czytelnik(Biblioteka biblioteka,int n) {
        this.biblioteka = biblioteka;
        this.number=n;
    }

    @Override
    public void run()
    {
        int size= biblioteka.pozycje.length;
        Random random=new Random();
        while(true)
        {
            try {
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int pozycja=random.nextInt(size);
            while (biblioteka.pozycje[pozycja].availablePermits()==0)
                Thread.yield();
            biblioteka.pozycje[pozycja].acquireUninterruptibly();
            System.out.println("czytelnik "+number+" wybrał książke "+pozycja);
            int poczekalnia=random.nextInt(100);
            if(poczekalnia%2==1)
            {
                for(int i=0;;i++)
                {
                    if(biblioteka.czytelnia1[i].availablePermits()>0)
                    {
                        biblioteka.czytelnia1[i].acquireUninterruptibly();
                        System.out.println("czytelnik "+number+" czyta książke w czytelni 1."+i);
                        try {
                            Thread.sleep((long) (Math.random()*3000+2000));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        biblioteka.czytelnia1[i].release();
                        break;
                    }
                    if(i+1==biblioteka.czytelnia1.length )
                        i=-1;


                }
            }
            else
            {
                for(int i=0; ;i++)
                {
                    if(biblioteka.czytelnia2[i].availablePermits()>0)
                    {
                        biblioteka.czytelnia2[i].acquireUninterruptibly();
                        System.out.println("czytelnik "+number+" czyta książke w czytelni 2."+i);
                        try {
                            Thread.sleep((long) (Math.random()*3000+2000));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        biblioteka.czytelnia2[i].release();
                        break;

                    }
                    if(i+1==biblioteka.czytelnia2.length )
                        i=-1;
                }
            }
            biblioteka.pozycje[pozycja].release();
            System.out.println("czytelnik "+number+" skonczył czytać");
        }
    }
}
