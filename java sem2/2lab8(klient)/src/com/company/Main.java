package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
	    ServerThread serverThread=new ServerThread("LocalHost",3000);
	    serverThread.start();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String line;
        try{

            serverThread.login(reader.readLine());
            while (true)
            {
                line= reader.readLine();
                if(line.equals("/list"))
                {
                    serverThread.list();
                }
                else
                serverThread.send(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
