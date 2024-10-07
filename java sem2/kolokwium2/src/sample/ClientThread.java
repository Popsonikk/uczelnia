package sample;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private Server server;



    public ClientThread(Socket socket,Server server) {

        this.socket = socket;
        this.server= server

    }



    public void run(){
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            reader = new BufferedReader(new InputStreamReader(input));
            writer = new PrintWriter(output, true);
            System.out.println("connected");
            while (true){

                String  message= reader.readLine();
                server.getMessage(this,message);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(String message){
        writer.println(message);
    }
    public String getMessage()
    {
        String message;
        try {
            message= reader.readLine();
            return message;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}

