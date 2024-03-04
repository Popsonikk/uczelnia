public class Adapter {

    private Serwis serwis;

    Adapter(Serwis serwis)
    {
        this.serwis=serwis;
    }
    float getData(float wal,float kurs)
    {
        return  serwis.zmienWalute(wal,kurs);
    }
}
