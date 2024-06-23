public abstract class Stan {
    protected Subscriber subscriber;

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    abstract void publish();

    abstract  void check(Wymaganie wymaganie);

   abstract String getStatus(int i);
}
