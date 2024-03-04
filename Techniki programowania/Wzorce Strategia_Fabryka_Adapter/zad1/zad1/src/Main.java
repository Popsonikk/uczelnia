
public class Main {
    public static void main(String[] args) {
        Fabryka fabryka=new FabrykaPodatek();
        Magazyn magazyn=new Magazyn();
        Adapter adapter=new Adapter();
        Serwis ep=new EURtoPLN();
        Serwis eu =new EURtoUSD();
        magazyn.dodajDoSpisu(new Książka(2,1999));
        magazyn.dodajDoSpisu(new Książka(3,2006));
        magazyn.dodajDoSpisu(new Obraz(1800));
        magazyn.dodajDoSpisu(new Obraz(1900));
        magazyn.dodajDoSpisu(new Rzeźba(1500,3));
        magazyn.dodajDoSpisu(new Rzeźba(900,5));

        PodatekLiniowy usaL=fabryka.stwórzPodatekliniowy(0.10F);
        PodatekProgresywny usaP=fabryka.stwórzPodatekProgresywny(0.10F,0.10F,10000);

        PodatekLiniowy polL=fabryka.stwórzPodatekliniowy(0.19F);
        PodatekProgresywny polP=fabryka.stwórzPodatekProgresywny(0.18F,0.32F,10000);

        PodatekLiniowy fraL=fabryka.stwórzPodatekliniowy(0.30F);
        PodatekProgresywny fraP=fabryka.stwórzPodatekProgresywny(0.3F,0.5F,40000);

        PodatekLiniowy gerL=fabryka.stwórzPodatekliniowy(0.2F);
        PodatekProgresywny gerP=fabryka.stwórzPodatekProgresywny(0.2F,0.4F,50000);

        System.out.println("Wartość magazynu bez podatku: "+magazyn.wartośćMagazynu());

        magazyn.setPodatek(usaL);
        System.out.println("Wartość magazynu z podatkiem liniowym usa: "+magazyn.pobierzWartośćPoOpodatkowaniu());
        magazyn.setPodatek(usaP);
        System.out.println("Wartość magazynu z podatkiem progresywnym usa: "+magazyn.pobierzWartośćPoOpodatkowaniu());

        magazyn.setPodatek(polL);
        System.out.println("Wartość magazynu z podatkiem liniowym polska: "+magazyn.pobierzWartośćPoOpodatkowaniu());
        magazyn.setPodatek(polP);
        System.out.println("Wartość magazynu z podatkiem progresywnym polska: "+magazyn.pobierzWartośćPoOpodatkowaniu());

        magazyn.setPodatek(fraL);
        System.out.println("Wartość magazynu z podatkiem liniowym francja: "+magazyn.pobierzWartośćPoOpodatkowaniu());
        magazyn.setPodatek(fraP);
        System.out.println("Wartość magazynu z podatkiem progresywnym francja: "+magazyn.pobierzWartośćPoOpodatkowaniu());

        magazyn.setPodatek(gerL);
        System.out.println("Wartość magazynu z podatkiem liniowym niemcy: "+magazyn.pobierzWartośćPoOpodatkowaniu());
        magazyn.setPodatek(gerP);
        float pN=magazyn.pobierzWartośćPoOpodatkowaniu();
        System.out.println("Wartość magazynu z podatkiem progresywnym niemcy: "+pN);

        adapter.setSerwis(ep);
        System.out.println("Podatek progresywny niemcy w polsce: "+ adapter.getData(pN));
        adapter.setSerwis(eu);
        System.out.println("Podatek progresywny niemcy w usa: "+ adapter.getData(pN));
    }
}