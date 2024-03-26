public class Firma implements Komponent{

    private String name;
    private String NIP;
    private int premia;

    public Firma(String name, String NIP, int premia) {
        this.name = name;
        this.NIP = NIP;
        this.premia = premia;
    }
    public void addPremia(int i)
    {
        premia+=i;
    }

    public String getNIP() {
        return NIP;
    }

    @Override
    public void premia() {
        System.out.println(premia);
    }
}
