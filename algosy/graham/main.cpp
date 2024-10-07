#include <iostream>
#include <vector>
#include <cmath>
#include<algorithm>
#include <iomanip>
using namespace std;
struct Punkt //punkt ma wspolrzendne punktu oraz kat i dlugosc od poczotku ukladu
{
    double x;
    double y;
    double atan;
};
Punkt s;
bool porownaj(Punkt a, Punkt b)
{
    if(a.atan==b.atan)
        return (s.x-a.x)*(s.x-a.x)+(s.y-a.y)*(s.y-a.y)<(s.x-b.x)*(s.x-b.x)+(s.y-b.y)*(s.y-b.y); //dlugosci jezeli rowny kat
    return a.atan<b.atan;
}
double det(Punkt a,Punkt b,Punkt c)
{
    return a.x*(b.y-c.y)-a.y*(b.x-c.x)+(b.x*c.y-b.y*c.x);
}
void graham(vector<Punkt> &tab)
{
    int i=2;
    tab.push_back(s);
    vector<int> index;
    index.push_back(0);
    index.push_back(1);

    Punkt p1=tab[0],p2=tab[1],p3=tab[2];
    int indP1=0,indP2=1,indP3=2;
    while(i<tab.size())
    {
      // cout<<p1.x<<'-'<<p1.y<<' '<<p2.x<<'-'<<p2.y<<' '<<p3.x<<'-'<<p3.y<<' '<<det(p1,p2,p3)<<'\n';
      // cout<<indP1<<' '<<indP2<<' '<<indP3<<'\n';
        if(det(p1,p2,p3)>=0)
        {
            index.push_back(indP2);
            p1=p2;
            p2=p3;
            indP1=indP2;
            indP2=indP3;
            p3=tab[++i];
            indP3=i;
        }
        else
        {
            index.pop_back();
            if(i==2)
            {
                p1=tab[0];
                p2=tab[2];
                p3=tab[3];
                i=3;
                indP1=0;indP2=2;indP3=3;
                continue;
            }
            p2=p1;
            indP2=indP1;
            p1=tab[index.back()];
            indP1=index.back();
        }
    }
    cout<<endl;
  // for(int i=0;i<index.size();i++)
       // cout<<index[i]<<'\n';
       //cout<<tab.at(index[i]).x<<' '<<tab.at(index[i]).y<<' '<<'\n';
    double pole=0,a,b,c;
    for(int i=0;i<index.size()-1;i++)
    {
        a=sqrt((tab[index[i]].x-tab[index[i+1]].x)*(tab[index[i]].x-tab[index[i+1]].x)+(tab[index[i]].y-tab[index[i+1]].y)*(tab[index[i]].y-tab[index[i+1]].y));
        b=sqrt((tab[index[i]].x-s.x)*(tab[index[i]].x-s.x)+(tab[index[i]].y-s.y)*(tab[index[i]].y-s.y));
        c=sqrt((s.x-tab[index[i+1]].x)*(s.x-tab[index[i+1]].x)+(s.y-tab[index[i+1]].y)*(s.y-tab[index[i+1]].y));
        pole+=sqrt((a+b+c)*(a+b-c)*(a-b+c)*(-a+b+c))/4;
      // cout<<s.x<<'-'<<s.y<<' '<<tab[index[i]].x<<'-'<<tab[index[i]].y<<' '<<tab[index[i+1]].x<<'-'<<tab[index[i+1]].y<<' '<<pole<<'\n';
       // cout<<a<<' '<<b<<' '<<c<<'\n';
    }
    cout<<setprecision(3)<<fixed<<pole;
}
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    vector<Punkt> lista; //wektor punkow
    int n; //ilosc punkow
    cin>>n;
    cin>>s.x>>s.y; //pierwszy punkt
    for(int i=0;i<n-1;i++)
    {
        Punkt p;
        cin>>p.x>>p.y;
        if((p.y<s.y)||(p.y==s.y&&p.x<s.x)){ //sprawdzanie czy wczytany punkt jest mniejszy od obecnie wybranego
            lista.push_back(s);
            s=p;
        }
        else
            lista.push_back(p);
    }
    for(int i=0;i<lista.size();i++)
        lista[i].atan=atan2((lista[i].y-s.y),(lista[i].x-s.x));
    sort(lista.begin(),lista.end(),porownaj);
    /*for(int i=0;i<lista.size();i++)
    cout<<lista.at(i).x<<' '<<lista.at(i).y<<' '<<lista[i].kat<<'\n';
        cout<<'\n';*/
    for(int i=1;i<lista.size();i++)
    {
        if(lista[i-1].atan==lista[i].atan)
        {
           lista.erase(lista.begin()+i-1);
           i--;
        }
    }
    //cout<<'\n';
    //for(int i=0;i<lista.size();i++)
       //cout<<lista.at(i).x<<' '<<lista.at(i).y<<' '<<lista[i].kat<<'\n';
    graham(lista);


}
