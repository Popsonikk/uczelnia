import java.io.IOException;

public class Builder {
    private ProcessBuilder pb;

    Builder()
    {
        pb=new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe","C:\\Users\\popso\\Downloads\\Zadania.pdf");
    }


    public void run() {


        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
