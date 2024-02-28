//Wej�cie:
//W pierwszej linii wej�cia pojawi� si� 3 liczby naturalne n, k oraz m, gdzie n jest liczb� propozycji Mieszka, k liczb� drzwi, a m liczb� propozycji, kt�re Ula b�dzie bra�a pod uwag�.
//W kolejnych n liniach pojawi� si� opisy ofert sk�adaj�ce si� k znak�w, gdzie 'o' oznacza drzwi bez szyfru, a 'X' oznacza drzwi z szyfrem. Zak�adamy, �e od lewej znajduj� si� drzwi po�o�one najbli�ej sejfu.
//Wyj�cie:
//Na wyj�ciu program ma wypisa� m pierwszych propozycji uporz�dkowanych od najlepszej.
#include <iostream>
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int m,n,k; //n-mieszko, k-drzwi, m-rozwiazania
    std::cin>>n>>k>>m;
    char** arr=new char*[n];
    char** pom=new char*[n]; //tablica pomocnicza na wskazniki liczb binarnych
    for(int i=0;i<n;i++)
    {
        arr[i]=new char [k]; //(X=1,o=0)zapis binarny
        for(int j=0;j<k;j++)
            std::cin>>arr[i][j];
    }
    int countO=-1,countX=n-1; //sortowanie przez zliczanie zaczynamy od dolu wiec x=n-1
    //funkcja liczaca
    for(int l=k-1;l>=0;l--) //sortowanie od najmniej znaczacego bitu
    {
        countO=-1;countX=n-1;//resetujemy zmmienne zliczajace o=-1 bo indeksy od zera
        for(int i=0;i<n;i++)
        {
            if(arr[i][l]=='o')
                countO++; //zliczamy tylko 0 bo idziemy do konca wiec xpointer zawsze na koncu
        }

        for(int i=n-1;i>=0;i--) //przegladamy tablice od konca
        {

            if(arr[i][l]=='X')
            {
                pom[countX]=arr[i]; //wrzucamy wskazniki liczb do pomocniczej arr
                countX--;
            }
            else
            {

                pom[countO]=arr[i];
                countO--;
            }
        }
        for(int i=0;i<n;i++)
            arr[i]=pom[i];//i przepinamy spowrotem do glownej tablicy
    }
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<k;j++)
        {
            std::cout<<arr[n-i-1][j]; //wyswietlamy wynik
        }
        std::cout<<"\n";
    }

    for(int i=0;i<n;i++)
   {
        delete[]arr[i]; //usuwamy pamiec dynamiczna
   }
    delete []arr;
    delete []pom;


}
