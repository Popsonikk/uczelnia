import java.io.Serializable;

public class Task implements Serializable {
    //private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private int priority;
    private String deadline;

    public Task(String title, String description, int priority, String deadline) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public String getDeadline() {
        return deadline;
    }
}

