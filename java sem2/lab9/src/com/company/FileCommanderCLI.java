package com.company;

import java.io.*;

public class FileCommanderCLI {
    BufferedReader streamIn;
    BufferedWriter streamOut;
    private FileCommander commander;

    public FileCommanderCLI(InputStream streamIn, OutputStream streamOut) {
        this.streamIn = new BufferedReader(new InputStreamReader(streamIn));
        this.streamOut = new BufferedWriter(new OutputStreamWriter(streamOut));
        commander = new FileCommander();
    }

    public void eventLoop() {
        for (; ; ) {
            try {
                String str = streamIn.readLine();
                //streamOut.write(str);
                runCommand(str);
                streamOut.flush();
            } catch (IOException e) {

            }
        }
    }
    public void runCommand(String str) throws IOException{
        String [] tab = str.split(" ", 2);
        switch (tab[0]){
            case "pwd":
                streamOut.write(commander.pwd()+"\n");
                break;
            case "ls":
                streamOut.write(commander.ls().toString()+"\n");
                break;
            case "cd":
                commander.cd(tab[1]);
                break;
            case "find":
                streamOut.write(commander.find(tab[1]).toString()+"\n");
                break;
            default:streamOut.write("nie znana instrukca");

        }
    }
}