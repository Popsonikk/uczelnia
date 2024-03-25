import java.nio.ByteBuffer;
import java.util.Base64;

public class Mp3Builder extends Builder{

    @Override
    public void budujNaglowek() {
        produkt.setNapis("Mp3Header\n");
    }

    @Override
    public void budujTagi() {
        produkt.setNapis("Mp3Tags\n");
    }

    @Override
    public void budujBody(int[] tablica) {
        StringBuilder res= new StringBuilder();
        for(int i:tablica)
        {
            res.append(Base64.getEncoder().encodeToString(Integer.toString(i).getBytes())).append('\n');
        }
        produkt.setNapis(res.toString());

    }
}
