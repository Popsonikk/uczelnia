import java.awt.*;
import java.util.List;

public class Main {
    static Publisher publisher=new Publisher();
    public static void main(String[] args) {


        Observer observer1=new Observer(List.of(false,false,true),1);
        Observer observer2=new Observer(List.of(false,true,false),2);
        Observer observer3=new Observer(List.of(false,true,true),3);
        Observer observer4=new Observer(List.of(true,false,false),4);
        Observer observer5=new Observer(List.of(true,true,false),5);
        Observer observer6=new Observer(List.of(true,false,true),6);
        Observer observer7=new Observer(List.of(true,true,true),7);
        publisher.dodaj(observer1);
        publisher.dodaj(observer2);
        publisher.dodaj(observer3);
        publisher.dodaj(observer4);
        publisher.dodaj(observer5);
        publisher.dodaj(observer6);
        publisher.dodaj(observer7);
        observer7.Zagrorzenie();
        observer2.PowiadomDrozd();
        observer5.PowiadomWiewiórka();
        observer4.PowiadomKrólik();

    }
}