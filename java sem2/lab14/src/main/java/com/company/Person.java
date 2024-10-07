package com.company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Person {
    private  int id;
    private  String first_name;
    private  String last_name;

    public Person(int id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
    public  static List<Person> odczyt() throws SQLException {

        Statement statement = DatabaseConnection.getConnection().createStatement();
        statement.execute("SELECT * FROM person");
        ResultSet resultSet = statement.getResultSet();
        return  resultSetToList(resultSet);
    }
    public  static List<Person> find(String name) throws SQLException {
        PreparedStatement preparedStatement=  DatabaseConnection.getConnection().
        prepareStatement("SELECT * FROM person WHERE last_name=?;");
        preparedStatement.setString(1,name);
        preparedStatement.execute();
        ResultSet resultSet= preparedStatement.getResultSet();
        return  resultSetToList(resultSet);

    }
    private  static  List<Person> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Person> personList = new LinkedList<>();
        while (resultSet.next()) {
            int id1 = resultSet.getInt(1);
            String imie = resultSet.getString(2);
            String nazwisko = resultSet.getString(3);
            personList.add(new Person(id1, imie, nazwisko));


        }
        return personList;
    }
    public  static List<Person> startfind(String name) throws SQLException {
        PreparedStatement preparedStatement=  DatabaseConnection.getConnection().
                prepareStatement("SELECT * FROM person WHERE last_name LIKE ?;");
        preparedStatement.setString(1,name+"%");
        preparedStatement.execute();
        ResultSet resultSet= preparedStatement.getResultSet();
        return  resultSetToList(resultSet);

    }
    public  static  void add_row (String fname,String lname) throws SQLException {
        PreparedStatement preparedStatement= DatabaseConnection.getConnection()
                .prepareStatement("INSERT INTO person (first_name,last_name)VALUES(?,?)");
        preparedStatement.setString(1,fname);
        preparedStatement.setString(2,lname);
        preparedStatement.executeUpdate();
    }
    public  static  int show_index (String fname,String lname) throws SQLException {
        PreparedStatement preparedStatement= DatabaseConnection.getConnection()
                .prepareStatement("INSERT INTO person (first_name,last_name)VALUES(?,?)");
        preparedStatement.setString(1,fname);
        preparedStatement.setString(2,lname);
        preparedStatement.executeUpdate();
        ResultSet resultSet= preparedStatement.getGeneratedKeys();
        resultSet.next();
        return resultSet.getInt(1);
    }

}
