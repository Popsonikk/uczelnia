package sample;

import javafx.application.Platform;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private ServerSocket serverSocket;
    private ClientThread [] clientThreads= new ClientThread[2];//dwóch graczy
    private Main main;

    public Server(int port,Main main) {
        try {
            this.serverSocket= new ServerSocket(port);
            this.main=main;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run()//start() wywołuje run() <server dziedziczy po wątku>
    {
       for(int i=0;i<2;i++)
       {
           try {
               Socket clientSocket=serverSocket.accept();
               ClientThread clientThread= new ClientThread(clientSocket);
               clientThreads[i]= clientThread;
               clientThread.start();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

        Platform.runLater(()->{
            main.showGameWidget(); //pokazanie okienka gry hostowi
        });
    }
}
