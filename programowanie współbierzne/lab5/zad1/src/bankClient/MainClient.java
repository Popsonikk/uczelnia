package bankClient;

import bankService.Client;
import bankService.BankServiceInterface;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClient implements Serializable {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        BankServiceInterface bankServer= (BankServiceInterface) Naming.lookup("//localhost:5555/bankServer");
        Client client= bankServer.register("jan","nowak",23,700);
        System.out.println(client.getMoney());


    }
}
