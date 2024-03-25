public class Director {
    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Produkt wygenerujNapis(int []tablica)
    {
        builder.budujNaglowek();
        builder.budujTagi();
        builder.budujBody(tablica);
        return builder.getProdukt();
    }
}
