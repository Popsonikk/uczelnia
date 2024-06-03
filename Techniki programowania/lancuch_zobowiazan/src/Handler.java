public abstract class Handler {

    protected Handler next;
    Handler()
    {
        this.next=null;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
    public abstract String process(Event e);
}
