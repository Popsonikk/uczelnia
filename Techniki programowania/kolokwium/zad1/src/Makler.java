public class Makler {

    private float kwota;
    private float max;
    private Firma firma;

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public Makler(float kwota, float max) {
        this.kwota = kwota;
        this.max = max;
    }

    public int kup()
    {
        if (kwota>max)
        {
            System.out.println("Kupienie akcji zakończone niepowodzeniem");
            return 2;
        }
        if(kwota> firma.getAkcja())
        {
            System.out.println("Akcja kupiona za "+firma.getAkcja());

            return 1;
        }
        else
        {
            kwota+=0.05f;
            System.out.println("Akcja nie kupiona za "+ kwota+", zwiększam o 5 gr");
        }
        return 0;
    }
}
