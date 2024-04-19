public class Main {
    public static void main(String[] args) {

        int p=10;
        Biblioteka biblioteka=new Biblioteka(3,5,p);
        for(int i=0;i<12;i++)
            new Czytelnik(biblioteka,i).start();

    }
}