public class Dekorator2 extends Dekorator{
    Dekorator2(Firma k) {
        super( k);
    }

    @Override
    void wrap() {
        char[]arr= komponent.getNIP().toCharArray();
        float i=0;
        for(char c:arr)
        {
            if((c-'0')%3 ==0)
                i++;
        }
        if(i/arr.length>=0.5)
            komponent.addPremia(100);
    }
}
