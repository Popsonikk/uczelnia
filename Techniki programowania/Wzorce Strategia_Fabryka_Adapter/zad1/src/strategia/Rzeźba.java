package strategia;

public class Rzeźba implements Przedmiot {

    private int rok;
    private int rozmiar;
    public Rzeźba(int rk, int rm)
    {
        this.rok=rk;
        this.rozmiar=rm;
    }
    @Override
    public float okreslWartosc() {
        return (2020-rok)*rozmiar*2;
    }
}
