import java.util.List;

public class Observer {

    private List<Boolean> alertSettings;
    //0-drozd, 1-królik,2-wiewiórka
    private int id;



    public Observer(List<Boolean> alertSettings,int n) {
        this.alertSettings = alertSettings;
        this.id=n;

    }
    public boolean getAlertSettings(int i) {
        return alertSettings.get(i);
    }

    public boolean powiadom(FaunaEvent e)
    {
        StringBuilder builder=new StringBuilder();

        System.out.println( builder.append(e.getS()).append(" dla miłosnika ").append(id).toString());
        return true;
    }

    public void PowiadomDrozd()
    {
        Main.publisher.powiadom(new FaunaEvent("Znalazłem drozda ",0));
    }
    public void PowiadomKrólik()
    {
        Main.publisher.powiadom(new FaunaEvent("Znalazłem królika ",1));
    }
    public void PowiadomWiewiórka()
    {
        Main.publisher.powiadom(new FaunaEvent("Znalazłem wiewiórka ",2));
    }
    public void Zagrorzenie()
    {
        Main.publisher.powiadomAll(new FaunaEvent("Znalazłem zagrożenie w lesie",-1));
    }
}
