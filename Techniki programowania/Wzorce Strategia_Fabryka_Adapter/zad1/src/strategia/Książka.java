package strategia;

import strategia.Przedmiot;

public class Książka implements Przedmiot {

    private int wydanie;
    private int rok;
    public Książka(int w, int r)
    {
        this.wydanie=w;
        this.rok=r;
    }
    @Override
    public float okreslWartosc() {
        return (2050-rok)/wydanie;
    }
}
