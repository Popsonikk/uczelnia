//WEJŚCIE
//Algorytm na wejściu otrzymuje liczbę naturalną N, która mówi o ilości operacji naszego algorytmu. Operacje dzielimy na A oraz S.
//A - jest to operacja dodania tatuażysty do naszej listy artystów. W tej operacji algorytm powinien wczytać sekwencję wartości X Y Z S, gdzie X jest liczbą rzeczywistą i
//Y to liczba naturalne określające parametry potrzebne do wyliczenia atrakcyjności oferty danego tatuażysty, Z to jego koszt, a S to jednowyrazowy pseudonim tatuażysty.
//S - jest to operacja wybierania tatuażysty. W tej operacji algorytm powinien wczytać również wartości, liczbę naturalną B oraz liczbę rzeczywistą F.
//B to ilość pieniędzy, jakie dokładnie chce wydać nasz student, zaś F to wartość współczynnik atrakcyjności, jaką co najmniej musi posiadać artysta, aby Alojzy był zadowolony z rezultatu procesu tatuowania.

//WYJŚCIE
//Dla każdej operacji S algorytm powinien wyświetlić odpowiedź;
//- jeśli znalazł artystę, o cenie równej ilości pieniędzy, które posiada Alojzy oraz spełniającego wymagania ‘atrakcyjności’, program powinien wyświetlić pseudonim artysty i usunąć go z listy,
// w przypadku gdy jest kilku artystów o tej samej cenie tatuażu i oboje spełniają wymagania ‘atrakcyjności’ należy wybrać tego, który ma ten współczynnik większy, gdy wartość współczynnika dla kilku artystów jest taka sama decyduje to, który artysta później zadeklarował swoją obecność,
//- jeśli nie znalazł artysty spełniającego wymagania, program powinien wyświetlić ‘-’.

#include <iostream>
#include <string>
#include <cmath>
#include <queue>
using namespace std;
bool flag=false;
queue<string> lista; //wyswietli tatuazystów po skonczonym procesie
struct BSTratio
{
    float ocena=-1;
    BSTratio *lewy=nullptr;
    BSTratio *prawy=nullptr;
    BSTratio *ojciec=nullptr;
    string nickname="";
};
struct BSTgold
{
    int gold=-1;
    BSTgold *lewy=nullptr;
    BSTgold *prawy=nullptr;
    BSTgold *ojciec=nullptr;
    BSTratio *ratios=nullptr;
};
void addratio(BSTratio **korzen,float oceny,string nick)
{
    BSTratio *pom=*korzen;
    if (pom->nickname==""&&pom->lewy==nullptr&&pom->prawy==nullptr) //zero elementow
    {
        pom->ocena=oceny;
        pom->nickname=nick;
        return;
    }
    while(1)
    {
        if(pom->ocena<=oceny)
        {
            if(pom->prawy==nullptr)
            {
                BSTratio *drzewo=new BSTratio;
                pom->prawy=drzewo;
                drzewo->ocena=oceny;
                drzewo->nickname=nick;
                drzewo->ojciec=pom;
                return;
            }
            else
                pom=pom->prawy;
        }
        else if(pom->ocena>oceny)
        {
            if(pom->lewy==nullptr)
            {
                BSTratio *drzewo=new BSTratio;
                pom->lewy=drzewo;
                drzewo->ocena=oceny;
                drzewo->nickname=nick;
                drzewo->ojciec=pom;
                return;
            }
            else
                pom=pom->lewy;
        }
    }
}
void addGold(int cena,BSTgold **korzen,float oceny,string nick)
{
    BSTgold *pom= *korzen;
    if (pom->lewy==nullptr&&pom->prawy==nullptr&&pom->ratios==nullptr)//zero elementow
    {
        pom->gold=cena;
        pom->ratios=new BSTratio;
        addratio(&(pom->ratios),oceny,nick);
        return;
    }
    while(1)
    {
        if(pom->gold==cena)
        {
            addratio(&(pom->ratios),oceny,nick);
            return;
        }
        else if(pom->gold<cena)
        {
            if(pom->prawy==nullptr)
            {
                BSTgold *drzewo=new BSTgold;
                pom->prawy=drzewo;
                drzewo->gold=cena;
                drzewo->ojciec=pom;
                drzewo->ratios=new BSTratio;
                addratio(&(drzewo->ratios),oceny,nick);
                return;
            }
            else
                pom=pom->prawy;
        }
        else if(pom->gold>cena)
        {
            if(pom->lewy==nullptr)
            {
                BSTgold *drzewo=new BSTgold;
                pom->lewy=drzewo;
                drzewo->gold=cena;
                drzewo->ojciec=pom;
                drzewo->ratios=new BSTratio;
                addratio(&(drzewo->ratios),oceny,nick);
                return;
            }
            else
                pom=pom->lewy;
        }
    }
}
void deleteGold(BSTgold * node)
{
    if(node->ojciec==nullptr&&node->lewy==nullptr&&node->prawy==nullptr)//jeden element
    {

        node->ratios=nullptr;
        node->gold=-1;
        return;
    }
    else if(node->ojciec!=nullptr&&node->lewy==nullptr&&node->prawy==nullptr) //nie jestem korzeniem i nie mam dzieci
    {
        if(node->gold>node->ojciec->gold)//jestem prawym synem
        {
            node->ojciec->prawy=nullptr;
            delete node;
            return;
        }
        else if(node->gold<node->ojciec->gold) //jestem lewym synem
        {
            node->ojciec->lewy=nullptr;
            delete node;
            return;
        }
    }
    else if(node->lewy!=nullptr&&node->prawy==nullptr) //mam lewego syna
    {
        BSTgold *pom= node->lewy; //przepisuje cala zawartosc(z polaczeniami) pom do node i usuwam pom
        node->gold=pom->gold;       //w ten sposob rozpatruje takze sytuacje gdy warune wystapi w korzeniu
        node->lewy=pom->lewy;
        node->prawy=pom->prawy;
        node->ratios=pom->ratios;
        if(pom->lewy!=nullptr) //zmieniam ojcow dzieci jezeli takie sa
            pom->lewy->ojciec=node;
        if(pom->prawy!=nullptr)
            pom->prawy->ojciec=node;
        delete pom;
        return;
    }
    else if(node->lewy==nullptr&&node->prawy!=nullptr) //mam prawego syna
    {
        BSTgold *pom= node->prawy; //przepisuje cala zawartosc(z polaczeniami) pom do node i usuwam pom
        node->gold=pom->gold;       //w ten sposob rozpatruje takze sytuacje gdy warune wystapi w korzeniu
        node->lewy=pom->lewy;
        node->prawy=pom->prawy;
        node->ratios=pom->ratios;
        if(pom->lewy!=nullptr) //zmieniam ojcow dzieci jezeli takie sa
            pom->lewy->ojciec=node;
        if(pom->prawy!=nullptr)
            pom->prawy->ojciec=node;
        delete pom;
        return;
    }
    else if(node->lewy!=nullptr&&node->prawy!=nullptr)//mam dwojke dzieci szukam na zmiane nastepnika i poprzednika
    {
        if(flag) //sterowanie na zmiane poprzednikiem i nastepnikiem
        {
            BSTgold *pom=node; //szukam poprzednika
            pom=pom->lewy;
            if(pom->prawy==nullptr)//lewy syn nie ma zadnego prawego dziecka
            {
                node->gold=pom->gold;
                node->ratios=pom->ratios; //przepisujemy wartosci poprzednika do node
                if(pom->lewy==nullptr)//lewy syn nie ma zadnych dzieci
                {
                    node->lewy=nullptr;
                    delete pom;
                    return;
                }
                else //lewy syn ma kolejne lewe dziecko
                {
                    pom->lewy->ojciec=node;
                    node->lewy=pom->lewy;
                    delete pom;
                    return;
                }
            }
            else //lewy syn ma prawe dzieci
            {
                while(pom->prawy!=nullptr)
                    pom=pom->prawy;
                node->gold=pom->gold;
                node->ratios=pom->ratios; //przepisujemy wartosci poprzednika do node
                if(pom->lewy==nullptr)//skrajnie prawy nie ma zadnych dzieci
                {
                    pom->ojciec->prawy=nullptr;
                    delete pom;
                    return;
                }
                else //skrajnie prawy ma kolejne lewe dziecko
                {
                    pom->lewy->ojciec=pom->ojciec;
                    pom->ojciec->prawy=pom->lewy;
                    delete pom;
                    return;
                }

            }

        }
        else
        {
            BSTgold *pom=node; //szukam nastepnika
            pom=pom->prawy;
            if(pom->lewy==nullptr)//prawy syn nie ma zadnego lewego dziecka
            {
                node->gold=pom->gold;
                node->ratios=pom->ratios; //przepisujemy wartosci poprzednika do node
                if(pom->prawy==nullptr)//prawy syn nie ma zadnych dzieci
                {
                    node->prawy=nullptr;
                    delete pom;
                    return;
                }
                else //prawy syn ma kolejne prawe dziecko
                {
                    pom->prawy->ojciec=node;
                    node->prawy=pom->prawy;
                    delete pom;
                    return;
                }
            }
            else //prawy syn ma lewe dzieci
            {
                while(pom->lewy!=nullptr)
                    pom=pom->lewy;
                node->gold=pom->gold;
                node->ratios=pom->ratios; //przepisujemy wartosci poprzednika do node
                if(pom->prawy==nullptr)//skrajnie lewy nie ma zadnych dzieci
                {
                    pom->ojciec->lewy=nullptr;
                    delete pom;
                    return;
                }
                else //skrajnie lewy ma kolejne prawe dziecko
                {
                    pom->prawy->ojciec=pom->ojciec;
                    pom->ojciec->lewy=pom->prawy;
                    delete pom;
                    return;
                }

            }
        }
    }

}
void deleteRatio(BSTratio *node,BSTgold * goldNode) //usuwam zawsze skrajnie prawy element (czyli zawsze prawy to null)
{
    if(node->ojciec==nullptr&&node->lewy==nullptr&&node->prawy==nullptr)//jeden element
    {
        deleteGold(goldNode);
        delete node;
        return;
    }
    else if(node->ojciec!=nullptr&&node->lewy==nullptr&&node->prawy==nullptr) //jestesmy w skrajnie prawnym koncu drzewa bez dalszych dzieci
    {
        node->ojciec->prawy=nullptr;
        delete node;
        return;
    }
    else if(node->ojciec!=nullptr&&node->lewy!=nullptr&&node->prawy==nullptr) //jestesmy w skrajnie prawnym koncu drzewa z lewym poddrzewem
    {
        node->ojciec->prawy=node->lewy;
        node->lewy->ojciec=node->ojciec;
        delete node;
        return;
    }
    else if(node->ojciec==nullptr&&node->lewy!=nullptr&&node->prawy==nullptr) //korzen jest skrajnie prawym elementem oraz ma lewe podrzewo
    {
        BSTratio *pom=node; //szukamy poprzednika czyli skrajnie prawy lewego syna
        pom=pom->lewy;
        if(pom->prawy==nullptr)//lewy syn nie ma zadnego prawego dziecka
        {
            node->ocena=pom->ocena;
            node->nickname=pom->nickname; //przepisujemy wartosci poprzednika do korzenia
            if(pom->lewy==nullptr)//lewy syn nie ma zadnych dzieci
            {
                node->lewy=nullptr;
                delete pom;
                return;
            }
            else //lewy syn ma kolejne lewe dziecko
            {
                pom->lewy->ojciec=node;
                node->lewy=pom->lewy;
                delete pom;
                return;
            }
        }
        else //lewy syn ma prawe dzieci
        {
            while(pom->prawy!=nullptr)
                pom=pom->prawy;
            node->ocena=pom->ocena;
            node->nickname=pom->nickname; //przepisujemy wartosci poprzednika do korzenia
            if(pom->lewy==nullptr)//skrajnie prawy nie ma zadnych dzieci
            {
                pom->ojciec->prawy=nullptr;
                delete pom;
                return;
            }
            else //skrajnie prawy ma kolejne lewe dziecko
            {
                pom->lewy->ojciec=pom->ojciec;
                pom->ojciec->prawy=pom->lewy;
                delete pom;
                return;
            }

        }
    }

}
void findRatio(float oceny,BSTratio **korzen,BSTgold * goldNode)
{
    BSTratio *pom=*korzen;
    while(pom->prawy!=nullptr)
        pom=pom->prawy;
    if(pom->ocena>=oceny)
    {
        lista.push(pom->nickname);
        deleteRatio(pom,goldNode);
    }
    else
        lista.push("-");
}
void findgold(int cena,float oceny,BSTgold **korzen)
{
    BSTgold *pom=*korzen;
    while(1)
    {
        if(pom->gold==cena)
        {
            findRatio(oceny,&(pom->ratios),pom);
            return;
        }
        else if(pom->gold<=cena)
        {
            if(pom->prawy==nullptr)
            {
                lista.push("-");
                return;
            }
            else
                pom=pom->prawy;
        }
        else if(pom->gold>cena)
        {
            if(pom->lewy==nullptr)
            {
               lista.push("-");
               return;
            }
            else
                pom=pom->lewy;
        }
    }
}
void postorder2(BSTratio *drzewo) //preorder ale nie zmieni³em nazwy
{
    std::cout<<"o "<< drzewo->ocena<<"\n";
    if(drzewo->lewy!=nullptr)
        postorder2(drzewo->lewy);

    if(drzewo->prawy!=nullptr)
        postorder2(drzewo->prawy);

}
void postorder(BSTgold *drzewo) //preorder ale nie zmieni³em nazwy
{
    std::cout<< drzewo->gold<<"\n";
    postorder2(drzewo->ratios);
    if(drzewo->lewy!=nullptr)
        postorder(drzewo->lewy);


    if(drzewo->prawy!=nullptr)
        postorder(drzewo->prawy);

}
int main()
{
   int n,cena;//liczba iteracji i cena
   char tryb;//okreslenie operacji (dodaj,wyszukaj)
   float srOcen,lczOcen; //zmienne do ratio
   string nick;
   cin>>n;
   BSTgold *korzen=new BSTgold;

   for(int i=0;i<n;i++)
   {
       cin>>tryb;
       if(tryb=='A')
       {
           cin>>srOcen>>lczOcen>>cena>>nick;
           float srednia=srOcen/5*floor(lczOcen/1000);
           addGold(cena,&korzen,srednia,nick);
       }
       else if(tryb=='S')
       {
           cin>>cena>>srOcen;//srOcen tutaj traktowana jako ratio
           findgold(cena,srOcen,&korzen);
           //postorder(korzen);
       }
   }
  // postorder(korzen);
    while(!lista.empty()) //wyswietlenie listy tatuazystow
    {
        cout<<lista.front()<<"\n";
        lista.pop();
    }
}
