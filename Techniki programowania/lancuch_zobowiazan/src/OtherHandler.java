public class OtherHandler extends Handler{
    @Override
    public String process(Event e) {
        if(e.getCategory()==3) {
            e.setMessage("UWAGA! TO JEST INNA WIADOMOŚĆ. " + e.getMessage());
            return e.getMessage();
        }

        if(next!=null)
            return next.process(e);

        return e.getMessage();
    }
}
