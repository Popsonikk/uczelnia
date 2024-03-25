import java.util.Base64;

public class OggBuilder extends Builder{
    @Override
    public void budujNaglowek() {
        produkt.setNapis("OggHeader\n");
    }

    @Override
    public void budujTagi() {
        produkt.setNapis("OggTags\n");
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
        produkt.setNapis(res.toString());

    }
}
