public class FabrykaProgresywny implements Fabryka{
    @Override
    public PodatekProgresywny stwórzPodatek() {
        return new PodatekProgresywny();
    }
}
