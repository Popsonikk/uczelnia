import java.util.Random;

public class SlaveClass extends Thread {
    private boolean tryb;
    private int licznik;

    private MasterClass mc;
    private boolean status;

    public SlaveClass(boolean tryb,MasterClass masterClass) {
        this.tryb = tryb;
        this.licznik=0;
        this.mc=masterClass;
        this.status=true;
    }

    public int getLicznik() {
        return licznik;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void run()
    {
        if(tryb)
            licznik=1;
        else
            licznik=2;
        while (true)
        {

            System.out.println("Wysłałem liczbę "+licznik);
            licznik+=2;
            try {
                Thread.sleep((long) (1000*new Random().nextDouble()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }


    }
}
