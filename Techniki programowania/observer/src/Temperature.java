import java.util.Random;

public class Temperature extends Thread
{
    private Producer producer;

    public Temperature(Producer producer) {
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
            producer.notified(new WeatherInfo(true,random.nextInt(60)-30,0));
        }

    }

}
