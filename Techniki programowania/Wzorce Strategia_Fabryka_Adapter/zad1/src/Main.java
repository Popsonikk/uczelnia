
public class Main {
    public static void main(String[] args) {
        Fabryka fabrykaLiniowy=new FabrykaLiniowy();
        Fabryka fabrykaPRogresywny=new FabrykaProgresywny();
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

        PodatekLiniowy liniowy= (PodatekLiniowy) fabrykaLiniowy.stwórzPodatek();
        PodatekProgresywny progresywny= (PodatekProgresywny) fabrykaPRogresywny.stwórzPodatek();

        System.out.println("Wartość magazynu bez podatku: "+magazyn.wartośćMagazynu());

        liniowy.setProcent(0.10F);
        progresywny.setPróg(10000);
        progresywny.setPodatekM(0.10F);
        progresywny.setPodatekW(0.10F);
        magazyn.setPodatek(liniowy);
        System.out.println("Wartość magazynu z podatkiem liniowym usa: "+magazyn.pobierzWartośćPoOpodatkowaniu());
        magazyn.setPodatek(progresywny);
        System.out.println("Wartość magazynu z podatkiem progresywnym usa: "+magazyn.pobierzWartośćPoOpodatkowaniu());

        liniowy.setProcent(0.19F);
        progresywny.setPróg(10000);
        progresywny.setPodatekM(0.18F);
        progresywny.setPodatekW(0.32F);
        magazyn.setPodatek(liniowy);
        System.out.println("Wartość magazynu z podatkiem liniowym polska: "+magazyn.pobierzWartośćPoOpodatkowaniu());
        magazyn.setPodatek(progresywny);
        System.out.println("Wartość magazynu z podatkiem progresywnym polska: "+magazyn.pobierzWartośćPoOpodatkowaniu());

        liniowy.setProcent(0.30F);
        progresywny.setPróg(40000);
        progresywny.setPodatekM(0.3F);
        progresywny.setPodatekW(0.5F);
        magazyn.setPodatek(liniowy);
        System.out.println("Wartość magazynu z podatkiem liniowym francja: "+magazyn.pobierzWartośćPoOpodatkowaniu());
        magazyn.setPodatek(progresywny);
        System.out.println("Wartość magazynu z podatkiem progresywnym francja: "+magazyn.pobierzWartośćPoOpodatkowaniu());

        liniowy.setProcent(0.20F);
        progresywny.setPróg(50000);
        progresywny.setPodatekM(0.2F);
        progresywny.setPodatekW(0.4F);
        magazyn.setPodatek(liniowy);
        System.out.println("Wartość magazynu z podatkiem liniowym niemcy: "+magazyn.pobierzWartośćPoOpodatkowaniu());
        magazyn.setPodatek(progresywny);
        System.out.println("Wartość magazynu z podatkiem progresywnym niemcy: "+magazyn.pobierzWartośćPoOpodatkowaniu());

        float pN=magazyn.pobierzWartośćPoOpodatkowaniu();


        System.out.println("Podatek progresywny niemcy w polsce: "+ adapter.getData(pN,4.2F));
        System.out.println("Podatek progresywny niemcy w usa: "+ adapter.getData(pN,3.8F/3.F));
    }
}