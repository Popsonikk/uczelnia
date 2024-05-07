package bankServer;

import bankService.BankServiceInterface;
import bankService.Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BankServer extends UnicastRemoteObject implements BankServiceInterface {
    List<Client> clientList;
    public BankServer() throws RemoteException {

        this.clientList=new ArrayList<>();
    }
    @Override
    public Client register(String firstName, String lastName, int age, double money) throws RemoteException {
        Client client=new Client(firstName,lastName,age,money);
        clientList.add(client);
        System.out.println("Client "+lastName+" was added");
        return client;
    }

    @Override
    public String getInfo() throws RemoteException {
        return "informacja o kliencie";
    }

    @Override
    public double getSum() throws RemoteException {
        double sum=0;
        for(Client c:clientList)
        {
            sum+=c.getMoney();
        }
        return sum;
    }
}
