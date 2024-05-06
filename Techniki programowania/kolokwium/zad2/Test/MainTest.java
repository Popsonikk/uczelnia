import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class MainTest {
    @BeforeClass
    public static void create()
    {

    }

    @Test
    public void alertTest()
    {

        Publisher publisher=new Publisher();
        Observer observer1=new Observer(List.of(false,false),1);
        Observer observer2=new Observer(List.of(true,true),2);
        publisher.dodaj(observer1);
        publisher.dodaj(observer2);
        observer1.Zagrorzenie();

    }
    @Test
    public void drozdTest()
    {

        Publisher publisher=new Publisher();
        Observer observer1=new Observer(List.of(false,false),1);
        Observer observer2=new Observer(List.of(true,true),2);
        publisher.dodaj(observer1);
        publisher.dodaj(observer2);
        observer1.PowiadomDrozd();

    }
}
