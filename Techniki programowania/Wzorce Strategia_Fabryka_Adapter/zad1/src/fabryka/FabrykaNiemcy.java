package fabryka;

import strategia.PodatekLiniowy;
import strategia.PodatekProgresywny;

public class FabrykaNiemcy implements Fabryka {
    @Override
    public PodatekLiniowy stwórzPodatekLiniowy() {
        return new PodatekLiniowy(0.2f);
    }

    @Override
    public PodatekProgresywny stwórzPodatekProgresywny() {
        return new PodatekProgresywny(0.3f,0.4f,50000);
    }
}
