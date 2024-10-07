package com.company;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;
    private PrintWriter writer;
    private boolean running;

    public ServerThread(String address, int port) {
        try {
            socket=new Socket(address, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void login(String message){
        send("$login "+message);
    }

    public void run(){
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            writer = new PrintWriter(output, true);
            running = true;
            while (running){
                String message = reader.readLine();
                runCommand(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void send(String message){
        writer.println(message);
    }

    public void broadcast(String message){
        send("$broadcast "+message);
    }
    public void getList(){  send("$list");    }
    public void sendPrivate(String message) {
        send("$private "+message.split(" ",2)[1]);
    }
    private void runCommand(String message){

        try {
            if (message.startsWith("$login")) {
                String arr[] = message.split(" ");
                System.out.println(arr[1] + " connected");
            } else if (message.startsWith("$broadcast")) {
                String arr[] = message.split(" ", 3);
                System.out.println(arr[1] + ": " + arr[2]);
            } else if (message.startsWith("$list")) {
                String arr[] = message.split(" ");
                for (int i = 0; i < arr.length; i++)
                    System.out.print(arr[i] + " ");
                System.out.println();
            } else if (message.startsWith("$private")) {
                String arr[] = message.split(" ", 3);
                System.out.println("[private] " + arr[1] + ": " + arr[2]);
            } else if (message.startsWith("$logout")) {
                String arr[] = message.split(" ");
                System.out.println(arr[1] + " disconnected");
            } else if (message.startsWith("$bad_credentials")) {
                System.exit(0);
            }

        }catch (NullPointerException e)  {}

    }

    public void logout() {
        running = false;
        send("$logout");
    }
}
