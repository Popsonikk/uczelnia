public class Kolektor extends Chain{

    Kolektor()
    {
        this.next=null;
    }



    @Override
    public String handle(Zamówienie zamówienie) {
        if(zamówienie.isPart1()&& zamówienie.isPart2()&& zamówienie.isPart3()&&!zamówienie.isCompleted())
        {
            zamówienie.setCompleted(true);
            return "Zamówienie zostało skompletowane";
        }
        else if(next!=null)
        {
            return next.handle(zamówienie);
        }
        return "";
    }
}
