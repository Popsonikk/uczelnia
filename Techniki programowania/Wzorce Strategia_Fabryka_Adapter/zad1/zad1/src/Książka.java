public class Książka implements Przedmiot{

    private int wydanie;
    private int rok;
    Książka (int w,int r)
    {
        this.wydanie=w;
        this.rok=r;
    }
    @Override
    public float okreslWartosc() {
        return (2050-rok)/wydanie;
    }
}
