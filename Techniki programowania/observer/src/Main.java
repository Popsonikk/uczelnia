public class Main {

    public static void main(String[] args) {

        Producer producer=new Producer();
        producer.subscribe(new TemperatureAverage(3));
        producer.subscribe(new TemperatureAverage(5));
        producer.subscribe(new TemperatureAverage(7));
        producer.subscribe(new WindChill(3));
        producer.subscribe(new WindChill(5));
        producer.subscribe(new WindChill(7));
        Temperature temperature=new Temperature(producer);
        Wind wind=new Wind(producer);
        temperature.start();
        wind.start();

    }
}