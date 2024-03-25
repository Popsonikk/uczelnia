public abstract class Builder {
    protected Produkt produkt;
    Builder()
    {
        produkt=new Produkt();
    }
    public abstract void budujNaglowek();
    public abstract void budujTagi();
    public abstract void budujBody(int []tablica);

    public Produkt getProdukt()
    {
        return produkt;
    }



}
