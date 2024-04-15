import java.util.ArrayList;
import java.util.List;

public class Producer {
    private List<Obserwator>list;

    public Producer() {
        list=new ArrayList<>();
    }
    public void subscribe(Obserwator obserwator)
    {
        list.add(obserwator);
    }
    public void unsubscribe(Obserwator obserwator)
    {
        list.remove(obserwator);
    }
    public void notified(WeatherInfo wi)
    {
        for(Obserwator o:list)
            o.notified(wi);
    }

}
