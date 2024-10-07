#include<iostream>
#include<list>
#include<queue>
using namespace std;
#define max_int 2147483647 //maxint
int m, n; //m- liczba dzial niemieckicj, n-liczba dzial polskich
list<int> *graf;//reprezenracja grafu, tablica list
int *paraN, *paraP, *dlugosc; //tablice dla algorytmu
bool bfs()
{
    queue<int> quene;
    for (int z=1; z<=m; z++)
    {
        if (paraN[z]==0)
        {
            dlugosc[z] = 0;
            quene.push(z);
        }
        else
            dlugosc[z] = max_int;
    }
    dlugosc[0] = max_int;
    while (!quene.empty())
    {
        int z = quene.front();
        quene.pop();
        if (dlugosc[z] < dlugosc[0])
        {
            list<int>::iterator i;
            for (i=graf[z].begin(); i!=graf[z].end(); ++i)
            {
                int y = *i;
                if (dlugosc[paraP[y]] == max_int)
                {
                    dlugosc[paraP[y]] = dlugosc[z] + 1;
                    quene.push(paraP[y]);
                }
            }
        }
    }
    return (dlugosc[0] != max_int);
}
bool dfs(int z)
{
    if (z != 0)
    {
        list<int>::iterator i;
        for (i=graf[z].begin(); i!=graf[z].end(); ++i)
        {
            int y = *i;
            if (dlugosc[paraP[y]] == dlugosc[z]+1)
            {
                if (dfs(paraP[y]) == true)
                {
                    paraP[y] = z;
                    paraN[z] = y;
                    return true;
                }
            }
        }
        dlugosc[z] = max_int;
        return false;
    }
    return true;
}
int hopcroftKarp()
{
    paraN = new int[m+1];
    paraP = new int[n+1];
    dlugosc = new int[m+1];
    for (int z=0; z<=m; z++)
        paraN[z] = 0;
    for (int y=0; y<=n; y++)
        paraP[y] = 0;
    int result = 0;
    while (bfs())
    {
        for (int z=1; z<=m; z++)
            if (paraN[z]==0 && dfs(z))
                result++;
    }
    return result;
}
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);   //dla sprawdzarki

    int bokPlanszy,iloscDomow; //szerokosc pola bitwy
    std::cin>>bokPlanszy>>iloscDomow; //m - ilosc domow na planszy
    int **indeksy= new int*[bokPlanszy]; //tutaj przechowam indeksy wierzcholkow przed stwozeniem grafu
    char **polestrategiczne= new char*[bokPlanszy]; //deklaruje macierz pola na podstawie ktorej zbubuje graf
    for(int i=0;i<bokPlanszy;i++)
    {
        indeksy[i]=new int [bokPlanszy];
        polestrategiczne[i]= new char[bokPlanszy];
        for(int j=0;j<bokPlanszy;j++) //uzupelnianie planszy danymi z polecenia
        {
            if((i%2==0&&j%2==0)||(i%2==1&&j%2==1))
                polestrategiczne[i][j]='N';
            else
                polestrategiczne[i][j]='P';
        }
    }
    int domyN=0,domyP=0; //zliczam ilosc dzial zastapionych po kazdej stronie
    int x,y; //wspolrzedne domow
    for(int i=0;i<iloscDomow;i++)
    {
        std::cin>>x>>y;
        if(polestrategiczne[y][x]=='N')
            domyN++;
        else
            domyP++;
        polestrategiczne[y][x]='X';//aktualizowanie planszy o domu
    }
    m=0;n=0; //m- niemieckie, n-polskie
    for(int i=0;i<bokPlanszy;i++) //budowanie indeksow wierzcholkow do grafu
    {
        for(int j=0;j<bokPlanszy;j++)
        {
           if(polestrategiczne[i][j]=='X')
                indeksy[i][j]=-1;
           else if(polestrategiczne[i][j]=='N'&&i<bokPlanszy-2)
                indeksy[i][j]=++m;
           else if(polestrategiczne[i][j]=='P'&&i>1)
                indeksy[i][j]=++n;
            else
                indeksy[i][j]=-1;
        }
    }
   /* for(int i=0;i<bokPlanszy;i++)
    {
        for(int j=0;j<bokPlanszy;j++)
        {
            cout<<polestrategiczne[i][j]<<' ';
        }
        cout<<'\n';
    }*/
    graf= new list<int>[m+1];
    int A=1; //indeksowanie grafu
    for(int i=0;i<bokPlanszy-2;i++) //budowa grafu dzialo wiaze max 3 dziala przeciwnika : 3 do dolu i 2 do dolu na 1 w prawo i 1 w lewo
    {
        for(int j=0;j<bokPlanszy;j++)
        {
            if(polestrategiczne[i][j]=='X') //dom
                continue;
            if (polestrategiczne[i][j]=='N') //dzialo niemieckie
            {
                bool flag=false;
                if(j>0)
                {
                    if(polestrategiczne[i+2][j-1]!='X')
                        graf[A].push_back(indeksy[i+2][j-1]);
                    flag=true;
                }
               if(j<bokPlanszy-1)
                {
                   if(polestrategiczne[i+2][j+1]!='X')
                        graf[A].push_back(indeksy[i+2][j+1]);
                    flag=true;
                }
                if(i<bokPlanszy-3)
                {
                    if(polestrategiczne[i+3][j]!='X')
                       graf[A].push_back(indeksy[i+3][j]);
                    flag=true;
                }
               if(flag)
                    A++;
            }
        }
    }
    std::cout<<bokPlanszy*bokPlanszy-hopcroftKarp();
}
