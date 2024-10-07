package sample;

import java.net.Socket;

public class ClientThread extends Thread {
    Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }
}
