package fabryka;

import strategia.PodatekLiniowy;
import strategia.PodatekProgresywny;

public class FabrykaPolska implements Fabryka {

    @Override
    public PodatekLiniowy stwórzPodatekLiniowy() {
        return new PodatekLiniowy(0.19f);
    }

    @Override
    public PodatekProgresywny stwórzPodatekProgresywny() {
        return new PodatekProgresywny(0.18f,0.19f,10000);
    }
}
