import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj ilość liczb");
        int n= scanner.nextInt();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(scanner.nextInt());
        Thread master=new MasterClass(list);
        master.start();


    }
}