import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        Queue<Integer> q3=new LinkedList<>();
        Queue<Integer> output=new LinkedList<>();
        BlockingQueue<List<Integer>> queue=new LinkedBlockingQueue<>();
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        ThreadGroup group=new ThreadGroup("group");
        Thread t1= new Thread(group,new GenerateClass(q1));
        Thread t2= new Thread(group,new GenerateClass(q2));
        Thread t3= new Thread(group,new GenerateClass(q3));
        Thread t4= new Thread(group,new LinkClass(q1,q2,q3,output));
        Thread t5= new Thread(group,new SortClass(output,n,queue));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        List<Integer> list=queue.take();
        group.interrupt();
        Collections.sort(list);
        for (Integer i:list)
            System.out.print(i+", ");





    }
}