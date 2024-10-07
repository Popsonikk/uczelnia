#include <iostream>
#include <vector>
using namespace std;
void szukaj(vector<int> okres,vector<int> wzorzec,int d,int q)
{
    int h=1; //funkcja hashuj¹ca
    int w=0; //wartosc wzorca
    int O=0; //wartosc podciagu okresu
    int m= okres.size();
    int n= wzorzec.size();
    int a=-1,b=-1; //pierwsze i drugie wyst¹pienie wzorca
    for (int i=0;i<n-1;i++)
        h=(h*d)%q;
    for (int i=0;i<n;i++)
    {
        w = (d*w+wzorzec.at(i))%q;
        O = (d*O+okres.at(i))%q;
    }
    for(int i=0;i<=m-n;i++)
    {
        if(O==w)
        {
           for(int j=0;j<n;j++)
           {
               if(wzorzec.at(j)!=okres.at(i+j))
                    break;
               if(j==n-1)
               {
                   if(a==-1)
                        a=i;
                   else if(b==-1)
                        b=i;
               }
           }
        }
        if(i<m-n)
        {
            O=(d*(O-okres.at(i)*h)+okres.at(i+n))%q;
            if(O<0)
                O+=q;
        }
        if(a!=-1&&b!=-1) //przerywamy po dwóch wyrazach
            break;
    }
    while(b<m) //fibonachi
    {
        b += a;
        a = b-a;
    }
    cout<<b-m;
}
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int v;
    cin>>v;
    vector<int> okres;
     int n;
    for(int i=0;i<v;i++)
    {
        cin>>n;
        okres.push_back(n);
    }
    int p;
    cin>>p;
    vector<int> wzorzec;
    for(int i=0;i<p;i++)
    {
        cin>>n;
        wzorzec.push_back(n);
    }
     szukaj(okres,wzorzec,101,7);//ostatni parametr to dowolna liczba pierwsza
}
