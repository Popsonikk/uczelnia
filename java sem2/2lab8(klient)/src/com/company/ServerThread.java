package com.company;

import java.io.*;
import java.net.Socket;

public class ServerThread extends  Thread{
    private Socket socket;
    private PrintWriter writer;

    public ServerThread(String address,int port) {
        try {
            this.socket=new Socket(address,port);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
               // System.out.println(message);
                run_command(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(String message)
    {
        writer.println(message);
    }
    public  void login(String message)
    {
        send("$login "+message);
    }
    public  void broadcast(String message)
    {
        send("$broadcast "+message);
    }
    public  void list()
    {
        send("$list");
    }
    private void run_command(String message) {

        if(message.startsWith("$broadcast")) //$login admin
            System.out.println(message.split(" ",2)[1]);
        else if (message.startsWith("$list"))
        {
            String[] login_list=message.split(" ");
            for(int j=1;j<login_list.length;j++)
            {
                System.out.println(login_list[j]);
            }
        }
    }
}
