public class Generator extends Thread{
    private Magazyn magazyn;

    public Generator(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try {
                Thread.sleep((long) (Math.random()*2000+1000));
                magazyn.create();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
