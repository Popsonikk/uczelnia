#include <iostream>
#include <queue>
#include <list>

struct Graf{ //deklaruje strukture grafu mowi ona czy jest krypto i pokazuje sasiadow
    bool czykrypto;
    std::list<double> listaSasiadow;
    std::list<double> listaprowizji;
};

int main()
{
    /*std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int n;
    std::cin>>n; //deklaruje iloœæ gie³d
    Graf *graf =new Graf[n];

    for (int i=0;i<n;i++)
        std::cin>>graf[i].czykrypto;

    int m;
    std::cin>>m; //deklaruje ilosc polaczen miedzy gieldami
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

    std::priority_queue<std::pair<double,double>> pq;//kolejka sortuje po double <droga,wierzcholek>
     pq.push(std::make_pair(0,start));
     double *prowizje= new double[n]; //tablice pomocnicze do dikstry
     bool *czyodwiedzony= new bool[n];
     for(int i=0;i<n;i++)
     {
         czyodwiedzony[i]=false;
         prowizje[i]=0;
     }
     prowizje[start]=1;
     int wierzcholek,sasiad;
     double prio;
     wierzcholek=graf[start].listaSasiadow.front();
     while(!pq.empty())
     {
        wierzcholek=pq.top().second;
        pq.pop();//usuniecie pary z kolejki
        if(!czyodwiedzony[wierzcholek])
        {
            czyodwiedzony[wierzcholek]=true; //deklaracja petli idziemy po iteratorze listy
            for(std::list<double>::iterator sas=graf[wierzcholek].listaSasiadow.begin(), pr=graf[wierzcholek].listaprowizji.begin();
                sas != graf[wierzcholek].listaSasiadow.end()&&pr!=graf[wierzcholek].listaprowizji.end(); ++sas,++pr)
            {
                sasiad=*sas;
                prio= *pr;
                if(prowizje[wierzcholek]*prio> prowizje[sasiad])
                {
                    prowizje[sasiad]=prowizje[wierzcholek]*prio;
                    pq.push(std::make_pair(prowizje[sasiad],sasiad));
                }

            }

        }

     }






    delete []graf;*/


}
