public class SpamHandler extends Handler{
    @Override
    public String process(Event e) {
        if(e.getCategory()==1)
        {
            e.setMessage("UWAGA! TO JEST SPAM. "+e.getMessage());
            return e.getMessage();
        }

        if(next!=null)
            return next.process(e);

        return e.getMessage();
    }
}
