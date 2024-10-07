package com.company;

public class Line implements ReadDevice,WriteDevice{

    private String line;
    @Override
    public String read() {
        return line;
    }

    @Override
    public void write(String s) {
        this.line=s;
        System.out.println("Wiadomosc czeka \n");
    }
}
