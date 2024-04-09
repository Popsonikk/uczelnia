public class Konto {
    private boolean czyVip;
    private int stan;
    private int debet;
    private int przekroczenie;

    public Konto(boolean czyVip, int stan, int debet, int przekroczenie) {
        this.czyVip = czyVip;
        this.stan = stan;
        this.debet = debet;
        this.przekroczenie = przekroczenie;
    }

    public int getStan() {
        return stan;
    }

    public void setStan(int stan) {
        this.stan = stan;
    }

    public int getDebet() {
        return debet;
    }

    public void setDebet(int debet) {
        this.debet = debet;
    }

    public int getPrzekroczenie() {
        return przekroczenie;
    }

    public void setPrzekroczenie(int przekroczenie) {
        this.przekroczenie = przekroczenie;
    }
    public void zapłac(int cena)
    {
        if(!(stan<0&&Math.abs(stan)>debet))
            stan-=cena;
    }
    public void zapłacVip(int cena)
    {
        if(stan-cena<0)
        {
            przekroczenie=1000;

        }
        else
            przekroczenie=2000;
        stan-=cena;
    }

}
