#include <iostream>

using namespace std;
struct Person
{
    char imie[20];
    char nazwisko[20];
    Person *tata;
    Person *mama;
};
void przedrostki(int n);
void f(Person* osoba,int generacja=1)
{
    if(osoba->tata!=nullptr)
    {
        przedrostki(generacja);
        cout<<osoba->tata->imie<<" "<<osoba->tata->nazwisko<<endl;
        f(osoba->tata,generacja+1);
    }
    if(osoba->mama!=nullptr)
    {
        przedrostki(generacja);
        cout<<osoba->mama->imie<<" "<<osoba->mama->nazwisko<<endl;
        f(osoba->mama,generacja+1);
    }
}
void przedrostki(int n)
{   for(int i=2;i<n;i++)
    {
        cout<<"great";
    }
    if(n>=2) cout<<"grand";
    cout<<"parent: ";
}
void przedrostki(int n,const char* napis)
{   for(int i=2;i<n;i++)
    {
        cout<<"great";
    }
    if(n>=2) cout<<"grand";
    cout<<napis<<endl;
}
int generacja_pokrewienstwa(Person* p1,Person* p2,int n)
{
    int wynik=0;

    if(p1==p2)
    {
        return n;
    }
    if(p1->tata!=nullptr)
    {
        wynik=generacja_pokrewienstwa(p1->tata,p2,n+1);
    }
    if(!wynik && p1->mama!=nullptr)
    {
        wynik=generacja_pokrewienstwa(p1->mama,p2,n+1);
    }
    return wynik;
}
void pokrewienstwo(Person* p1,Person* p2)
{
    int generacja=generacja_pokrewienstwa(p1,p2,0);
    if(generacja)
    {
        przedrostki(generacja,"child");
    }else
    {
        generacja=generacja_pokrewienstwa(p2,p1,0);
        if(generacja)
        {
            przedrostki(generacja,"parent");
        }else
        {
            cout<<"brak relacji"<<endl;
        }
    }
}

int main()
{
    Person *parr=new Person[14];
    parr[0]=Person{"Teodora", "Kowalska", nullptr,nullptr};
    parr[1]=Person{"Zdzislaw", "Kowalski", nullptr,nullptr};
    parr[2]=Person{"January", "Nowak", nullptr,nullptr};
    parr[3]=Person{"Genowefa", "Nowak", nullptr,nullptr};
    parr[4]=Person{"Baltazar", "Nowak",&parr[3],&parr[2]};
    parr[5]=Person{"StanisĹawa", "Nowak",&parr[0],&parr[1]};
    parr[6]=Person{"Anna", "Nowak", nullptr,nullptr};
    parr[7]=Person{"Jan", "Nowak",&parr[5],&parr[4]};
    parr[8]=Person{"Alicja", "Kot", &parr[6], &parr[7]};
    parr[9]=Person{"Tomasz", "Kot", nullptr,nullptr};
    parr[10]=Person{"Maciej", "Kot", &parr[8], &parr[9]};
    parr[11]=Person{"Piotr", "Kot", &parr[8], &parr[9]};
    parr[12]=Person{"Bogna", "Kot", nullptr,nullptr};
    parr[13]=Person{"Sebastian", "Kot", &parr[12], &parr[10]};
    pokrewienstwo(&parr[0],&parr[1]);
return 0;
}
