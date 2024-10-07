#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;
struct Student
{
    char imie[20];
    char nazwisko[20];
    int kol1;
    int kol2;
    int rozbojnik;
};
Student *f(Student *st,int c)
{
    Student *wsk=nullptr;
    int wynik=0;
    for(int i=0;i<c;i++)
    {
        int suma=0;
        if(st[i].kol1+st[i].kol2<51)
        {
            if(st[i].kol1>st[i].kol2)
                suma=st[i].kol1+st[i].rozbojnik;
            else
                suma=st[i].kol2+st[i].rozbojnik;
        }
        else
            suma=st[i].kol2+st[i].kol1;
        if(suma>wynik)
        {
            wynik=suma;
            wsk=st+i;
        }
    }
    return wsk;
}
int main()
{
    Student studenci[5];
    studenci[2]=Student{"Jan","Kowalski",50,50};
    studenci[1]=Student{"Adam","Nowak",40,0,20};
    studenci[0]=Student{"Patryk","Popek",10,30,35};
    studenci[3]=Student{"Sad","Big",20,10,45};
    studenci[4]=Student{"ASd","SFGH",30,10,5};
    Student *wsk=f(studenci,5);
    cout<<wsk->imie<<wsk->nazwisko;
}
