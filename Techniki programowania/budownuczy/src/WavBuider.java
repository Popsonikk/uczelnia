public class WavBuider extends Builder{
    @Override
    public void budujNaglowek() {
        produkt.setNapis("WavHeader\n");
    }

    @Override
    public void budujTagi() {
        produkt.setNapis(" \n");
    }

    @Override
    public void budujBody(int[] tablica) {
        StringBuilder res= new StringBuilder();
        for(int i:tablica)
        {
            res.append(i).append(',');
        }
        produkt.setNapis(res.toString());

    }
}
