public class CreatorA extends Thread{
    private Magazyn magazyn;

    public CreatorA(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try {
                Thread.sleep((long) (Math.random()*2000+1000));
                magazyn.setA();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
