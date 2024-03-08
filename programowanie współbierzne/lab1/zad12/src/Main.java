import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int w= scanner.nextInt();
        ExecutorService service= Executors.newFixedThreadPool(w);
        AtomicReference<Double> sum= new AtomicReference<>( 0.0);
        service.submit(()->{
            for(int i=1;i<=n;i++) {
                int finalI = i;
                sum.updateAndGet(v -> (v + (1.0 / finalI)));
            }
            System.out.println("Suma: "+sum.get());


        });
        service.shutdown();


    }
}