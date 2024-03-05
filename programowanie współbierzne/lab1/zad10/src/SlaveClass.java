public class SlaveClass extends Thread{

    private int x1;
    private int x2;
    private MasterClass masterClass;
    public SlaveClass(int x1, int x2,MasterClass m) {
        this.x1 = x1;
        this.x2 = x2;
        this.masterClass=m;
    }
    private synchronized int gcdByBruteForce(int n1, int n2) {
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    @Override
    public void run()
    {
        int i=gcdByBruteForce(x1,x2);
        masterClass.setValue(i);
    }

}
