package com.company;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket;
    private PrintWriter writer;
    private Server server;
    private String user_name;

    ClientThread(Socket socket,Server server)
    {
        this.socket=socket;
        this.server=server;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void run()
    {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            writer= new PrintWriter(outputStream,true);
            while(true)
            {
                String message= reader.readLine();
                System.out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(String message){
        writer.println(message);
    }
}
