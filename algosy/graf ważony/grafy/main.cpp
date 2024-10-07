//Program wczytuje liczby naturalną X, która definiuje ilość giełd. Następnie algorytm powinien odczytać X wartości 0 lub 1,
//określające status posiadania BajtCointa kolejnych giełd. 0 jeśli giełda nie posiada w swojej ofercie BajtCoina i 1 w przeciwnym wypadku.
//Kolejno algorytm wczytuje liczbę naturalną N i N połączeń pomiędzy giełdami, czyli parę liczb A i B oraz dwie liczby rzeczywiste większe-równe zeru
// I i J. A i B to liczby odpowiadające giełdom, zaś I to wysokość prowizji podczas transferu przed powieleniem majątku przez Alojzego,
//a J po jego powieleniu. Następnie program wczytuję liczbę naturalną M, która określa numer naszej wiodącej giełdy kryptowalut.



//WYJŚCIE
//Na wyjściu algorytm powinien wyświetlić największą kwotę, jaką mógłby otrzymać Alojzy, przelewając pieniądze pomiędzy giełdami.
//Wynikiem powinna być liczba całkowita zaokrąglona w dół do liczby jedności.


#include <iostream>
#include <queue>
#include <list>

struct Graf{ //deklaruje strukture grafu mowi ona czy jest krypto i pokazuje sasiadow
    bool czykrypto;
    std::list<double> listaSasiadow;
    std::list<double> listaprowizji;
};
void Dikstra(Graf *graf,int start,int n,double *prowizje)
{
    std::priority_queue<std::pair<double,double>> pq;//kolejka sortuje po double <droga,wierzcholek>
    pq.push(std::make_pair(1,start)); //wrzycam wierzchołek startowy do kolejki
    bool *czyodwiedzony= new bool[n];
    for(int i=0;i<n;i++)
        czyodwiedzony[i]=false; //inicjalizacja tablic
    prowizje[start]=1;
    int wierzcholek,sasiad; //zmienne do pomocy w diksrze
    double prio;
    wierzcholek=graf[start].listaSasiadow.front();
    while(!pq.empty())
    {
        wierzcholek=pq.top().second; //wierzcholek to druga liczba z pary
        pq.pop();//usuniecie pary z kolejki
        if(!czyodwiedzony[wierzcholek])
        {
            czyodwiedzony[wierzcholek]=true; //deklaracja petli idziemy po iteratorze listy
            for(std::list<double>::iterator sas=graf[wierzcholek].listaSasiadow.begin(), pr=graf[wierzcholek].listaprowizji.begin();
                sas != graf[wierzcholek].listaSasiadow.end()&&pr!=graf[wierzcholek].listaprowizji.end(); ++sas,++pr)
            {
                sasiad=*sas; //przypisujemy wierzchilek i wage do zmiennych
                prio= *pr;
                if(prowizje[wierzcholek]*prio> prowizje[sasiad]&&!czyodwiedzony[sasiad]) //sprawdzamy czy mamy efektywniejsze przejscie jezeli sasiad jeszzce nieodwiedzony
                {
                    prowizje[sasiad]=prowizje[wierzcholek]*prio;
                    pq.push(std::make_pair(prowizje[sasiad],sasiad));
                }
            }
        }
    }
    delete [] czyodwiedzony;
}
int Dikstra(Graf *graf,int start,int n,int wiodonca)
{
    double wynik=0;
    std::priority_queue<std::pair<double,double>> pq;//kolejka sortuje po double <droga,wierzcholek>
    pq.push(std::make_pair(1,start)); //wrzycam wierzchołek startowy do kolejki
    bool *czyodwiedzony= new bool[n];
    double *prowizje=new double[n];
    for(int i=0;i<n;i++)
    {
        czyodwiedzony[i]=false; //inicjalizacja tablic
        prowizje[i]=0;
    }
    prowizje[start]=1;
    int wierzcholek,sasiad; //zmienne do pomocy w diksrze
    double prio;
    wierzcholek=graf[start].listaSasiadow.front();
    while(!pq.empty())
    {
        wierzcholek=pq.top().second; //wierzcholek to druga liczba z pary
        pq.pop();//usuniecie pary z kolejki
        if(!czyodwiedzony[wierzcholek])
        {
            czyodwiedzony[wierzcholek]=true; //deklaracja petli idziemy po iteratorze listy
            for(std::list<double>::iterator sas=graf[wierzcholek].listaSasiadow.begin(), pr=graf[wierzcholek].listaprowizji.begin();
                sas != graf[wierzcholek].listaSasiadow.end()&&pr!=graf[wierzcholek].listaprowizji.end(); ++sas,++pr)
            {
                //mozna lepiej
                sasiad=*sas; //przypisujemy wierzchilek i wage do zmiennych
                prio= *pr;
                if(prowizje[wierzcholek]*prio> prowizje[sasiad]&&!czyodwiedzony[sasiad]) //sprawdzamy czy mamy efektywniejsze przejscie jezeli sasiad jeszzce nieodwiedzony
                {
                    prowizje[sasiad]=prowizje[wierzcholek]*prio;
                    pq.push(std::make_pair(prowizje[sasiad],sasiad));
                }
            }
        }
    }
    wynik=120000*prowizje[wiodonca];//120000 bo 1000000 mamy na poczatek i gielda zwieksza wartosc o 20%
    delete[]czyodwiedzony;
    delete[]prowizje;
    return wynik;
}
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int n;
    std::cin>>n; //deklaruje iloœæ gie³d
    Graf *graf =new Graf[n];
    double *prowizjeDoKrypto=new double[n];//tworze tablicze przechowujacy koszt przejsc od gieldy wiodoncej
    for (int i=0;i<n;i++)
    {
        std::cin>>graf[i].czykrypto;
        prowizjeDoKrypto[i]=0; //inicjalizuje tablice odleglosci
    }
    int m;
    std::cin>>m; //deklaruje ilosc polaczen miedzy gieldami
    //mozna na int
    double a,b;//gieldy miedzy ktorymi jest polaczenie
    double x1,x2;
    for(int i=0;i<m;i++)
    {
        std::cin>>a>>b>>x1>>x2;//x1 x2 prowizje miedzy gieldami
        x1=1-x1; //zmiana notacji na ile % wartosci poczatkowej zostanie
        x2=1-x2;
        graf[(int)a].listaSasiadow.push_back(b);
        graf[(int)a].listaprowizji.push_back(x1);//lista przechowuje krawedz i koszt naprzemienine
        graf[(int)b].listaSasiadow.push_back(a);
        graf[(int)b].listaprowizji.push_back(x2);

    }
    int start;
    std::cin>>start;//numer gielgy startowej
    Dikstra(graf,start,n,prowizjeDoKrypto); //droga od wiodoncej do każdej w strukturze
    double maxi=0,koszt=0;
    for(int i=0;i<n;i++)
    {
        if(graf[i].czykrypto&&i!=start) //trasa od gieldy krypto do wiodoncej powtarzane dla kazdej krypto
        {
            koszt=Dikstra(graf,i,n,start)*prowizjeDoKrypto[i];
            if(koszt>maxi)
                maxi=koszt;
        }
    }
    std::cout<<(int)maxi;
    delete []graf;
    delete[] prowizjeDoKrypto;
}
