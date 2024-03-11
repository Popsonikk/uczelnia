package strategia;

import strategia.Podatek;

public class PodatekProgresywny implements Podatek {

    float podatekM;
    float podatekW;
    float próg;

    public PodatekProgresywny(float podatekM, float podatekW, float próg) {
        this.podatekM = podatekM;
        this.podatekW = podatekW;
        this.próg = próg;
    }

    @Override
    public float oblicz(float sum) {
        if(sum<=próg)
            return  (sum*podatekM);
        else
            return  (sum*podatekW);
    }
}
