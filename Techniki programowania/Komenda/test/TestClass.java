import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class TestClass extends TestCase {

    public void testSaveNumberTest() throws IOException {
        Komenda k=new SaveNumber("testNumber.txt",0,0);
        k.doSomething();
        BufferedReader reader= new BufferedReader(new FileReader("testNumber.txt"));
        String line=reader.readLine();
        Assert.assertEquals("10000",line);
    }
    public void testSaveWordTest() throws IOException {
        Komenda k=new SaveWord("testWord.txt",0,0);
        k.doSomething();
        BufferedReader reader= new BufferedReader(new FileReader("testWord.txt"));
        String line=reader.readLine();
        Assert.assertEquals("savetofile",line);
    }
    public void testDoMathTest() throws IOException {
        Komenda dm=new DoMath("testMath.txt",0,0);
        Komenda l=new SaveNumber("testMath.txt",0,0);
        l.doSomething();
        l.doSomething();
        l.doSomething();
        dm.doSomething();
        BufferedReader reader= new BufferedReader(new FileReader("testMath.txt"));
        String line=reader.readLine();
        line=reader.readLine();
        line=reader.readLine();
        line=reader.readLine();
        Assert.assertEquals("sum:30000",line);
    }
}
