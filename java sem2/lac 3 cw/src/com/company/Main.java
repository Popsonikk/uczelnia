package com.company;

public class Main {

    public static void main(String[] args)
    {
        Account account= new Account("pop","us","pat","ryk");
        Account account1= new Account("pop","uws","pawt","rykw");
        //System.out.println(account.toString());
      //  System.out.println(account1.toString());
        Student student= new Student("pp","aus","wer","ika","mat",2018);
        System.out.println(student.semestr());

    }
}
