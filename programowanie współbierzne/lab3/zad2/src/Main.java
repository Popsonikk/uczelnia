import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        if(n>8)
        {
            System.out.println("podana liczba jest za duża");
            return;
        }
        Semaphore block=new Semaphore(1);
        Semaphore start=new Semaphore(-n+1);



        for(int i=1;i<=n;i++)
            new Thread(new ThreadClass(i,block,start)).start();

    }
}