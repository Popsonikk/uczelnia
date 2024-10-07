package com.company;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientThreat extends  Thread{
    private Socket socket;
    private PrintWriter writer;
    private  Server server;
    private  String user_name;

    public String getUser_name() {
        return user_name;
    }

    public ClientThreat(Socket socket, Server server) {
        this.socket = socket;
        this.server= server;
    }
    @Override
    public  void run()
    {
        try {
            InputStream inputStream=socket.getInputStream();
            OutputStream outputStream=socket.getOutputStream();
            BufferedReader reader= new BufferedReader(new InputStreamReader(inputStream));
             writer=new PrintWriter(outputStream,true);
            while (true)
            {
                String message=reader.readLine();
                System.out.println(message);
                if (is_command(message))
                    run_command(message);
                //server.broadcast(message,this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run_command(String message) {
        if(message.startsWith("$login")) //$login admin
            user_name=message.split(" ",2)[1]; //[1]$login, [2] admin
        else if(message.startsWith("$broadcast")) //$login admin
            server.broadcast(message.split(" ",2)[1],this);
        else if(message.startsWith("$list")) //$login admin
            server.get_list(this);
    }

    private Boolean is_command(String message)
    {
        return !message.isEmpty()&&message!=null&&message.startsWith("$");

    }
    public void send(String message)
    {
        writer.println(message);
    }
}
