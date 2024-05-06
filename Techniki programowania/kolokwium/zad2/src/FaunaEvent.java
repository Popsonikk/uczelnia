public class FaunaEvent {
    private String s;
    private int animalNumber;

    public FaunaEvent(String s,int i) {
        this.s = s;
        this.animalNumber=i;
    }

    public int getAnimalNumber() {
        return animalNumber;
    }

    public String getS() {
        return s;
    }
}
