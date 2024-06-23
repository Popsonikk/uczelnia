public class Main {
    public static void main(String[] args) {

        Subscriber subscriber=new Subscriber();
        Wymaganie w1=new Wymaganie();
        Wymaganie w2=new Wymaganie();
        subscriber.subscribe(w1);
        subscriber.subscribe(w2);
        Stan stan=new Relevant();
        stan.setSubscriber(subscriber);
        stan.publish();
        Wymaganie w3=new Wymaganie();
        subscriber.subscribe(w3);
        stan=new Approved();
        stan.setSubscriber(subscriber);
        stan.publish();
        Wymaganie w4=new Wymaganie();
        w4.setStan(new Approved());
        subscriber.subscribe(w4);
        stan=new Triaged();
        stan.setSubscriber(subscriber);
        stan.publish();
        System.out.println(w1.getStan().getStatus(1));
        System.out.println(w2.getStan().getStatus(2));
        System.out.println(w3.getStan().getStatus(3));
        System.out.println(w4.getStan().getStatus(4));

    }
}