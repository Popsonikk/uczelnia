public class OtherHandler extends Handler{
    @Override
    public String process(Event e) {
        if(e.getCategory()==3)
            e.setMessage("UWAGA! TO JEST INNA WIADOMOŚĆ. "+e.getMessage());
        else
            e.setMessage(e.getMessage()+"To nie jest inna wiadomosć. ");

        if(next==null)
            return e.getMessage();
        else
            return next.process(e);
    }
}
