public class PodatekProgresywny implements Podatek{

    float podatekM;
    float podatekW;
    float próg;

    PodatekProgresywny(float procentM, float procentW,float próg)
    {
        this.podatekM=procentM;
        this.podatekW=procentW;
        this.próg=próg;
    }
    @Override
    public float oblicz(float sum) {
        if(sum<=próg)
            return  (sum*podatekM);
        else
            return  (sum*podatekW);
    }
}
