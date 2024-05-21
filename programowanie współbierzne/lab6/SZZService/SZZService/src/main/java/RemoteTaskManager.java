import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteTaskManager extends Remote {
    boolean registerUser(String username, String password, String email) throws RemoteException;
    boolean loginUser(String username, String password) throws RemoteException;
    boolean addTask(Task task) throws RemoteException;
    List<Task> getTasks() throws RemoteException;
    boolean editTask(int taskId, Task newTask) throws RemoteException;
    boolean deleteTask(int taskId) throws RemoteException;
    boolean assignTask(int taskId, String username) throws RemoteException;
    // Metody dotyczące zarządzania zadaniami
    void addObserver(TaskObserver observer) throws RemoteException;
    void removeObserver(TaskObserver observer) throws RemoteException;
}