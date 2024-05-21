import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteTaskManagerImpl extends UnicastRemoteObject implements RemoteTaskManager {
    private List<Task> tasks;
    private List<User> users;
    private List<TaskObserver> observers;

    public RemoteTaskManagerImpl() throws RemoteException {
        super();
        users = new ArrayList<>();
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Override
    public boolean registerUser(String username, String password, String email) throws RemoteException {
        User newUser = new User(username, password, email);
        if (!users.contains(newUser)) {
            users.add(newUser);
            return true;
        }
        return false;
    }

    @Override
    public boolean loginUser(String username, String password) throws RemoteException {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addTask(Task task) throws RemoteException {
        tasks.add(task);
        notifyObservers();
        return true;
    }

    @Override
    public void addObserver(TaskObserver observer) throws RemoteException {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TaskObserver observer) throws RemoteException {
        observers.remove(observer);
    }

    private void notifyObservers() throws RemoteException {
        for (TaskObserver observer : observers) {
            observer.updateTasks(tasks);
        }
    }

    @Override
    public List<Task> getTasks() throws RemoteException {
        return tasks;
    }

    @Override
    public boolean editTask(int taskId, Task newTask) throws RemoteException {
        if (taskId >= 0 && taskId < tasks.size()) {
            tasks.set(taskId, newTask);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTask(int taskId) throws RemoteException {
        if (taskId >= 0 && taskId < tasks.size()) {
            tasks.remove(taskId);
            return true;
        }
        return false;
    }

    @Override
    public boolean assignTask(int taskId, String username) throws RemoteException {
        // Do implementacji
        return false;
    }
}