public class Main {
    public static void main(String[] args) {

        Zamówienie z1=new Zamówienie(true,true,true);
        Zamówienie z2=new Zamówienie(false,true,true);
        Chain c1=new Kolektor();
        Chain c2= new Dystrybutor();
        c1.setNext(c2);
        System.out.println(c1.handle(z1));
        System.out.println(c1.handle(z2));
        z2.setPart1(true);
        System.out.println(c1.handle(z1));
        System.out.println(c1.handle(z2));

    }
}