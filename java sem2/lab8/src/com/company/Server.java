package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;
    private List<ClientThreat> clients=new ArrayList<ClientThreat>() ;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void listen()
    {
        while(true)
        {
            try {
                Socket clientSocket=serverSocket.accept();
                ClientThreat clientThreat=new ClientThreat(clientSocket,this);
                clients.add(clientThreat);
                clientThreat.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    void broadcast(String message, ClientThreat client)
    {
        for(ClientThreat clientThreat:clients)
        {
            if(clientThreat!=client)
            {
                clientThreat.send("$broadcast "+ clientThreat.getUser_name()+":"+message);
            }
        }
    }

    public void get_list(ClientThreat clientThreat) {
        String result="$list ";
        for(ClientThreat client:clients)
        {
            result+=client.getUser_name()+" ";
        }
        clientThreat.send(result);
    }
}
