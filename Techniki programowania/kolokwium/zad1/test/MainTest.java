import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {


    @Test
    public void Makler1Test()
    {
        Firma firma=new Firma(5);
        Makler makler=new Makler(4.5f,4.8f);
        makler.setFirma(firma);
        int i=0;
        while(true)
        {
            i= makler.kup();
            if(i==1||i==2)
                break;

        }
        Assert.assertEquals(2,i);
    }
    @Test
    public void Makler2Test()
    {
        Firma firma=new Firma(30);
        Makler makler=new Makler(29f,31f);
        makler.setFirma(firma);
        int i=0;
        while(true)
        {
            i= makler.kup();
            if(i==1||i==2)
                break;

        }
        Assert.assertEquals(1,i);
    }
}
