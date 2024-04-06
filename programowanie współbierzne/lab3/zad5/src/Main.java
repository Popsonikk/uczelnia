public class Main {
    public static void main(String[] args) {
        Bufor bufor1=new Bufor();
        Bufor bufor2=new Bufor();
        Bufor bufor3=new Bufor();
        new Producent(bufor1).start();
        new Producent(bufor2).start();
        new Producent(bufor3).start();
        new Konsument(bufor1,bufor2,bufor3).start();

    }
}