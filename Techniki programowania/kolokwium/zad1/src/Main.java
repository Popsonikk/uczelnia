public class Main {
    public static void main(String[] args) {

        Firma firma1=new Firma(5);
        Firma firma2=new Firma(30);
        Firma firma3=new Firma(4);
        Makler makler1=new Makler(4.5f,4.8f);
        Makler makler2=new Makler(29f,31f);
        Makler makler3=new Makler(5f,6f);
        makler1.setFirma(firma1);
        makler2.setFirma(firma2);
        makler3.setFirma(firma3);
        Giełda giełda=new Giełda();
        giełda.addMakler(makler1);
        giełda.addMakler(makler2);
        giełda.addMakler(makler3);
        giełda.kupuj();
    }
}