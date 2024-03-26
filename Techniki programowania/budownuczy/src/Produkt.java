public class Produkt {

    private StringBuilder napis=new StringBuilder();



    public void setNapis(String s) {
        this.napis.append(s);
    }

    public String getNapis() {
        return napis.toString();
    }


}
