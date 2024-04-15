import java.util.Random;

public class Wind extends Thread
{
    private Producer producer;

    public Wind(Producer producer) {
        this.producer = producer;
    }



    @Override
    public void run()
    {
        Random random=new Random();
        while (true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            producer.notified(new WeatherInfo(false,0,random.nextInt(99)));
        }

    }

}
