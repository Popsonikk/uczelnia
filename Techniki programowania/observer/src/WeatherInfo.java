public class WeatherInfo {
    boolean flag;
    private int temperature;
    private int wind;

    public WeatherInfo(boolean flag, int temperature, int wind) {
        this.flag = flag;
        this.temperature = temperature;
        this.wind = wind;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getWind() {
        return wind;
    }

    public boolean isFlag() {
        return flag;
    }
}
