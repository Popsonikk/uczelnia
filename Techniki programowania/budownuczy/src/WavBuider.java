public class WavBuider extends Builder{
    @Override
    public void budujNaglowek() {
        produkt.setNagłówek("WavHeader");
    }

    @Override
    public void budujTagi() {
        produkt.setTagi(" ");
    }

    @Override
    public void budujBody(int[] tablica) {
        StringBuilder res= new StringBuilder();
        for(int i:tablica)
        {
            res.append(i).append(',');
        }
        produkt.setBody(res.toString());

    }
}
