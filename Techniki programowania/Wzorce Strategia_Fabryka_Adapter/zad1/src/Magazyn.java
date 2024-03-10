import java.util.ArrayList;
import java.util.List;

public class Magazyn {
    private Podatek podatek;
    private final List<Przedmiot> list;
    Magazyn()
    {
        this.list=new ArrayList<>();
    }
    public void setPodatek(Podatek p)
    {
        this.podatek=p;
    }
    public void dodajDoSpisu(Przedmiot p)
    {
        list.add(p);
    }
    public float wartośćMagazynu()
    {
        float sum=0;
        for(Przedmiot p:list)
        {
            sum+=p.okreslWartosc();
        }
        return sum;
    }
    public float pobierzWartośćPoOpodatkowaniu()
    {
        float sum=0;

        for(Przedmiot p:list)
        {
            float w= p.okreslWartosc();
            sum+=(w-podatek.oblicz(w));
        }
        return sum;
    }
}
