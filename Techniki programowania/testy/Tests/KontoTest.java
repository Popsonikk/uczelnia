import org.junit.Assert;
import org.junit.Test;

public class KontoTest {

    @Test
    public void zwykłyNieprzekroczony()
    {
        Konto konto=new Konto(false,50,10,10);
        konto.zapłac(20);
        Assert.assertEquals(30,konto.getStan());

    }
    @Test
    public void zwykłyPrzekroczony()
    {
        Konto konto=new Konto(false,-15,10,10);
        konto.zapłac(20);
        Assert.assertEquals(-15,konto.getStan());

    }
    @Test
    public void VipDodatni(){
        Konto konto=new Konto(true,200,100,2000);
        konto.zapłacVip(100);
        Assert.assertEquals(2000,konto.getPrzekroczenie());
    }
    @Test
    public void VipUjemny(){
        Konto konto=new Konto(true,200,100,2000);
        konto.zapłacVip(300);
        Assert.assertEquals(1000,konto.getPrzekroczenie());
    }
}
