public class Main {
    public static void main(String[] args) {
        for (int i=0;i<5;i++)
        {
            ThreadClass tc1=new ThreadClass();
            tc1.start();
        }
        for (int i=0;i<5;i++)
        {
            Thread thread1=new Thread(new RunClass());
            thread1.start();
        }



    }
}