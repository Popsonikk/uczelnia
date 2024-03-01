public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1=new Thread(() -> {

            for (int i=1;i<34;i++)
            {
                System.out.println("wątek 1:"+i);
                Thread.yield();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        });
        Thread thread2=new Thread(()->{
            /*try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            for (int i=50;i<89;i++)
            {
                System.out.println("wątek 2:"+i);
                Thread.yield();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        Thread thread3=new Thread(()->{
          /*  try {
                thread2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            for (int i=100;i<133;i++)
            {
                System.out.println("wątek 3:"+i);
                Thread.yield();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        });
        thread1.start();
        thread2.start();
        thread3.start();



    }
}