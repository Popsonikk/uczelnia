import java.util.ArrayList;
import java.util.List;

public class Kontener implements Komponent{

    private List<Firma> list;
    Kontener()
    {
        this.list=new ArrayList<>();
    }

    @Override
    public void premia() {
        for(Firma f:list)
            f.premia();
    }
}
