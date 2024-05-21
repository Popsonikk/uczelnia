import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;

public class Client extends UnicastRemoteObject implements TaskObserver {
    private RemoteTaskManager taskManager;

    protected Client() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.init();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void init() throws Exception {
        taskManager = (RemoteTaskManager) Naming.lookup("rmi://localhost/TaskManager");
        taskManager.addObserver(this);

        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false;
        String username = "";

        while (true) {
            if (!loggedIn) {
                System.out.println("1. Zarejestruj nowe konto");
                System.out.println("2. Zaloguj się");
                System.out.println("3. Wyjdź");
                System.out.print("Wybierz opcję: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consuming newline character

                switch (choice) {
                    case 1:
                        System.out.print("Podaj nazwę użytkownika: ");
                        String newUsername = scanner.nextLine();
                        System.out.print("Podaj hasło: ");
                        String newPassword = scanner.nextLine();
                        System.out.print("Podaj adres e-mail: ");
                        String newEmail = scanner.nextLine();
                        boolean registered = taskManager.registerUser(newUsername, newPassword, newEmail);
                        if (registered) {
                            System.out.println("Zarejestrowano pomyślnie!");
                        } else {
                            System.out.println("Rejestracja nie powiodła się. Nazwa użytkownika już istnieje.");
                        }
                        break;
                    case 2:
                        System.out.print("Podaj nazwę użytkownika: ");
                        username = scanner.nextLine();
                        System.out.print("Podaj hasło: ");
                        String password = scanner.nextLine();
                        loggedIn = taskManager.loginUser(username, password);
                        if (loggedIn) {
                            System.out.println("Zalogowano pomyślnie!");
                        } else {
                            System.out.println("Nieprawidłowa nazwa użytkownika lub hasło.");
                        }
                        break;
                    case 3:
                        System.out.println("Do widzenia!");
                        System.exit(0);
                    default:
                        System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                }
            } else {
                System.out.println("1. Dodaj nowe zadanie");
                System.out.println("2. Przeglądaj zadania");
                System.out.println("3. Wyloguj się");
                System.out.print("Wybierz opcję: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consuming newline character

                switch (choice) {
                    case 1:
                        System.out.print("Podaj tytuł zadania: ");
                        String title = scanner.nextLine();
                        System.out.print("Podaj opis zadania: ");
                        String description = scanner.nextLine();
                        System.out.print("Podaj priorytet zadania (1 - niski, 2 - średni, 3 - wysoki): ");
                        int priority = scanner.nextInt();
                        scanner.nextLine(); // Consuming newline character
                        System.out.print("Podaj termin wykonania zadania (np. '2024-05-15'): ");
                        String deadline = scanner.nextLine();
                        Task task = new Task(title, description, priority, deadline);
                        boolean added = taskManager.addTask(task);
                        if (added) {
                            System.out.println("Zadanie dodane pomyślnie!");
                        } else {
                            System.out.println("Nie udało się dodać zadania.");
                        }
                        break;
                    case 2:
                        List<Task> tasks = taskManager.getTasks();
                        System.out.println("Twoje zadania:");
                        for (Task t : tasks) {
                            System.out.println(t.getTitle() + " - Priorytet: " + t.getPriority() + ", Termin: " + t.getDeadline());
                            System.out.println("   Opis: " + t.getDescription());
                        }
                        break;
                    case 3:
                        loggedIn = false;
                        System.out.println("Wylogowano pomyślnie!");
                        break;
                    default:
                        System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                }
            }
        }
    }

    @Override
    public void updateTasks(List<Task> tasks) throws RemoteException {
        // Aktualizacja widoku klienta po otrzymaniu aktualizacji z serwera
        System.out.println("Aktualizacja zadań:");
        for (Task task : tasks) {
            System.out.println(task.getTitle() + " - Priorytet: " + task.getPriority() + ", Termin: " + task.getDeadline());
            System.out.println("   Opis: " + task.getDescription());
        }
    }
}
