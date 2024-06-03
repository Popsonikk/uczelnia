import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        String str1=s.nextLine();
        String str2=s.nextLine();
        String str3=s.nextLine();

        Handler spamHandler=new SpamHandler();
        Handler importantHandler= new ImportantHandler();
        Handler otherHandler=new OtherHandler();
        spamHandler.setNext(importantHandler);
        importantHandler.setNext(otherHandler);
        System.out.println(spamHandler.process(new Event(str1,1)));
        System.out.println(spamHandler.process(new Event(str2,2)));
        System.out.println(spamHandler.process(new Event(str3,3)));

    }
}