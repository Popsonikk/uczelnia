public class FabrykaPodatek implements Fabryka{
    @Override
    public PodatekLiniowy stwórzPodatekliniowy(float procent) {
        return new PodatekLiniowy(procent);
    }

    @Override
    public PodatekProgresywny stwórzPodatekProgresywny(float procentM, float procentW,float próg) {
        return new PodatekProgresywny(procentM, procentW,próg);
    }
}
