import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class SortClass extends Thread{
    private Queue<Integer> queue;
    private int n;
    private List<Integer> list;
    private BlockingQueue<List<Integer>> main;

    public SortClass(Queue<Integer> queue, int n,BlockingQueue<List<Integer>> q) {
        this.queue = queue;
        this.n = n;
        this.list=new ArrayList<>();
        this.main=q;
    }
    @Override
    public void run()
    {
        while (true)
        {
            while(queue.isEmpty())
            {
                try {
                    synchronized (queue)
                    {
                        queue.wait();
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            list.add(queue.poll());
            if (list.size()==n)
            {

                break;

            }
        }
        try {
            main.put(list);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
