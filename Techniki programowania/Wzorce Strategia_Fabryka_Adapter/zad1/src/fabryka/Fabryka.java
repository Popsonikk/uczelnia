package fabryka;

import strategia.PodatekLiniowy;
import strategia.PodatekProgresywny;

public interface Fabryka {

    PodatekLiniowy stwórzPodatekLiniowy();

    PodatekProgresywny stwórzPodatekProgresywny();




}
