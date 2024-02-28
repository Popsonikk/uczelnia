//Wejście:
//Na wejściu dostajemy liczbę naturalną n, oznaczającą liczbę instrukcji, które Ula chce wprowadzić do drzewa decyzyjnego. Następnie otrzymujemy n instrukcji.
//Każda składa się z dwóch linii: łańcucha napisowego (z opisem procedury, którą ma wykonać robot) oraz liczby naturalnej k, po której następuje k liczb naturalnych {k1...kk}.
//Te liczby odpowiadają numerom klas, które Ula ustaliła wcześniej i są tak zwaną ścieżką w drzewie decyzyjnym prowadzącą od korzenia (0 - Stan spoczynku) aż do podklasy kk,
//dla której dodawany jest opis (k1 jest główną klasą podpiętą pod korzeń drzewa decyzyjnego). Jeśli podczas dodawania do drzewa decyzyjnego okaże się,
//że któraś klasa pośrednia nie została jeszcze dodana do drzewa, należy ją utworzyć i jako opis ustawić literę X. Jeżeli dla danej ścieżki istnieje już opis procedury, należy go nadpisać
// (zmianie podlega jedynie opis, struktura drzewa pozostaje bez zmian). Nowe gałęzie w ramach klasy dopinane są po kolei w kolejności pojawienia się na wejściu. W ostatniej linii wejścia znajduje się liczba naturalna x ∈ {1,2}, determinująca sposób wyświetlenia drzewa (1 - preorder, 2 - postorder).

//Wyjście:
//Na wyjściu należy wyświetlić całe drzewo decyzyjne.
#include <iostream>
#include <string>
#include<ios>
#include<limits>
bool flag=false;
class Drzewo{
public:
   Drzewo * ojciec;
   Drzewo * syn;
   Drzewo * brat ;
   int data;
   std::string polecenie;
};
void preorder(Drzewo *drzewo)
{
    std::cout<< drzewo->polecenie<<"\n";
    if(drzewo->syn!=nullptr)
        preorder(drzewo->syn);
    if(drzewo->brat!=nullptr)
        preorder(drzewo->brat);
}
void postorder(Drzewo *drzewo)
{
    if(drzewo->syn!=nullptr)
        postorder(drzewo->syn);
    std::cout<< drzewo->polecenie<<"\n";
    if(drzewo->brat!=nullptr)
        postorder(drzewo->brat);

}
void czyistnieje(Drzewo *drzewo,std::string name)
{
    if(drzewo->polecenie==name)
        flag=true;
    if(drzewo->syn!=nullptr)
        czyistnieje(drzewo->syn,name);
    if(drzewo->brat!=nullptr)
        czyistnieje(drzewo->brat,name);

}
void dodaj(std::string polecenie,Drzewo** start,int droga,int *tab)
{
    Drzewo *pom=*start;
    int i=0;
    while(i<droga)
    {
        if(pom->syn!=nullptr)
        {
            pom=pom->syn;
            i++;
            while(true)
            {
                if(pom->data==tab[i-1])
                {
                    break;
                }
                if(pom->brat==nullptr)
                {
                    Drzewo *drzewo=new Drzewo;
                    drzewo->brat=nullptr;
                    drzewo->data=tab[i-1];
                    drzewo->ojciec=pom->ojciec;
                    drzewo->polecenie="X";
                    drzewo->syn=nullptr;
                    pom->brat=drzewo;
                    pom=drzewo;
                    break;
                }
                pom=pom->brat;
            }
        }
        else
        {
            Drzewo *drzewo=new Drzewo;
            drzewo->brat=nullptr;
            drzewo->data=tab[i];
            drzewo->ojciec=pom;
            drzewo->polecenie="X";
            drzewo->syn=nullptr;
            pom->syn=drzewo;
            pom=drzewo;
            i++;
        }
    }

    pom->polecenie=polecenie;
}
void deletetree(Drzewo *drzewo)
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
    Drzewo *poczotek=new Drzewo;
    poczotek->ojciec=nullptr;
    poczotek->syn=nullptr;
    poczotek->brat=nullptr;
    poczotek->data=0;
    poczotek->polecenie= "Stan spoczynku";
    int n, droga;

    std::cin>>n;
    for(int i=0;i<n;i++)
    {
        //flag=false;
        std::string name;
        std::cin.ignore(std::numeric_limits<std::streamsize>::max(),'\n');
        std::getline(std::cin,name);
        std::cin>>droga;
        int *tab=new int [droga];
        for(int j=0;j<droga;j++)
            std::cin>>tab[j];
        //czyistnieje(poczotek,name);
        dodaj(name,&poczotek,droga,tab);

        delete []tab;

    }
    int a;
    std::cin>>a;
    if(a==1)
        preorder(poczotek);
    else if(a==2)
        postorder(poczotek);
    deletetree(poczotek);
}
