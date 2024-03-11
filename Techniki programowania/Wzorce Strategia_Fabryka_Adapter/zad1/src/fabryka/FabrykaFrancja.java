package fabryka;

import strategia.PodatekLiniowy;
import strategia.PodatekProgresywny;

public class FabrykaFrancja implements Fabryka {
    @Override
    public PodatekLiniowy stwórzPodatekLiniowy() {
        return new PodatekLiniowy(0.3f);
    }

    @Override
    public PodatekProgresywny stwórzPodatekProgresywny() {
        return new PodatekProgresywny(0.3f,0.5f,40000);
    }
}
