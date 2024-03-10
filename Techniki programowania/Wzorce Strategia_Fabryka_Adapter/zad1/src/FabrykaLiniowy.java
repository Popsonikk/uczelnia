public class FabrykaLiniowy implements Fabryka{
    @Override
    public PodatekLiniowy stwórzPodatek() {
        return new PodatekLiniowy();
    }


}
