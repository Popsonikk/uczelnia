public class Event {

    private String message;
    private int category;

    public Event(String message, int category) {
        this.message = message;
        this.category = category;
    }

    public String getMessage() {
        return message;
    }

    public int getCategory() {
        return category;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
