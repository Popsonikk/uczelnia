import java.util.ArrayList;
import java.util.List;

public class Giełda {

    private List<Makler> maklerList;
    Giełda()
    {
        maklerList=new ArrayList<>();
    }
    public void addMakler(Makler makler)
    {
        maklerList.add(makler);
    }
    public void kupuj()
    {
        while (!maklerList.isEmpty())
        {
            for(int i=0;i<maklerList.size();i++)
            {
                int j=maklerList.get(i).kup();
                if(j==1||j==2)
                {
                    maklerList.remove(i);
                    i--;
                }
            }

        }

    }
}
