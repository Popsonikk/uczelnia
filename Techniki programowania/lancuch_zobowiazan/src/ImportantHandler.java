public class ImportantHandler extends Handler{
    @Override
    public String process(Event e) {
        if(e.getCategory()==2)
        {
            e.setMessage("UWAGA! TO JEST WAŻNA WIADOMOŚĆ. "+e.getMessage());
            return e.getMessage();
        }

        if(next!=null)
            return next.process(e);

        return e.getMessage();
    }
}
