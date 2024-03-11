import java.io.*;

public class SaveWord extends Komenda{


    public SaveWord(String path, int hour, int minute) {
        super(path, hour, minute);
    }

    @Override
    public void doSomething() {
        File file=new File(getPath());
        try {
            Writer writer= new FileWriter(file,true);
            writer.write("savetofile\n");
            writer.close();
            System.out.println("Dane wpisane poprawnie");


        } catch (IOException e) {
            System.out.println("Błąd przy zapisie do pliku: "+e);
        }
    }
}
