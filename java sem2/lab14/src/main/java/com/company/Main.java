package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
	DatabaseConnection.connect();
        try {

            //System.out.println(Person.find("popek"));
           // System.out.println(Person.startfind("ko"));
            System.out.println( Person.show_index("pawel","brudny"));
            //System.out.println(Person.odczyt());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DatabaseConnection.disconnect();
    }
}
