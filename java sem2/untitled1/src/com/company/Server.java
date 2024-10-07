package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private ServerSocket serverSocket;
    private List<ClientThread> clients =new ArrayList<>();
    private Map<String, String> credentials;
    private Map<String, Queue<String>> messageQueues = new HashMap<>();


    public Server(int port) {


        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void listen(){
        while(true){
            Socket clientSocket= null;
            try {
                clientSocket = serverSocket.accept();
                ClientThread thread = new ClientThread(clientSocket, this);
                clients.add(thread);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void broadcast(ClientThread sender, String message){
        for(var currentClient : clients){
            if(currentClient != sender){
                currentClient.send("$broadcast "+sender.getUserName()+" "+message);
            }
        }
    }

    public void getList(ClientThread sender){
        String message="$list ";
        for(var currentClient: clients)
            message +=currentClient.getUserName()+" ";
        sender.send(message);

    }
    public void sendPrivate(String message, ClientThread sender){
        String arr[] = message.split(" ",3 );
        for(var currentClient: clients){
            if(currentClient.getUserName().equals(arr[1])){
                currentClient.send("$private "+ sender.getUserName()+": "+ arr[2]);
            }
            else {
                if(credentials.containsKey(arr[1])) {
                    Queue<String> messageQueue;
                    if(messageQueues.containsKey(arr[1]))
                        messageQueue = messageQueues.get(arr[1]);
                    else {
                        messageQueue = new LinkedList<String>();
                        messageQueues.put(arr[1], messageQueue);
                    }
                    messageQueue.add("$private "+ sender.getUserName()+" "+ arr[2]);
                }
            }
        }
    }

    public void logout(ClientThread client){
        clients.remove(client);
        for(var currentClient: clients){
            currentClient.send("$logout "+client.getUserName());
        }
    }

    public void authorize(String message, ClientThread client) {
        String cred[] = message.split(" ");
        if(credentials.containsKey(cred[1]) && credentials.get(cred[1]).equals(cred[2])) {
            client.setUserName(cred[1]);
            broadcastLogin(client);
            sendQueuedMessages(client);
        }
        else {
            client.send("$bad_credentials");
            client.closeSocket();
            clients.remove(client);
        }
    }

    private void sendQueuedMessages(ClientThread client) {
        System.out.println(messageQueues);
        Queue<String> messageQueue = messageQueues.get(client.getUserName());
        if(messageQueue != null) {
            while (!messageQueue.isEmpty()) {
                String message = messageQueue.remove();
                client.send(message);
            }
        }
    }

    public void broadcastLogin(ClientThread client) {
        for(var currentClient: clients){
            if(client!=currentClient)
                currentClient.send("$login "+client.getUserName());
        }
    }
}
