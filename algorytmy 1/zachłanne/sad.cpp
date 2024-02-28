#include <iostream>
#include <algorithm>

int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int rzad,kolumna; //rozmiary sadu
    std::cin>>rzad>>kolumna;
    int n,m;
    int **sad=new int *[2]; //przechowuje poprzednia i obecna linie
    sad[0]=new int [kolumna];
    sad[1]=new int [kolumna];
    for(int i=0;i<rzad;i++)
    {
        if(i==0) //tylko 1 rzad
        {
            for(int j=0;j<kolumna;j++)
                std::cin>>sad[0][j];
            i=1;
        }
        if(i==rzad) //tylko 1 rzad wiec przerywam algorytm
            break;
        for(int j=0;j<kolumna;j++)
        {
            std::cin>>n;
            if(kolumna==1) //rozpatruje sasiadow, moge pojsc tylko do 3 sasiadujacych
                m=sad[0][0]; //1 kolumna nie ma co tlumaczyc
            else if(kolumna==2) //dwie kolumny wybieram wiekszego
                m=std::max(sad[0][0],sad[0][1]);
            else //3 lub wiecej
            {
                if(j==0)
                    m=std::max(sad[0][0],sad[0][1]);
                else if(j==kolumna-1)                       //na skraju tylko 2 sasiadow
                    m=std::max(sad[0][kolumna-2],sad[0][kolumna-1]);
                else
                    m=std::max(sad[0][j-1],std::max(sad[0][j],sad[0][j+1])); //w srodku 3 sasiadow zawsze wybieram najwiekszego
            }
            sad[1][j]=m+n; //wynik to wczytana liczba oraz najwiekszy sasiad
        }
        for(int j=0;j<kolumna;j++)
            sad[0][j]=sad[1][j]; //przepisuje linie by poprzednia linia zawsze byla w sad[0]

    }
    int ind=0,maxjab=sad[0][0];
    for(int i=1;i<kolumna;i++)
    {
        if(sad[0][i]>maxjab)    //szukanie najwiekszej wartosci i jej pozycji
        {
            maxjab=sad[0][i];
            ind=i;
        }
    }
    std::cout<<ind<<' '<<maxjab;
    delete []sad[0];
    delete []sad[1];
    delete []sad;
}
