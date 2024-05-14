package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteTaskManagerImpl extends UnicastRemoteObject implements RemoteTaskManager{
    List<User> users;
    List<Task> tasks;
    List<TaskObserver> observers;

    public RemoteTaskManagerImpl() throws RemoteException {
        super();
        this.users = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    @Override
    public void rejestracja(String s, String s1, String s2) throws RemoteException {
        User user=new User(s,s1,s2);
        users.add(user);

    }

    @Override
    public boolean logowanie(String s, String s1) throws RemoteException {
        for(User u:users)
        {

        }
        return false;
    }

    @Override
    public boolean addTask(Task task) throws RemoteException {
        return false;
    }

    @Override
    public List<String> getTasks() throws RemoteException {
        return null;
    }

    @Override
    public void editTasks(String s) throws RemoteException {

    }

    @Override
    public void deleteTask(String s) throws RemoteException {

    }

    @Override
    public void addObserver(TaskObserver taskObserver) throws RemoteException {

    }

    @Override
    public void removeObserver(TaskObserver taskObserver) throws RemoteException {

    }
}
