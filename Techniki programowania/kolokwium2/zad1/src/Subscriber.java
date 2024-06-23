import java.util.ArrayList;
import java.util.List;

public class Subscriber {

    private List<Wymaganie> list;
    Subscriber()
    {
        this.list=new ArrayList<>();
    }

    public void subscribe(Wymaganie wymaganie)
    {
        list.add(wymaganie);
    }
    public void publish(Stan event)
    {
        for(Wymaganie w:list)
        {
            if(w.getStan().getClass()==event.getClass())
                w.getStan().check(w);
        }
    }
}
