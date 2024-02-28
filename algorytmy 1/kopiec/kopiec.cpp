//Wejœcie:
//W pierwszej linii wejœcia znajduje siê liczba naturalna t - liczba testów. Kolejne t wierszy zawieraj¹ opisy przypadków testowych.
//Test sk³ada siê z liczby naturalnej n, która oznacza liczbê uczestników spotkania. Po niej nastêpuje n liczb ca³kowitych a1,a2,...,an, które s¹ wskaŸnikami towarzyskoœci kolejnych osób.
//Wyjœcie:
//Na wyjœciu dla ka¿dego testu nale¿y wypisaæ maksymaln¹ liczbê mo¿liwych rozmów. Dodatkowo w kolejnych liniach nale¿y wyœwietliæ pary liczb (numery osób),
//w kolejnoœci w jakiej osoby powinny ze sob¹ rozmawiaæ, przy za³o¿eniu, ¿e najbardziej towarzyskie osoby rozpoczynaj¹ rozmowê wczeœniej. Je¿eli istnieje wiêcej mo¿liwych odpowiedzi nale¿y wyœwietliæ odpowiedŸ pierwsz¹ leksykograficznie. Osoby numerowane s¹ od 1.

#include <iostream>
#include <algorithm>
#include <queue>

int rozmowy=0;
std::queue<int> lista; //kolejka do przechowania par rozmowcow

void WGore(int* numer,int * piorytet, int n) //przesiewanie kopca w gore
{
    int x;
    while(n>0) //w gore tablicy
    {
        if(n%2==1) //lewy syn
        {
            x=(n-1)/2; //ojciec
            if(piorytet[x]<piorytet[n]) //wyzszy piorytet w gore
            {
                std::swap(piorytet[x],piorytet[n]); //zamiana miejscami ojca z synem
                std::swap(numer[x],numer[n]);
                n=x;
            }
            else if(piorytet[x]==piorytet[n]&&numer[x]>numer[n])//niszszy numer wyzej przy tym samym prio
            {
                std::swap(piorytet[x],piorytet[n]);
                std::swap(numer[x],numer[n]);
                n=x;
            }
            else
                break; //konczymy przesianie
        }
        else //prawy syn
        {
            x=n/2-1;
            if(piorytet[x]<piorytet[n])
            {
                std::swap(piorytet[x],piorytet[n]);
                std::swap(numer[x],numer[n]);
                n=x;
            }
            else if(piorytet[x]==piorytet[n]&&numer[x]>numer[n])
            {
                std::swap(piorytet[x],piorytet[n]);
                std::swap(numer[x],numer[n]);
                n=x;
            }
            else
                break;
        }
    }
}
void WDol(int* numer,int * piorytet,int n)
{
    int x=0,y=0;
    while(x*2+1<n)
    {
        y=x*2+1;//kopiec tablicowy dzieci na pozycjach 2x 2x+1 przesuniete bo indexowanie od 0
        if(((piorytet[y]>piorytet[x])||(piorytet[y]==piorytet[x]&&numer[y]<numer[x] ))&&(x+1==n)) //sytuacja bez prawego syna
        {
            std::swap(piorytet[x],piorytet[y]);
            std::swap(numer[x],numer[y]);
            return;
        }
        if(piorytet[y]>piorytet[y+1]) //mozemy pojsc do dwoch synow wybieramy tego z wiekszym prio
        {
            if((piorytet[y]>piorytet[x])||(piorytet[y]==piorytet[x]&&numer[y]<numer[x] ))
            {
                std::swap(piorytet[x],piorytet[y]);
                std::swap(numer[x],numer[y]);
                x=y;
                continue;
            }
        }
        else if(piorytet[y]<piorytet[y+1])
        {
            if((piorytet[y+1]>piorytet[x])||(piorytet[y+1]==piorytet[x]&&numer[y+1]<numer[x] ))
            {
                std::swap(piorytet[x],piorytet[y+1]);
                std::swap(numer[x],numer[y+1]);
                x=y+1;
                continue;
            }
        }
        else //sytuacja gdy obaj synowie maja ten sam piorytet
        {
            if(numer[y]<numer[y+1]) //wtedy wybieramy syna z mniejszym numerem startowym
            {
                if((piorytet[y]>piorytet[x])||(piorytet[y]==piorytet[x]&&numer[y]<numer[x] ))
                {
                    std::swap(piorytet[x],piorytet[y]);
                    std::swap(numer[x],numer[y]);
                    x=y;
                    continue;
                }
            }
            else
            {
                if((piorytet[y+1]>piorytet[x])||(piorytet[y+1]==piorytet[x]&&numer[y+1]<numer[x] ))
                {
                    std::swap(piorytet[x],piorytet[y+1]);
                    std::swap(numer[x],numer[y+1]);
                    x=y+1;
                    continue;
                }
            }
        }
        return; //jezeli nie znalezlismy pasujacego syna przerywamy przesianie
    }
}
void spotkania(int* numer,int * piorytet,int n)
{
    int nr1,nr2,prio1,prio2,index=n-1;
    while(index>0)
    {
        /*for(int i=0;i<=index;i++)
            std::cout<<piorytet[i]<<'/'<<numer[i]<<' ';
        std::cout<<'\n';*/
        if(piorytet[0]==0) //zabieramy korzen, w korzeniu zawsze najwiekszy piorytet wiec przy 0 w korzeniu konczymy algorytm
            return;

        nr1=numer[0];
        prio1=piorytet[0];
        numer[0]=numer[index];
        piorytet[0]=piorytet[index];//zabralismy korzen przerzucamy ostatni element kopca do korzenia
        index-=1;
        WDol(numer,piorytet,index+1); //i przesiewamy go w dol

        /*std::cout<<"dol"<<':';
        for(int i=0;i<=index;i++)
            std::cout<<piorytet[i]<<'/'<<numer[i]<<' ';
        std::cout<<'\n';*/
        if(piorytet[0]==0) //sprzawdzamy czy mozemy doprac rozmowce do pary
            return;

        nr2=numer[0];
        prio2=piorytet[0];
        numer[0]=numer[index];
        piorytet[0]=piorytet[index]; //powtarzamy algorytm dla drugiego rozmowcy
        index-=1;
        WDol(numer,piorytet,index+1);

        if(nr1>nr2)  //rozmowcy tworza pare x<y wiec sprawdzamy
        {
            lista.push(nr2);
            lista.push(nr1);
        }
        else
        {
            lista.push(nr1);
            lista.push(nr2);
        }

        rozmowy+=1; //oznaczamy odbyta rozmowe
        if(prio1-1>0) //dodajemy rozmowce z powrotem do kopca jezeli ma jeszcze ochote rozmawiac
        {
            index+=1;
            numer[index]=nr1;
            piorytet[index]=prio1-1;
            WGore(numer,piorytet,index);
        }
        if(prio2-1>0)
       {
           index+=1;
           numer[index]=nr2;
           piorytet[index]=prio2-1;
           WGore(numer,piorytet,index);
       }
    }
}
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int t,n,pr;
    std::cin>>t;
    for(int i=0;i<t;i++)
    {
        rozmowy=0;
        std::cin>>n;
        int* numery=new int [n];
        int* priorytety=new int [n];

        for(int j=0;j<n;j++)
        {
           std::cin>>pr;
           numery[j]=j+1;
           priorytety[j]=pr;
           WGore(numery,priorytety,j); //przesiewamy przy kazdej nowej zmiennej w kopcu

        }
        spotkania(numery,priorytety,n);
        std::cout<<rozmowy<<'\n';
        while(!lista.empty()) //wyswietlenie listy rozmowcow
        {
            std::cout<<lista.front()<<' ';
            lista.pop();
            std::cout<<lista.front()<<'\n';
            lista.pop();
        }
        delete [] numery;
        delete [] priorytety;
    }

}
