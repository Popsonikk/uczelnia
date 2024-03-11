public abstract class Komenda {

    private String path;
    private int hour;
    private int minute;

    public Komenda(String path, int hour, int minute) {
        this.path = path;
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getPath() {
        return path;
    }

    public abstract void doSomething();
}
