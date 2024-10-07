package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;
    private List<String> list= new ArrayList<>();
    Server(int port)
    {
        try {
            this.serverSocket=new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void listen()
    {
        try {
            Socket clientSocket= serverSocket.accept();
            ClientThread clientThread= new ClientThread(clientSocket,this);
            list.add(clientThread.getName());
            clientThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
