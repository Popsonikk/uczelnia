public class Main {
    public static void main(String[] args) {

        Magazyn magazyn=new Magazyn(20);
        new CreatorA(magazyn).start();
        new CreatorA(magazyn).start();
        new CreatorA(magazyn).start();
        new CreatorA(magazyn).start();
        new CreatorB(magazyn).start();
        new CreatorB(magazyn).start();
        new CreatorC(magazyn).start();
        new CreatorC(magazyn).start();
        new CreatorC(magazyn).start();
        new Generator(magazyn).start();
        new Generator(magazyn).start();
    }
}