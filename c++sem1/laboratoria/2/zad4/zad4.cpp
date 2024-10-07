#include <iostream>
using namespace std;
enum Weekday{Niedziela,Ponie,Wtorek,Sroda,Czw,Pt,Sb};
int main()
{
    int dzien,miesiac,rok;
    cout << "dzien,miesiac,rok" << endl;
    cin>>dzien>>miesiac>>rok;
    int dzien101;
    Weekday dayofweek;
    dzien101=(rok +(rok-1)/4-(rok-1)/100+(rok-1)/400)%7;
    bool czy_przestepny;
    if(rok%4==0)
    {
        if(rok%100==0)
        {
            if(rok%400==0)
                czy_przestepny=true;
            else
              czy_przestepny=false;
        }
        else
           czy_przestepny=true;
    }
    else
        czy_przestepny=false;
    switch (miesiac)
    {
        case 12 : dzien+=30;
        case 11 : dzien+=31;
        case 10 : dzien+=30;
        case 9 : dzien+=31;
        case 8 : dzien+=31;
        case 7 : dzien+=30;
        case 6 : dzien+=31;
        case 5 : dzien+=30;
        case 4 : dzien+=31;
        case 3 : dzien+=czy_przestepny?29:28;
        case 2 : dzien+=31;
        case 1 : dzien+=0;
    }
    dayofweek=(Weekday)((dzien101+dzien-1)%7);
    switch (dayofweek)
    {
        case Niedziela :cout<<"niedzila"<<endl; break;
        case Ponie : cout<<"poniedzialk"<<endl; break;
        case Wtorek : cout<<"wrorek"<<endl; break;
        case Sroda : cout<<"sroda"<<endl; break;
        case Czw : cout<<"czwartek"<<endl; break;
        case Pt : cout<<"piatek"<<endl; break;
        case Sb: cout<<"sobota"<<endl; break;
    }
}
