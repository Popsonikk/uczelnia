import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class SortClass extends Thread{
    private BlockingQueue<Integer> queue;
    private int n;
    private List<Integer> list;
    private ThreadGroup threadGroup;

    public SortClass(BlockingQueue<Integer> queue, int n,ThreadGroup threadGroup) {
        this.queue = queue;
        this.n = n;
        this.list=new ArrayList<>();
        this.threadGroup=threadGroup;
    }
    @Override
    public void run()
    {
        while (true)
        {
            try {
                list.add(queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (list.size()==n)
            {
                Collections.sort(list);
                for (Integer i:list)
                    System.out.print(i+", ");
                break;

            }
        }
        threadGroup.interrupt();
    }
}
