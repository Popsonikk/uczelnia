public class ImportantHandler extends Handler{
    @Override
    public String process(Event e) {
        if(e.getCategory()==2)
            e.setMessage("UWAGA! TO JEST WAŻNA WIADOMOŚĆ. "+e.getMessage());
        else
            e.setMessage(e.getMessage()+" To nie jest ważna wiadomosć. ");

        if(next==null)
            return e.getMessage();
        else
            return next.process(e);
    }
}
