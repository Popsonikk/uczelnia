public class PodatekProgresywny implements Podatek{

    float podatekM;
    float podatekW;
    float próg;

    PodatekProgresywny()
    {

    }

    public void setPodatekM(float podatekM) {
        this.podatekM = podatekM;
    }

    public void setPodatekW(float podatekW) {
        this.podatekW = podatekW;
    }

    public void setPróg(float próg) {
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
