import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TemperatureAverage extends  Obserwator{

    public TemperatureAverage(int size) {
        super(size);
    }



    @Override
    public void notified(WeatherInfo x) {
        if(x.isFlag())
        {
            list.add(x.getTemperature());
            currSize++;
            if(currSize==size)
            {
                int sum=0;
                for(int n:list)
                    sum+=n;
                list.clear();
                currSize=0;
                System.out.println("Średnia z "+size+" dni wynosi "+sum/size);
            }
        }

    }


}
