import java.util.concurrent.Semaphore;

public class Biblioteka {
    Semaphore [] czytelnia1;
    Semaphore [] czytelnia2;
    Semaphore [] pozycje;

    Biblioteka(int c1,int c2,int p)
    {
        czytelnia1=new Semaphore[c1];
        czytelnia2=new Semaphore[c2];
        pozycje=new Semaphore[p];
        for(int i=0;i<c1;i++)
            czytelnia1[i]=new Semaphore(1);
        for(int i=0;i<c2;i++)
            czytelnia2[i]=new Semaphore(1);
        for(int i=0;i<p;i++)
            pozycje[i]=new Semaphore(1);

    }



}
