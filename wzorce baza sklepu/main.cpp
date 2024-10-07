//mini system sklepu rowerowego
#include <iostream>
#include <string>
#include <vector>
#include "Konto.h"
#include "Klient.h"
#include "Baza.h"
#include "Wlasciciel.h"
#include "Towar.h"
#include "Hulajnoga.h"
#include "Rower.h"
#include "FirmaZaopatrzeniowa.h"
#include <tuple>
using namespace std;

int main()
{

    Klient klient=Klient();
    Wlasciciel wlasciciel=Wlasciciel("Jan_Kowalski",Baza(),Konto(10000));
    int n; //sterowanie w petli;
    cout<<"Witaj w naszym prostym systemie"<<'\n';
    cout<<"Nacisnij enter by kontynuowac"<<'\n';
    cin.get();
    while(1)
    {
        cout<<"-----------------------------------"<<'\n';
        cout<<"Klient: "<<'\n';
        cout<<"Nacisnij 1 aby sprawdzic katalog"<<'\n';
        cout<<"Nacisnij 2 aby kupic rower"<<'\n';
        cout<<"Nacisnij 3 aby naprawic rower"<<'\n';
        cout<<"Nacisnij 4 aby sprzedac rower"<<'\n';
        cout<<"Wlasciciel:"<<'\n';
        cout<<"Nacisnij 5 aby sprawdzic stan bazy"<<'\n';
        cout<<"Nacisnij 6 aby zamowic towar"<<'\n';
        cout<<"Nacisnij 7 aby sprawdzic stan konta"<<'\n';
        cout<<"Nacisnij 8 aby zmienic cene towaru"<<'\n';
        cout<<"Nacisnij 9 aby zobaczyc historie systemu"<<'\n';
        cout<<"Nacisnij 0 aby zakonczyc"<<'\n';
        cout<<"-----------------------------------"<<'\n';
        cin>>n;
        if (n==1)
        {
            klient.zobaczStan(wlasciciel);
            wlasciciel.addHistory("Przegladanie katalogu (klient)");
        }
        else if(n==2)
        {
            cout<<"Podaj marke Towaru, ktory chcesz kupic "<<'\n';
            string s;
            cin>>s;
            wlasciciel=klient.kupRower(s,wlasciciel,0,0);
            wlasciciel.addHistory("Kupno roweru (klient)");

        }
        else if(n==3)
        {
            cout<<"Podaj marke Towaru, ktory chcesz naprawic "<<'\n';
            string s;
            cin>>s;
            wlasciciel=klient.naprawRower(s,wlasciciel);
            wlasciciel.addHistory("Naprawa roweru (klient)");
        }
        else if(n==4)
        {
            cout<<"Podaj marke Towaru, ktory chcesz sprzedac "<<'\n';
            string s;
            cin>>s;
            cout<<"Podaj ilosc Towaru, ktory chcesz sprzedac "<<'\n';
            int x;
            cin>>x;
            cout<<"Podaj cene Towaru, ktory chcesz sprzedac  (nie ma wplywu jezeli towar juz w bazie) "<<'\n';
            float c;
            cin>>c;

            wlasciciel=klient.zwrocRower(s,wlasciciel,c,x);
            wlasciciel.addHistory("Sprzedaz roweru (klient)");
        }
        else if(n==5)
        {
            wlasciciel.getBaza().PokazSzczegoloweDane();
            wlasciciel.addHistory("Przegladanie katalogu (wlasciciel)");
        }
        else if(n==6)
        {
            cout<<"Podaj marke Towaru, ktory chcesz zamowic "<<'\n';
            string s;
            cin>>s;
            cout<<"Podaj ilosc Towaru, ktory chcesz zamowic "<<'\n';
            int x;
            cin>>x;
            cout<<"Podaj cene Towaru, ktory chcesz zamowic (nie ma wplywu jezeli towar juz w bazie) "<<'\n';
            float c;
            cin>>c;
            FirmaZaopatrzeniowa *f=new FirmaZaopatrzeniowa();
            std::tuple<Baza,Konto> t= f->ZamowTowar(s,wlasciciel.getBaza(),wlasciciel.getKonto(),x,c);
            wlasciciel.setBaza(std::get < 0 >( t ));
            wlasciciel.setKonto(std::get < 1 >( t ));
            wlasciciel.addHistory("Zamowienie towaru (wlasciciel)");
            delete f;
        }
        else if(n==7)
        {
           cout<<"Stan konta sklepu wynosi "<<wlasciciel.getKonto().getwartosc()<<"\n";
           wlasciciel.addHistory("Sprawdzenie stanu konta (wlasciciel)");
        }
        else if(n==8)
        {
           cout<<"Podaj marke Towaru, ktory chcesz zamowic "<<'\n';
            string s;
            cin>>s;
            cout<<"Podaj cene , na ktora chcesz zmienic"<<'\n';
            float c;
            cin>>c;
            wlasciciel.ZmienCene(s,c);
            wlasciciel.addHistory("Zmiana ceny (wlasciciel)");
        }
        else if(n==9)
        {
           wlasciciel.addHistory("Sprawdzenie historii");
           wlasciciel.showHistory();
        }
        else if(n==0)
        {
            cout<<"-----------------------------------------------------------"<<'\n';
            cout<<"Prace wykonal: Patryk Popek, "<<'\n';
            cout<<"-----------------------------------------------------------"<<'\n';
            return 0;
        }
    }

}
