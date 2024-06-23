public class Dystrybutor extends Chain{

    Dystrybutor()
    {
        this.next=null;
    }
    @Override
    public String handle(Zamówienie zamówienie) {
        if(zamówienie.isCompleted())
            return "Zamówienie zostało spakowane";
        else if(next!=null)
        {
            return next.handle(zamówienie);
        }
        return "";
    }
}
