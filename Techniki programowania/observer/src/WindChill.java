public class WindChill extends Obserwator{
    private float lastWind;
    public WindChill(int size) {
        super(size);
    }



    @Override
    public void notified(WeatherInfo x) {
        if(x.flag){
            list.add(x.getTemperature());
            currSize++;
            float w=lastWind;
            if(currSize==size)
            {
                int sum=0;
                for(int n:list)
                    sum+=(n-((w/100)*5));
                list.clear();
                currSize=0;
                System.out.println("Średnia z "+size+" dni wynosi "+sum/size+" przy wietrze "+w);
            }
        }
        else
            lastWind= x.getWind();

    }


}
