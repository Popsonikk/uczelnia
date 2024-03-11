package strategia;

import strategia.Podatek;

public class PodatekLiniowy implements Podatek {

    float procent;
    public PodatekLiniowy(float procent) {
        this.procent = procent;

    }

    @Override
    public float oblicz(float sum) {
        return sum*procent;
    }
}
