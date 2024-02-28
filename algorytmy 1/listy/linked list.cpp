#include <iostream>
#include <string>
class Flower{
public:
    std::string name;
    int counts;

};
template <class T>
class List
{

};

void insertEnd( Flower** start, int value,std::string name) //dla listy roslin
{
    if (*start == nullptr)
    {
        Flower* new_node = new Flower;
        new_node->counts = value;
        new_node->name = name;
        new_node->next = new_node->prev = new_node;
        *start = new_node;
    }
    Flower *last = (*start)->prev;
    Flower* new_node = new Flower;
    new_node->counts = value;
    new_node->name = name;
    new_node->next = *start;
    (*start)->prev = new_node;
    new_node->prev = last;
    last->next = new_node;
}
void deleteFlower(Flower** start, Flower *del)
{

    Flower *curr = del, *prev_1 = del->prev;
    if (curr->next == *start ) { //jeden element
        (*start) = nullptr;
        delete curr;
    }
    if (curr == *start) { //wiecej niz jeden
        prev_1 = (*start)->prev;
        *start = (*start)->next;
        prev_1->next = *start;
        (*start)->prev = prev_1;
        delete curr;
    }
    else if (curr->next == *start) {
        prev_1->next = *start;
        (*start)->prev = prev_1;
        delete curr;
    }
    else {
        Flower* temp = curr->next;
        prev_1->next = temp;
        temp->prev = prev_1;
        delete curr;
    }
}
void showFlower(Flower* flower)
{
    Flower *pom=flower;
    while(pom->next!=flower)
    {
        std::cout<<pom->name<<' '<<pom->counts<<"\n";
        pom=pom->next;
    }

    std::cout<<pom->name<<' '<<pom->counts<<"\n";
}
class Gatunek{
public:
    Gatunek *next;
    Gatunek *prev;
    Flower* data;
    int sizes;
    int currpos;

};
void insertEnd( Gatunek** start, Flower *item,int sizes,int pos) //dla listy gatonkow
{
    if (*start == nullptr)
    {
        Gatunek* new_node = new Gatunek;
        new_node->data = item;
        new_node->sizes=sizes;
        new_node->currpos=pos;
        new_node->next = new_node->prev = new_node;
        *start = new_node;
    }
    Gatunek *last = (*start)->prev;
    Gatunek* new_node = new Gatunek;
    new_node->data = item;
    new_node->sizes=sizes;
    new_node->currpos=pos;
    new_node->next = *start;
    (*start)->prev = new_node;
    new_node->prev = last;
    last->next = new_node;
}
void deleteGatunek(Gatunek** start, Gatunek *key)
{
    Gatunek *curr = key, *prev_1 = key->prev;
    if (curr->next == *start && prev_1 == nullptr) { //jeden element
        (*start) = nullptr;
        delete curr;

    }
    if (curr == *start) { //wiecej niz jeden
        prev_1 = (*start)->prev;
        *start = (*start)->next;
        prev_1->next = *start;
        (*start)->prev = prev_1;
        delete curr;
    }
    else if (curr->next == *start) {
        prev_1->next = *start;
        (*start)->prev = prev_1;
        delete curr;
    }
    else {
        Gatunek* temp = curr->next;
        prev_1->next = temp;
        temp->prev = prev_1;
        delete curr;
    }
}
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);  //do sprawdzarki
    Gatunek *gatunekList=new Gatunek;
    gatunekList=nullptr;
    int gatuneksize,flowersize,rc=0;
    std::cin>>gatuneksize;
    std::string name;
    int n;
    Flower* currFlowers=nullptr;
     for(int i=0;i<gatuneksize;i++)
    {
        std::cin>>flowersize;//rozmiar podlisty
        Flower * flowers=new Flower; //podlista
        flowers=nullptr;
        for(int j=0;j<flowersize;j++)
        {
            std::cin>>name>>n;
            insertEnd(&flowers,n,name);
            if(j==0)
            {
                rc+=n;
                insertEnd(&currFlowers,n,name);

            }
        }
        insertEnd(&gatunekList,flowers,flowersize,0);
    }
    int rabatsize,signalsize;
     std::cin>>rabatsize;
    Flower *rabat=nullptr;
    for(int i=0;i<rabatsize;i++)
    {
        std::cin>>n;
        insertEnd(&rabat,n,"");
    }
    std::cin>>signalsize; //wczytanie sygnalow sterujacych
    signalsize*=2;
    int *signal= new int[signalsize];
    for(int i=0;i<signalsize;i+=2)
        std::cin>>signal[i]>>signal[i+1];





    delete[]signal;
}
