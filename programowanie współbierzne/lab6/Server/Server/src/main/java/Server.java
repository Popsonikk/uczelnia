import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String [] args)
    {
        try {
            RemoteTaskManagerImpl remoteTaskManager= new RemoteTaskManagerImpl();
            LocateRegistry.createRegistry(5555);
            Naming.lookup("//localhost:5555/RemoteTaskManager");
            System.out.println("server ready");
        } catch (RemoteException|MalformedURLException|NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
