import java.io.*;

public class DoMath extends Komenda{
    public DoMath(String path, int hour, int minute) {
        super(path, hour, minute);
    }

    @Override
    public void doSomething() {
        File file=new File(getPath());
        try {
            int sum=0;
            BufferedReader reader= new BufferedReader(new FileReader(file));
            String line=reader.readLine();
            while(line!=null)
            {
                if(line.equals("10000"))
                    sum+=10000;
                line=reader.readLine();

            }
            Writer writer= new FileWriter(file,true);
            writer.write("sum:"+sum+"\n");
            writer.close();
            System.out.println("Dane wpisane poprawnie");


        } catch (IOException e) {
            System.out.println("Błąd przy zapisie do pliku: "+e);
        }

    }
}
