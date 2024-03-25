public class Produkt {

    private StringBuilder napis;



    public void setNapis(String s) {
        this.napis.append(s);
    }

    public String getNapis() {
        return napis.toString();
    }


}
