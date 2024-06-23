public  abstract class Chain {

    protected Chain next;

    public void setNext(Chain next) {
        this.next = next;
    }

    public  abstract String handle(Zamówienie zamówienie);
}
