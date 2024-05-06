import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private List<Observer> miłosnicy;
    Publisher()
    {
        miłosnicy=new ArrayList<>();
    }
    public void dodaj(Observer o)
    {
        miłosnicy.add(o);
    }
    public void powiadom(FaunaEvent e)
    {
        for(Observer o:miłosnicy)
        {
            if(o.getAlertSettings(e.getAnimalNumber()))
                o.powiadom(e);
        }

    }
    public void powiadomAll(FaunaEvent e)
    {
        for(Observer o:miłosnicy)
            o.powiadom(e);
    }

}
