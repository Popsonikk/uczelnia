import java.util.ArrayList;
import java.util.List;

public abstract class Obserwator {
    protected List<Integer> list;
    protected int size;
    protected int currSize;

    public Obserwator(int size) {
        this.size = size;
        list=new ArrayList<>();
        currSize=0;
    }

    public abstract void notified(WeatherInfo wi);

}
