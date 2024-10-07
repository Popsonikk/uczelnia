#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int M=2*20+1;//ilosc kluczy w wezle
struct bTree{
    bTree *ojciec=nullptr;
    vector <string> keys;
    vector <string> values;
    vector <bTree*> children;
       bTree(){
        keys.reserve(M);
        values.reserve(M);
        children.reserve(M+1);
    }

};
void preorder(bTree *drzewo)
{

    cout<<"A "<<drzewo<<" O "<<drzewo->ojciec<<' ';
    for(int i=0;i<drzewo->keys.size();i++)
       // cout<<drzewo->ojciec<<" ";
        cout<<drzewo->keys.at(i)<<' ';
    cout<<endl;
    for(int i=0;i<drzewo->children.size();i++)
    {
        if(drzewo->children.at(i)!=nullptr)
        preorder(drzewo->children.at(i));
    }


}
void dziel(bTree *node)
{
   /* cout<<"D ";
    for(int i=0;i<node->keys.size();i++)
        cout<<node->keys.at(i)<<' ';
    cout<<endl;*/
    bTree *prawy= new bTree;
    int middle= node->keys.size()/2;
    string key=node->keys.at(middle),value=node->values.at(middle);
    prawy->keys.insert(prawy->keys.begin(),node->keys.begin()+middle+1,node->keys.end());
    prawy->values.insert(prawy->values.begin(),node->values.begin()+middle+1,node->values.end());
    prawy->children.insert(prawy->children.begin(),node->children.begin()+middle+1,node->children.end());
    for(int i=0;i<prawy->children.size();i++)
    {
        if(prawy->children.at(i)!=nullptr)
            prawy->children.at(i)->ojciec=prawy;
    }

    if(node->ojciec==nullptr)
    {
        bTree *lewy=new bTree;
        lewy->keys.insert(lewy->keys.begin(),node->keys.begin(),node->keys.begin()+middle);
        lewy->values.insert(lewy->values.begin(),node->values.begin(),node->values.begin()+middle);
        lewy->children.insert(lewy->children.begin(),node->children.begin(),node->children.begin()+middle+1);
        for(int i=0;i<lewy->children.size();i++)
        {
            if(lewy->children.at(i)!=nullptr)
                lewy->children.at(i)->ojciec=lewy;
        }
        node->keys.clear();
        node->values.clear();
        node->children.clear();
        node->keys.push_back(key);
        node->values.push_back(value);
        node->children.push_back(lewy);
        node->children.push_back(prawy);
        prawy->ojciec=node;
        lewy->ojciec=node;
    }
    else
    {

        for(int j=0;j<node->ojciec->keys.size();j++)
        {
            if(node->ojciec->keys.at(j)>key)
            {
                node->ojciec->keys.insert(node->ojciec->keys.begin()+j,key);
                node->ojciec->values.insert(node->ojciec->values.begin()+j,value);
                node->ojciec->children.insert(node->ojciec->children.begin()+j+1,prawy);
                break;
            }
            if(j==node->ojciec->keys.size()-1)
            {
                node->ojciec->keys.push_back(key);
                node->ojciec->values.push_back(value);
                node->ojciec->children.push_back(prawy);
                break;
            }
        }
        node->keys.erase(node->keys.begin()+middle,node->keys.end());
        node->values.erase(node->values.begin()+middle,node->values.end());
        node->children.erase(node->children.begin()+middle+1,node->children.end());
        prawy->ojciec=node->ojciec;
        if(node->ojciec->keys.size()==M)
            dziel(node->ojciec);
    }
}
void dodaj(bTree **korzen,string key,string value)
{
    int x=0;//jezeli znajde interesujace mnie wartosci dla pozostalych dwoch vectorow uzyje funkci at
    bTree *pom=*korzen;
    if(pom->keys.size()==0)//0 elementow
    {
        pom->keys.push_back(key);
        pom->values.push_back(value);
        pom->children.push_back(nullptr);
        return;
    }
    while(1)
    {
        if(pom->keys.at(x)==key) //klucz znajduje sie w drzewie nadpisujemy wartosc
        {
            pom->values.at(x)=value;
            return;
        }
        else if(key<pom->keys.at(x)) //klucz jest wczesniej leksykonalnie
        {
            if(pom->children.at(x)!=nullptr) //mamy dziecko do ktorego schodzimy
            {
                pom=pom->children.at(x);
                x=0;
                continue;
            }
            else if(pom->children.at(x)==nullptr) //nie mamy dziecka zapisujemy w obecnym wezle
            {
                pom->keys.insert(pom->keys.begin()+x,key);
                pom->values.insert(pom->values.begin()+x,value);
                pom->children.insert( pom->children.begin()+x,nullptr);
                if(pom->keys.size()==M)
                    dziel(pom);
                return;
            }
        }
        else if(key>pom->keys.at(x)) //klucz jest pozniej leksykonalnie
        {
            if(x<pom->keys.size()-1) //nie doszlismy do konca listy wiec przechodzimy dalej
            {
                x++;
                continue;
            }
            else //jestesmy na koncu listy
            {
                if(pom->children.at(x+1)==nullptr) //nie mamy dziecka zapisujewy w obecnym wezle
                {
                    pom->keys.push_back(key);
                    pom->values.push_back(value);
                    pom->children.push_back(nullptr);
                    if(pom->keys.size()==M)
                        dziel(pom);
                    return;
                }
                else //mamy dziecko schodzimy do niego
                {
                    pom=pom->children.at(x+1);
                    x=0;
                    continue;
                }
            }
        }
    }
}
void znajdz(bTree **korzen,string key)
{
    int x=0;//jezeli znajde interesujace mnie wartosci dla pozostalych dwoch vectorow uzyje funkci at
    bTree *pom=*korzen;
    if(pom->keys.size()==0)//0 elementow
        return;
    while(1)
    {
        if(pom->keys.at(x)==key) //klucz znajduje sie w drzewie nadpisujemy wartosc
        {
            cout<<pom->values.at(x);
            break;
        }
        else if(key<pom->keys.at(x)) //klucz jest wczesniej leksykonalnie
        {
            if(pom->children.at(x)!=nullptr) //mamy dziecko do ktorego schodzimy
            {
                pom=pom->children.at(x);
                x=0;
                continue;
            }
            else if(pom->children.at(x)==nullptr) //nie mamy dziecka zapisujemy w obecnym wezle
            {
               cout<<"BRAK";
               return;
            }
        }
        else if(key>pom->keys.at(x)) //klucz jest pozniej leksykonalnie
        {
            if(x<pom->keys.size()-1) //nie doszlismy do konca listy wiec przechodzimy dalej
            {
                x++;
                continue;
            }
            else //jestesmy na koncu listy
            {
                if(pom->children.at(x+1)==nullptr) //nie mamy dziecka zapisujewy w obecnym wezle
                {
                   cout<<"BRAK";
                   return;
                }
                else //mamy dziecko schodzimy do niego
                {
                    pom=pom->children.at(x+1);
                    x=0;
                    continue;
                }
            }
        }
    }
}

int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int n; //liczba operacji
    cin>>n;
    bTree *korzen=new bTree;
    korzen->children.push_back(nullptr);
    string haslo;
    getline(std::cin,haslo);
    for (int i=0;i<n;i++)
    {
        getline(std::cin,haslo);
        haslo.substr(0,haslo.length()-1); //usuwam \n
        if(haslo.find(":")==string::npos) //znakiem dzielacym jest :
        {
            znajdz(&korzen,haslo);
            cout<<"\n";
        }
        else
           dodaj(&korzen,haslo.substr(0,haslo.find(":")),haslo.substr(haslo.find(":")+1,haslo.length()));
     /*   preorder(korzen);
        cout<<"-------------------------"<<endl;*/
    }

}
