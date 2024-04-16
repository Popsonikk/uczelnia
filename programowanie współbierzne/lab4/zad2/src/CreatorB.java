public class CreatorB extends Thread{
    private Magazyn magazyn;

    public CreatorB(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try {
                Thread.sleep((long) (Math.random()*2000+1000));
                magazyn.setB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
