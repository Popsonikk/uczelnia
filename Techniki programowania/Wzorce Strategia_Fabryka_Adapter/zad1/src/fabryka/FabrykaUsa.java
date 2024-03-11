package fabryka;

import strategia.PodatekLiniowy;
import strategia.PodatekProgresywny;

public class FabrykaUsa implements Fabryka {


    @Override
    public PodatekLiniowy stwórzPodatekLiniowy() {
        return new PodatekLiniowy(0.1f);
    }

    @Override
    public PodatekProgresywny stwórzPodatekProgresywny() {
        return new PodatekProgresywny(0.1f,0.1f,10000);
    }
}
