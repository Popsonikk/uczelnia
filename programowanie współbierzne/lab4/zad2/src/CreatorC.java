public class CreatorC extends Thread{
    private Magazyn magazyn;

    public CreatorC(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try {
                Thread.sleep((long) (Math.random()*2000+1000));
                magazyn.setC();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
