public class Zamówienie {

    private boolean part1, part2, part3;

    private boolean completed;


    public Zamówienie(boolean part1, boolean part2, boolean part3) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.completed=false;
    }

    public boolean isPart1() {
        return part1;
    }

    public void setPart1(boolean part1) {
        this.part1 = part1;
    }

    public boolean isPart2() {
        return part2;
    }

    public void setPart2(boolean part2) {
        this.part2 = part2;
    }

    public boolean isPart3() {
        return part3;
    }

    public void setPart3(boolean part3) {
        this.part3 = part3;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
