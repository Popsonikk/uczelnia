public class Approved extends Stan{


    @Override
    void publish() {
        subscriber.publish(this);
    }
    @Override
    public void check(Wymaganie wymaganie) {
        wymaganie.setStan(new Triaged());
    }

    @Override
    public String getStatus(int i) {
        return "Wymaganie "+i+" jest na etapie Approved";
    }
}
