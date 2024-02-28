#include <iostream>
int minkoszt=2147483647; //max_int
struct Drzewo{          //drzewo rozwi¹zan
   Drzewo * ojciec;
   Drzewo * syn;
   Drzewo * brat ;
   Drzewo * lastbrat; //chce pominac bieganie przez wszyatkich synow (zawsze dodaje na skrajnym prawym miejscu) wiec pierwszy syn ma wskaznik na swojego ostatniego brata
   //Drzewo * prevbrat;
   int estetyka; //inty z zadania
   int koszt;

};

void dodaj(Drzewo* start,int cena,int wyglad)
{
    int totalkoszt,totalestetyka; //do liscia wpisuje zsumowana wartosc wszystkich wybranych zraszaczy
    if(start->syn!=nullptr)
    {
        start=start->syn;
        if(start->brat!=nullptr)
            start=start->lastbrat; //pomijam przechodzenie do skrajnego syna
        totalkoszt=start->ojciec->koszt+cena;
        totalestetyka=start->ojciec->estetyka+wyglad;
        if(totalestetyka==0) //rozwiazanie poprawne gdy estetyka 0 wiec jezeli estetyka 0 to nie zapisuje liscia w drzewie bo na tej droze nie znajde tanszego rozwiazania
        {
            if(totalkoszt<minkoszt)
                minkoszt=totalkoszt;
            return;
        }
        else if(totalkoszt<minkoszt) //estetyka nie jest 0 czyli to nie jest akceptowanie riozwiazanie wiec zapisuje lisc jezeli moge jeszcze znalesc na tej drodze tansze rozwiazanie
        {
            Drzewo *drzewo=new Drzewo;
            drzewo->brat=nullptr;
            drzewo->estetyka=totalestetyka;
            drzewo->koszt=totalkoszt;
            drzewo->ojciec=start->ojciec;
            drzewo->syn=nullptr;
            drzewo->ojciec->syn->lastbrat=drzewo;
           // drzewo->prevbrat=start;
            start->brat=drzewo;
            return;
        }
    }
    else //ojcciec nie mial syna wiec to co wyzej ale lisc jest pierwszym synem
    {
        totalkoszt=start->koszt+cena;
        totalestetyka=start->estetyka+wyglad;
        if(totalestetyka==0)
        {
            if(totalkoszt<minkoszt)
                minkoszt=totalkoszt;
            return;
        }
        else if(totalkoszt<minkoszt)
        {
            Drzewo *drzewo=new Drzewo;
            drzewo->brat=nullptr;
           // drzewo->prevbrat=nullptr;
            drzewo->estetyka=totalestetyka;
            drzewo->koszt=totalkoszt;
            drzewo->ojciec=start;
            drzewo->syn=nullptr;
            start->syn=drzewo;
            return;
        }
    }
}
void preorder(Drzewo* drzewo,int cena,int wyglad) //za kazdym razem jak wpisuje dana po programu traktuje drzewo preorderem gdym do kazdej mozliwej scie¿ki trzeba dodac te dana
{

   // if(!(drzewo->brat==nullptr&&drzewo->syn==nullptr)) //dodajac przez preorder narazamy sie na zapetlenie, zawsze dodamy lisc jezeli obecnie wybrany ma brata, bo zosta³ dodany poprzednim wywo³aniem preorderu


    if(drzewo->syn!=nullptr)
        preorder(drzewo->syn,cena,wyglad);
    dodaj(drzewo,cena,wyglad);

    if(drzewo->brat!=nullptr)
        preorder(drzewo->brat,cena,wyglad);

}
void postorder(Drzewo *drzewo) //testowy postorder do wyswietlenia drzewa
{
    std::cout<< drzewo->estetyka<<"\n";
    if(drzewo->syn!=nullptr)
        postorder(drzewo->syn);
    if(drzewo->brat!=nullptr)
        postorder(drzewo->brat);
}
void deletetree(Drzewo *drzewo) //destruktor drzewa
{
     if(drzewo->syn!=nullptr)
        deletetree(drzewo->syn);
    if(drzewo->brat!=nullptr)
        deletetree(drzewo->brat);
    delete drzewo;
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
        minkoszt=2147483647; //minkoszt zadeklarowalem globalnie wiec reset wartosci na max int na poczatku kazdego testu
        Drzewo *poczotek=new Drzewo;
        poczotek->ojciec=nullptr; //inicjalizacja drzewa rozwiazan
        poczotek->syn=nullptr;
        poczotek->brat=nullptr;
        poczotek->lastbrat=nullptr;
        poczotek->estetyka=0;
        poczotek->koszt=0;
        int n;
        std::cin>>n; //n zraszaczy
        for(int j=0;j<n;j++)
        {
            int est,cost;
            std::cin>>est>>cost;
            if(j==0) //na pocz¹tku drzewo jest puste wiec musze recznie dodac pierwszy lisc by obejsc ifa w preorderze
               dodaj(poczotek,cost,est);
            else if(cost<minkoszt) //jezeli mamy juz jakis minkoszt i obecnie wczytany jest od niego wiekszy z wejscia pomijamy ten zraczasz
                preorder(poczotek,cost,est);
        }
        if(minkoszt==2147483647)
            std::cout<<"NIE";  //wyswietlienie znalezionego wyniku
        else
            std::cout<<minkoszt;
        std::cout<<"\n";
        deletetree(poczotek);


    }

}
