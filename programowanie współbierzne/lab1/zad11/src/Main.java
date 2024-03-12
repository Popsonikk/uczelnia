import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {


        BlockingQueue<Integer> q1=new LinkedBlockingQueue<>();
        BlockingQueue<Integer> q2=new LinkedBlockingQueue<>();
        Thread master=new MasterClass(q1,q2);
        master.start();

    }
}