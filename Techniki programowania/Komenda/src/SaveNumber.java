import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class SaveNumber extends Komenda{
    public SaveNumber(String path, int hour, int minute) {
        super(path, hour, minute);
    }

    @Override
    public void doSomething() {
        File file=new File(getPath());
        try {
            Writer writer= new FileWriter(file,true);
            writer.write("10000\n");
            writer.close();
            System.out.println("Dane wpisane poprawnie");


        } catch (IOException e) {
            System.out.println("Błąd przy zapisie do pliku: "+e);
        }

    }
}
