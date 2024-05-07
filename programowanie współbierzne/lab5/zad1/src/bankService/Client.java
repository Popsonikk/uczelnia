package bankService;

import java.io.Serializable;

public class Client implements Serializable {
    private String firstName, lastName;
    private int age;
    private double money;

    public Client(String firstName, String lastName, int age, double money) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
}
