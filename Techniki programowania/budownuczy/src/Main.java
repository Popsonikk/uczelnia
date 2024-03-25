import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int [] array=new int [n];
        for(int i=0;i<n;i++)
            array[i]=scanner.nextInt();
        Director director=new Director();
        WavBuider wavBuider=new WavBuider();
        OggBuilder oggBuilder=new OggBuilder();
        Mp3Builder mp3Builder=new Mp3Builder();
        Produkt produkt;
        director.setBuilder(wavBuider);
        produkt=director.wygenerujNapis(array);
        System.out.println(produkt.getNagłówek());
        System.out.println(produkt.getTagi());
        System.out.println(produkt.getBody());

        System.out.println();
        director.setBuilder(mp3Builder);
        produkt=director.wygenerujNapis(array);
        System.out.println(produkt.getNagłówek());
        System.out.println(produkt.getTagi());
        System.out.println(produkt.getBody());

        System.out.println();
        director.setBuilder(oggBuilder);
        produkt=director.wygenerujNapis(array);
        System.out.println(produkt.getNagłówek());
        System.out.println(produkt.getTagi());
        System.out.println(produkt.getBody());







    }
}