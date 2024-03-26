public class Dekorator1 extends Dekorator{
    Dekorator1(Firma k) {
        super( k);
    }

    @Override
    void wrap() {
       char[]arr= komponent.getNIP().toCharArray();
       for(char c:arr)
       {
           if((c-'0')%2 ==0)
               return;
       }
       komponent.addPremia(50);
    }
}
