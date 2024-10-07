//Graham+Sortowanie katowe
//Emil Hotkowski
//www.algorytm.org

#include <iostream>
#include <vector>
#include <algorithm>
#define REP(i,n) for(int i = 0 ; i < (n);i++)
#define MX 500001
using namespace std;

vector < pair<int,int> > punkty;
vector < pair<double,int> > tangens;
int stos[MX];
int pocz=0;

//zwraca wartosc wyznacznika
bool det(int a,int b,int c)
{
int p=punkty[a].second*punkty[b].first+punkty[b].second*punkty[c].first+punkty[c].second*punkty[a].first-punkty[c].second*punkty[b].first-punkty[a].second*punkty[c].first-punkty[b].second*punkty[a].first;
if (p>=0) return 1;
return 0;
}

//kladzie wartosc na stos
void  push(int nr)
{
stos[pocz++]=nr;
}

//zdejmuje wartosc ze stosu
void pops()
{
pocz--;
}

//algorytm Graham'a
void graham()
{
int sY=punkty[0].first,sX=punkty[0].second;
push(0);
for(int i = tangens.size()-1; i >=0;i--)
{
int nr=tangens[i].second;
if(pocz==2) push(nr);
else
{
while(det(stos[pocz-2],stos[pocz-1],nr)==0 && pocz!=1) pops();
push(nr);
}//else
}//for

while(det(stos[pocz-2],stos[pocz-1],0)==0 && pocz!=1)pops();
push(0);
}


int main()
{
int n;

cin>>n;

REP(i,n)
{
int x,y;
cin>>x>>y;
punkty.push_back( make_pair(y,x));

}

sort(punkty.begin(),punkty.end());
//postac (Yi,Xi)

int sY=punkty[0].first,sX=punkty[0].second;
for(int i = 1; i < n;i++)
{
double a=punkty[i].second-sX;
double b=punkty[i].first-sY;
double w=a/b;
tangens.push_back( make_pair( w,i));
}

sort(tangens.begin(),tangens.end());
int ktory=1;
for(int i = tangens.size()-1;i>=0;i--)
{
int p=tangens[i].second;
cout<<ktory++<<" : ("<<punkty[p].second<< ","<<punkty[p].first<<")\n";
}

graham();

cout<<"\n\nOTOCZKA : \n";
REP(i,pocz)
{
cout<<stos[i]<< " : ("<<punkty[stos[i]].second<<","<<punkty[stos[i]].first<<")\n";
}

//system("PAUSE");
return 0;
}
