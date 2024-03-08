import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<Integer> input=new LinkedBlockingQueue<>(3);
        BlockingQueue<Integer> output=new LinkedBlockingQueue<>(1);
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        ThreadGroup group=new ThreadGroup("group");
        Thread t1= new Thread(group,new GenerateClass(input));
        Thread t2= new Thread(group,new GenerateClass(input));
        Thread t3= new Thread(group,new GenerateClass(input));
        Thread t4= new Thread(group,new LinkClass(input,output));
        Thread t5= new Thread(group,new SortClass(output,n,group));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();



    }
}