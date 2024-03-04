public class PodatekLiniowy implements Podatek{

    float procent;
    PodatekLiniowy(float procent)
    {
        this.procent=procent;
    }
    @Override
    public float oblicz(float sum) {
        return sum*procent;
    }
}
