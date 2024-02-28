#include <iostream>
int minkoszt=1000001; //maksymalny koszt wg zadania to 100 * 10000
void sprawdzZraszacze(int koszt,int estetyka,int *est,int *cost,int l,int n) //l= numer przegladanego zraszacza
{

    if(koszt+cost[l]>=minkoszt) //przerwanie rekurencju gdy wiemy ze nie ma lepszego wyniku
        return ;
    else
    {
        estetyka+=est[l];
        koszt+=cost[l];
    }
    if(estetyka==0&&koszt<minkoszt) //zamiana wartosci jezeli znalezione lepsze rozwiazanie
    {
        minkoszt=koszt;
        return ;
    }
     for(int i=l+1;i<n;i++)
        sprawdzZraszacze(koszt,estetyka,est,cost,i,n);//rekurencyjne wywolanie rozgalenzien nizszego poziomu drzewa(bez powtozen juz uzytych na tej konkretnej scieszcze)
}
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int t;
    std::cin>>t; //t testow

    for(int i=0;i<t;i++)
    {
        minkoszt=1000001; //resetowanie zmiennej globalnej
        int n;
        std::cin>>n; //n zraszaczy
        int *cost=new int [n]; // dwie tablice sa szybsze niz jedna bo nie trace czasu w petli rekurencyjnej na dodawanie i+1
        int *est=new int [n];
        for(int j=0;j<n;j++)
           std::cin>>est[j]>>cost[j];
        for(int j=0;j<n;j++) //(kazde rozgalenzienie w prawo ma n-1 stopni mniej by nie duplikowac zraszaczy)
           sprawdzZraszacze(0,0,est,cost,j,n); //wybrane zraszacze nie moga byc zduplikowane wiec wywoluje funkcje za kazdym razem dla n-1 zraszaczy
        if(minkoszt==1000001)
            std::cout<<"NIE"<<"\n";  //wyswietlienie znalezionego wyniku
        else
            std::cout<<minkoszt<<"\n";
        delete [] cost;
        delete [] est;
    }
}
