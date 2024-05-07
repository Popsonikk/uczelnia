package bankServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainServer {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        BankServer bankServer=new BankServer();
        LocateRegistry.createRegistry(5555);
        Naming.rebind("//localhost:5555/bankServer",bankServer);
        System.out.println("ServerStart");


    }
}
