import fabryka.*;
import strategia.*;

public class Main {
    public static void main(String[] args) {
        Fabryka usa=new FabrykaUsa();
        Fabryka polska=new FabrykaPolska();
        Fabryka francja=new FabrykaFrancja();
        Fabryka niemcy=new FabrykaNiemcy();
        Magazyn magazyn=new Magazyn();
        Adapter adapter=new Adapter(new Serwis());
        magazyn.dodajDoSpisu(new Książka(2,1999));
        magazyn.dodajDoSpisu(new Książka(3,2006));
        magazyn.dodajDoSpisu(new Obraz(1800));
        magazyn.dodajDoSpisu(new Obraz(1900));
        magazyn.dodajDoSpisu(new Obraz(900));
        magazyn.dodajDoSpisu(new Rzeźba(1500,3));
        magazyn.dodajDoSpisu(new Rzeźba(900,5));
        magazyn.dodajDoSpisu(new Rzeźba(20,12));



        System.out.println("Wartość magazynu bez podatku: "+magazyn.wartośćMagazynu());

        magazyn.setPodatek(usa.stwórzPodatekLiniowy());
        System.out.println("Wartość magazynu z podatkiem liniowym usa: "+magazyn.pobierzWartośćPoOpodatkowaniu());
        magazyn.setPodatek(usa.stwórzPodatekProgresywny());
        System.out.println("Wartość magazynu z podatkiem progresywnym usa: "+magazyn.pobierzWartośćPoOpodatkowaniu());


        magazyn.setPodatek(polska.stwórzPodatekLiniowy());
        System.out.println("Wartość magazynu z podatkiem liniowym polska: "+magazyn.pobierzWartośćPoOpodatkowaniu());
        magazyn.setPodatek(polska.stwórzPodatekProgresywny());
        System.out.println("Wartość magazynu z podatkiem progresywnym polska: "+magazyn.pobierzWartośćPoOpodatkowaniu());


        magazyn.setPodatek(francja.stwórzPodatekLiniowy());
        System.out.println("Wartość magazynu z podatkiem liniowym francja: "+magazyn.pobierzWartośćPoOpodatkowaniu());
        magazyn.setPodatek(francja.stwórzPodatekProgresywny());
        System.out.println("Wartość magazynu z podatkiem progresywnym francja: "+magazyn.pobierzWartośćPoOpodatkowaniu());

        magazyn.setPodatek(niemcy.stwórzPodatekLiniowy());
        System.out.println("Wartość magazynu z podatkiem liniowym niemcy: "+magazyn.pobierzWartośćPoOpodatkowaniu());
        magazyn.setPodatek(niemcy.stwórzPodatekProgresywny());
        System.out.println("Wartość magazynu z podatkiem progresywnym niemcy: "+magazyn.pobierzWartośćPoOpodatkowaniu());

        float pN=magazyn.pobierzWartośćPoOpodatkowaniu();


        System.out.println("strategia.Podatek progresywny niemcy w polsce: "+ adapter.getData(pN,4.2F));
        System.out.println("strategia.Podatek progresywny niemcy w usa: "+ adapter.getData(pN,3.8F/3.F));
    }
}