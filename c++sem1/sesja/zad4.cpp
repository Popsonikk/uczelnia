#include <iostream>
#include <string>
using namespace std;
class Samochod
{
    *arr;
    string marka;
    int numer_vin;
    float pojemnosc_silnika;
    int moc_silnika;
    float tuning_ratio( int moc_silnika,float pojemnosc_silnika)
    {
        if(pojemnosc_silnika<2.9)
        {
            return (float)moc_silnika*pojemnosc_silnika/2;
        }
        else
        {
             return (float)moc_silnika*pojemnosc_silnika;
        }
    }
    bool czy_klasa_sport(int moc_silnika,float pojemnosc_silnika)
    {
        if(tuning_ratio(moc_silnika,pojemnosc_silnika)>1000) return true;
        else return false;
    }
public:
    Samochod(int numer_vin,string marka,float pojemnosc_silnika,int moc_silnika)
    {
        this->marka=marka;
        this ->moc_silnika=moc_silnika;
        this ->numer_vin=numer_vin;
        this ->pojemnosc_silnika=pojemnosc_silnika;
    }
   Samochod(int i)
   {
       arr=new Samochod[5];
   }
    void tuninguj(float a,int b)
    {
        this->pojemnosc_silnika=pojemnosc_silnika+a;
        this-> moc_silnika=moc_silnika+b;
    }
    string to_strin()
    {
        return marka+to_string(numer_vin);

    }
    ~Samochod()
    {
        delete[]Samochod;
    }
};
Samochod najszybszy(Samochod &arr,int n)
{
    int indeks=0,tuning,max=0;
    for(int i=0;i<n;i++)
    {
        tuning=Samochod[i]->tuning_ratio;
        if(tuning >max)
        {
            max=tuning;
            indeks=i;
        }
    }
    return Samochod[i]->to_strin;
}
int main()
{
    Samochod *arr=Samochod(5);
    Samochod[0]=Samochod(1000,"opel",24.6,100);
    Samochod[1]=Samochod(100,"ww",44.6,200);
    Samochod[2]=Samochod(2000,"audi",24.8,130);
    Samochod[3]=Samochod(3000,"renol",28.6,190);
    Samochod[4]=Samochod(1070,"bmw",14.6,10);
    for(int i=0;i<5;i++)
    {
        Samochod[i].tuninguj((float)i+3,5*i+7);
    }
    for(int i=0;i<5;i++)
    {
        cout<<Samochod[i].to_strin()<<' ';
    }
    cout<<najszybszy(arr,5);
    delete []Samochod
}
