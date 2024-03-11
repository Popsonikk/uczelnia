package strategia;

import strategia.Przedmiot;

public class Obraz implements Przedmiot {

    private final int rok;
    public Obraz(int r)
    {
        this.rok=r;
    }
    @Override
    public float okreslWartosc() {
        return (2100-rok)*10;
    }
}
