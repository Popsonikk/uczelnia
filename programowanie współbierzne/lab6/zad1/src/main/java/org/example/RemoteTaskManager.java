package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteTaskManager extends Remote {

    void rejestracja(String login,String hasło,String email) throws RemoteException;
    boolean logowanie (String login, String hasło) throws RemoteException;
    boolean addTask(Task task) throws RemoteException;
    List<String> getTasks() throws RemoteException;
    void editTasks(String tytuł) throws RemoteException;
    void deleteTask(String tytuł) throws RemoteException;

    void addObserver(TaskObserver observer) throws RemoteException;
    void removeObserver(TaskObserver observer) throws RemoteException;



}
