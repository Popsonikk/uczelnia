package com.company;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket;
    private PrintWriter writer;
    private Server server;
    boolean authorized;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;

    public String getUserName() {
        return userName;
    }

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        authorized = false;
    }

    public void run(){
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            writer = new PrintWriter(output, true);
            while (true){
                String message = reader.readLine();
                System.out.println(message);
                if(isCommand(message))
                    runCommand(message);
            }
        } catch (IOException e) {
            System.out.println(userName+"'s socket closed");
            //e.printStackTrace();
        }
    }

    public void send(String message){
        writer.println(message);
    }

    public void closeSocket() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void logout() {
        closeSocket();
        server.logout(this);

    }

    private boolean isCommand(String message){
        return  (message!=null && !(message.isEmpty()) && message.charAt(0) == '$');
    }
    private void runCommand(String message){
        if(authorized) {
            if(message.startsWith("$broadcast")){
                server.broadcast(this,message.split(" ",2)[1] );
            }else if(message.startsWith("$list")){
                server.getList(this);
            }else if(message.startsWith("$private")){
                server.sendPrivate(message, this);
            }else if(message.startsWith("$logout")){
                logout();
            }
        }
        else {
            if (message.startsWith("$login")) {
                server.authorize(message, this);
            }

        }
        if(message.startsWith("$broadcast")){
            server.broadcast(this,message.split(" ",2)[1] );
        }else if(message.startsWith("$list")){
            server.getList(this);
        }else if(message.startsWith("$private")){
            server.sendPrivate(message, this);
        }else if(message.startsWith("$logout")){
            logout();
        }

    }






}
