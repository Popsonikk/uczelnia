#include <iostream>
#include <vector>

struct Graf{
    std::vector<int> neibour;
    std::vector<int> wag;
    bool visited=false;
};
struct Edge{
    int start;
    int end;
    int wag;


};

void popQueueEl(std::vector<std::pair<int,int>> &pq)
{
    std::swap(pq[0],pq[pq.size()-1]); //zamiana pierwszego i ostaniego elementu
    pq.pop_back(); //aby usunąć korzeń bez psucia kopca
    int pqSize=pq.size();
    for(int i=0,a1=0,a2=0;(2*i+1)<pqSize;) //przesianie w dól nowego korzenia
    {
        a1=pq[2*i+1].first; //piorytet pierwszego dziecka
        if((2*i+2)<pqSize) //sprawdzenie czy rodzic posiada prawe dziecko
            a2=pq[2*i+2].first;
        else
            a2=2147483647; //jeżeli prawe dziecko nie istnieje ustawiam parametr na intMax

        if(a1<=a2&&a1<pq[i].first) //zamiana z mniejszym dzieckiem
        {
            std::swap(pq[i],pq[2*i+1]);
            i=2*i+1;
        }
        else if( a2<a1&&a2<pq[i].first )
        {
            std::swap(pq[i],pq[2*i+2]);
            i=2*i+2;
        }
        else
            break;
    }
}
void pushQueueEl(std::vector<std::pair<int,int>> &pq,std::pair<int,int>elem)
{

    pq.push_back(elem);
    int dadIndex;
    for(int i=pq.size()-1;i>0;)
    {
        if(i%2==0)
            dadIndex=i/2-1;
        else
           dadIndex=i/2;
        if(pq[dadIndex].first>pq[i].first)
        {
            std::swap(pq[dadIndex],pq[i]);
            i=dadIndex;
        }
        else
            return;
    }


}
void dikstra(Graf * graf,int * droga,int n,int start)
{
    std::vector<std::pair<int,int>> pq;//kolejka sortuje po double <droga,wierzcholek>
    pq.push_back(std::make_pair(0,start)); //wrzucam wierzchołek startowy do kolejki
    int index,wag,visitedV=0; //zmienne do pomocy w diksrze
    Graf pom;

    while(!pq.empty()&&visitedV<n)
    {
        index=pq.front().second; //wierzcholek to druga liczba z pary
        pom=graf[index];
        popQueueEl(pq);//usuniecie pary z kolejki
        if(!graf[index].visited)
        {
            visitedV++;
            graf[index].visited=true; //deklaracja petli idziemy po iteratorze listy
            for(int j=0;j<pom.neibour.size();j++)
            {
                if(droga[pom.neibour[j]]>droga[index]+pom.wag[j]&&!pom.visited)
                {
                    droga[pom.neibour[j]]=droga[index]+pom.wag[j];
                    pushQueueEl(pq,std::make_pair(droga[pom.neibour[j]],pom.neibour[j]));
                }
            }
        }
    }
    for(int i=0;i<n;i++)
        std::cout<<i<<": "<<droga[i]<<'\n';

}
void bellmanFord(Edge * edges,int * droga,int n,int m,int start)
{
    bool czyZmienione=false;


    for(int i=0;i<n-1;i++)
    {
        czyZmienione=false;

        for(int j=0;j<m;j++)
        {
            if(droga[edges[j].start]+edges[j].wag<droga[edges[j].end]&&droga[edges[j].start]!=2147483647)
            {
               droga[edges[j].end]=droga[edges[j].start]+edges[j].wag;
               czyZmienione=true;
            }
        }
        if(!czyZmienione)
        {
            for(int j=0;j<m;j++)
            {
                if(droga[edges[j].start]+edges[j].wag<droga[edges[j].end]&&droga[edges[j].start]!=2147483647)
                {
                   std::cout<< "Graf zawiera ujemny cykl!";
                   return;

                }
            }
            break; // brak zmiany drogi oraz brak ujemnego cyklu;
        }


    }


        for(int i=0;i<n;i++)
            std::cout<<i<<": "<<droga[i]<<' ';
}
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int w,k;
    std::cin>>w>>k;
    bool flag=true;//flaga sprawdzający czy wczytano ujemną wagę
    Graf *graf= new Graf[w];
    int *droga= new int[w];
    Edge *edges=new Edge[k];
    for(int i=0;i<w;i++)
        droga[i]=2147483647;
    int a,b,c,start;
    for(int i=0;i<k;i++)
    {
        std::cin>>a>>b>>c; //a start , b koniec , c waga
        if(c<0)
            flag=false;
        graf[a].neibour.push_back(b);
        graf[a].wag.push_back(c);
        edges[i]={a,b,c};
    }
    std::cin>>start;
    droga[start]=0;
    if(flag)
        dikstra(graf,droga,w,start);
    else
        bellmanFord(edges,droga,w,k,start);

    delete [] graf;
    delete [] droga;
    delete [] edges;
}
