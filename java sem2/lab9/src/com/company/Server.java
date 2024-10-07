package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Vector;

public class Server {
    private ServerSocket server;
    private Vector<ClientThread> threads = new Vector<>();

    Server(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        while(true) try {
            Socket clientSocket = server.accept();
            ClientThread clientThread = new ClientThread(clientSocket);
            clientThread.start();
            threads.add(clientThread);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
