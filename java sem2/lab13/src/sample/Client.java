package sample;

import java.io.IOException;
import java.net.Socket;

public class Client {
    Socket socket;

    public Client(int port,String address) {//do łączenia w main
        try {
            this.socket = new Socket(address,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
