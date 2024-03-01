import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Thread thread1=new Thread(()->{
            while(true)
            {
                int sum=0;
                for (int i=0;i<100;i++)
                {
                    Random random=new Random();
                    sum+= random.nextInt(100);
                }
                System.out.println(Thread.currentThread().getName()+": "+sum/100);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Thread.yield();
            }

        });

        Thread thread2=new Thread(()->{
            while(true)
            {
                double sum=1;
                for (int i=0;i<30;i++)
                {
                    Random random=new Random();
                    sum+= random.nextInt(30);
                }
                System.out.println(Thread.currentThread().getName()+": "+Math.pow(sum,1.0/30.0));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Thread.yield();
            }

        });

        Thread thread3=new Thread(()->{
            while(true)
            {
                Random random=new Random();
                double i = random.nextDouble() * 40 - 20;

                System.out.println(Thread.currentThread().getName()+": "+Math.log(i*i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Thread.yield();
            }

        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}