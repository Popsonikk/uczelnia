public class Konsument extends Thread{
    private Bufor bufor;

    public Konsument(Bufor bufor) {
        this.bufor = bufor;
    }

    private void doMath()
    {
        int x=bufor.getValue();
        System.out.println("pierwiastek: "+ Math.sqrt(x));
        System.out.println("log2: "+ Math.log(x));
        System.out.println("kwadrat: "+ x*x);
        System.out.println();
    }

    @Override
    public void run()
    {
        while (true)
        {

            while (bufor.getKonsument().availablePermits()==0)
            {

                Thread.yield();
            }

            doMath();
            bufor.getKonsument().acquireUninterruptibly();
            bufor.getProducent().release();
        }
    }
}
