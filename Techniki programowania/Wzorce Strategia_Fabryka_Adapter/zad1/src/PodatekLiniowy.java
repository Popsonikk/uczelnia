public class PodatekLiniowy implements Podatek{

    float procent;
    PodatekLiniowy()
    {

    }

    public void setProcent(float procent) {
        this.procent = procent;
    }

    @Override
    public float oblicz(float sum) {
        return sum*procent;
    }
}
