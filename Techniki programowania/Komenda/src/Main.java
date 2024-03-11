import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Komenda> komendaList=new ArrayList<>();
        int h=0,m=0;
        komendaList.add(new SaveNumber("file.txt",3,39));
        komendaList.add(new SaveWord("file.txt",1,55));
        komendaList.add(new DoMath("file.txt",5,0));
        komendaList.add(new SaveNumber("file.txt",3,39));
        komendaList.add(new DoMath("file.txt",22,1));
        komendaList.add(new SaveWord("file.txt",15,44));
        while (h<24&&!komendaList.isEmpty())
        {
            for(int i=0;i<komendaList.size();i++)
            {
                Komenda k= komendaList.get(i);
                if(k.getHour()==h&&k.getMinute()==m)
                {
                    k.doSomething();
                    komendaList.remove(k);
                    i--;
                }

            }
            ++m;
            if(m==60)
            {
                h++;
                m=0;
            }
        }


    }
}