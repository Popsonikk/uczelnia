import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class MasterClass extends Thread{

    BlockingQueue<Integer> q1;
    BlockingQueue<Integer> q2;

    public MasterClass(BlockingQueue<Integer> q1, BlockingQueue<Integer> q2) {
        this.q1 = q1;
        this.q2 = q2;
    }

    @Override
    public void run()
    {
        SlaveClass np=new SlaveClass(true,q1);
        SlaveClass p=new SlaveClass(false,q2);


        np.start();
        p.start();

        while(true)
        {
            int parzysta,nieParzysta;
            try {
                parzysta = q2.take();
                nieParzysta=q1.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(parzysta>nieParzysta)
                System.out.println("Większa liczba to "+parzysta);
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
