package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        //new File("filename");
        Server server = null;

            server = new Server(5000);
            server.listen();

    }
}
