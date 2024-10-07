package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        ServerThread serverThread = new ServerThread("localhost", 5000);
        serverThread.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String command = reader.readLine();
            serverThread.login(command);
            while(true) {
                command = reader.readLine();
                if(command.equals("/list"))
                    serverThread.getList();
                else if(command.startsWith("/w"))
                    serverThread.sendPrivate(command);
                else if(command.startsWith("/logout")) {
                    serverThread.logout();
                    break;
                }
                else
                    serverThread.broadcast(command);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
