public class SpamHandler extends Handler{
    @Override
    public String process(Event e) {
        if(e.getCategory()==1)
            e.setMessage("UWAGA! TO JEST SPAM. "+e.getMessage());
        else
            e.setMessage(e.getMessage()+"To nie jest spam. ");

        if(next==null)
            return e.getMessage();
        else
            return next.process(e);
    }
}
