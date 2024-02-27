#include <iostream>
#include <vector>
#include <list>
#include <algorithm>
#include <cmath>

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
struct Node{
    std::pair<int,int> value;
    int degree;
    Node* parent;
    Node* son;
    Node* next;
    Node* prev;
};
struct Fib
{
    Node* minNode=nullptr;
    std::list<Node*> roots;
    int nodeCount=0;

};
void push_back(Fib* fib,std::pair<int,int> value)
{
    Node * node= new Node{value,0,nullptr,nullptr,nullptr,nullptr};
    fib->roots.push_back(node);
    if(fib->minNode==nullptr||fib->minNode->value.first > node->value.first)
        fib->minNode=node;
    fib->nodeCount++;
}
Node * top(Fib * fib)
{
    return fib->minNode;
}
Node* link(Node * n1, Node * n2)
{
    Node* temp;
    if(n1->value.first>n2->value.first)
    {
        temp= n2->son;
        n2->degree++;
        n2->son=n1;
        n1->parent=n2;
        if(temp!=nullptr)
        {
            n1->next=temp;
            n1->next->prev=n1;
        }
        return n2;
    }
    else
    {
        temp= n1->son;
        n1->degree++;
        n1->son=n2;
        n2->parent=n1;
        if(temp!=nullptr)
        {
            n2->next=temp;
            n2->next->prev=n2;
        }
        return n1;

    }
}
void consolidate(Fib *fib)
{
    int maxDegree = int(std::log2(fib->nodeCount)+1);
    std::vector<Node *> degreeTable(maxDegree, nullptr);

    for (Node *current : fib->roots)
    {
        int degree = current->degree;
        while (degreeTable[degree] != nullptr)
        {
           Node *other = degreeTable[degree];
           current = link(current, other);
           degreeTable[degree] = nullptr;
           degree++;
        }
        degreeTable[degree] = current;


   }
    fib->roots.clear();
    for (Node *node : degreeTable)
    {
        if(node!=nullptr)
        {
            fib->roots.push_back(node);
            if(fib->minNode==nullptr||fib->minNode->value.first > node->value.first)
                fib->minNode=node;
        }
    }
}
void pop(Fib * fib)
{
    Node * temp=fib->minNode;
    temp=temp->son;

    while(temp!=nullptr)
    {
        temp->parent=nullptr;
        temp->prev=nullptr;
        fib->roots.push_back(temp);
        temp=temp->next;
        if(temp!=nullptr)
            temp->prev->next=nullptr;

    }
    fib->roots.remove(fib->minNode);
    delete fib->minNode;
    fib->minNode=nullptr;
    fib->nodeCount--;
    if(!fib->roots.empty())
         consolidate(fib);



}

void dikstra(Graf * graf,int * droga,int n,int start)
{

    Fib *fib = new Fib;//kolejka sortuje po double <droga,wierzcholek>
    push_back(fib,std::make_pair(0,start)); //wrzucam wierzchołek startowy do kolejki

    int index,visitedV=0; //zmienne do pomocy w diksrze
    Graf pom;
    while(visitedV<n&&!fib->roots.empty())
    {
        index=top(fib)->value.second; //wierzcholek to druga liczba z pary
        pop(fib);
        pom=graf[index];
        if(!graf[index].visited)
        {
            visitedV++;
            graf[index].visited=true; //deklaracja petli idziemy po iteratorze listy
            for(int j=0;j<pom.neibour.size();j++)
            {
                if(droga[pom.neibour[j]]>droga[index]+pom.wag[j]&&!pom.visited)
                {
                    droga[pom.neibour[j]]=droga[index]+pom.wag[j];
                    push_back(fib,std::make_pair(droga[pom.neibour[j]],pom.neibour[j]));
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
