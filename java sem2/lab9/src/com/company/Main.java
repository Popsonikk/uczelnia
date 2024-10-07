package com.company;

public class Main {

    public static void main(String[] args) {
       /* FileCommander file = new FileCommander();
        System.out.println(file.pwd());
        file.cd("Documents");
        System.out.println(file.pwd());
        System.out.println(file.ls());
        System.out.println(file.find("Moja"));*/
       // FileCommanderCLI file= new FileCommanderCLI(System.in,System.out);
       // file.eventLoop();
        Server server=new Server(4000);
        server.listen();
    }
}