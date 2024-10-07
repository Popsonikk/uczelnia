package com.company;

public class Modem {
    private ReadDevice readLine;
    private WriteDevice writeLine;

    public Modem(ReadDevice readLine, WriteDevice writeLine) {
        this.readLine = readLine;
        this.writeLine = writeLine;
    }
    private String readMessage()
    {
       return readLine.read();
    }
    public void  connect (Modem modem)
    {
        Line l1=new Line(modem.);
    }
}
