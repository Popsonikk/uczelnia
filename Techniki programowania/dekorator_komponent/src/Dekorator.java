public abstract class Dekorator implements Komponent{
    protected Firma komponent;
    Dekorator(Firma k)
    {
        this.komponent=k;
    }
    @Override
    public void premia() {
        komponent.premia();
    }
    abstract void wrap();
}
