public class Triaged extends Stan{


    @Override
    void publish() {
        subscriber.publish(this);
    }
    @Override
    public void check(Wymaganie wymaganie) {
        System.out.println("Zakończono proces wymagania");
    }

    @Override
    public String getStatus(int i) {
        return "Wymaganie "+ i+" jest na etapie Triaged";
    }
}
