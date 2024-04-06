public class Main {
    public static void main(String[] args) {
        Bufor bufor=new Bufor();
        new Producent(bufor).start();
        new Konsument(bufor).start();

    }
}