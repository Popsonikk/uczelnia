import java.util.Base64;

public class OggBuilder extends Builder{
    @Override
    public void budujNaglowek() {
        produkt.setNagłówek("OggHeader");
    }

    @Override
    public void budujTagi() {
        produkt.setTagi("OggTags");
    }

    @Override
    public void budujBody(int[] tablica) {
        StringBuilder res= new StringBuilder();
        for(int i:tablica)
        {
            if(i>100)
                i=100;
            if(i<-100)
                i=-100;
            res.append(Base64.getEncoder().encodeToString(Integer.toString(i).getBytes())).append('\n');
        }
        produkt.setBody(res.toString());

    }
}
