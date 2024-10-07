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
float f(Student *st,int c)
{
    float srednia;
    for(int i=0;i<c;i++)
    {
        int suma;
        if(st[i].kol1+st[i].kol2<51)
        {
            if(st[i].kol1>st[i].kol2)
                suma=st[i].kol1+st[i].rozbojnik;
            else
                suma=st[i].kol2+st[i].rozbojnik;
        }
        else
            suma=st[i].kol2+st[i].kol1;

        switch((suma-1)/10)
        {
            case 5:srednia+=3;break;
            case 6:srednia+=3.5;break;
            case 7:srednia+=4;break;
            case 8:srednia+=4.5;break;
            case 9:srednia+=5;break;
            default :srednia+=2;break;
        }
    }
    return srednia/c;

}
int main()
{
    Student studenci[5];
    studenci[0]=Student{"Jan","Kowalski",50,50};
    studenci[1]=Student{"Adam","Nowak",40,0,20};
    studenci[2]=Student{"Patryk","Popek",10,30,35};
    studenci[3]=Student{"Sad","Big",20,10,45};
    studenci[4]=Student{"ASd","SFGH",30,10,5};
    cout<<f(studenci,5);
}
