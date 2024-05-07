package bankService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankServiceInterface extends Remote {
    Client  register(String firstName, String lastName, int age, double money) throws RemoteException;
    String getInfo() throws RemoteException;
    double getSum() throws RemoteException;
}
