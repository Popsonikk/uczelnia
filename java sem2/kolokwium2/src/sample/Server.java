package sample;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
public class Server  extends Thread {
    private ServerSocket serverSocket;
    private List<ClientThread>clientThreads= new ArrayList<>();
    public Server(int port) {
        try {
            this.serverSocket= new ServerSocket(port);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run()
    {
        while(true)
        {
            try {
                Socket clientSocket=serverSocket.accept();
                ClientThread clientThread= new ClientThread(clientSocket,this);
                clientThreads.add(clientThread);
                clientThread.start();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
   public List<ClientThread> getList()
   {
       return clientThreads;
   }
   public String getMessage(ClientThread clientThread,String message)
   {
       return message;
   }


}
