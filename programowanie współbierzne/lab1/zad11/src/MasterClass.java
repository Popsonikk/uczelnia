import java.util.Random;

public class MasterClass extends Thread{



    MasterClass()
    {

    }



    @Override
    public void run()
    {
        SlaveClass np=new SlaveClass(true,this);
        SlaveClass p=new SlaveClass(false,this);


        np.start();
        p.start();

        while(true)
        {
            int parzysta=p.getLicznik();
            int nieParzysta=np.getLicznik();
            if(parzysta>nieParzysta)
            {
                System.out.println("Większa liczba to "+parzysta);
            }
            else
                System.out.println("Większa liczba to "+nieParzysta);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
