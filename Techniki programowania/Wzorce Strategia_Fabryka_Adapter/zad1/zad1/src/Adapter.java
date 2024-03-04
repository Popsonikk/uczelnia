public class Adapter {

    private Serwis serwis;

    public void setSerwis(Serwis serwis) {
        this.serwis = serwis;
    }
    float getData(float wal)
    {
        return  serwis.zmienWalute(wal);
    }
}
