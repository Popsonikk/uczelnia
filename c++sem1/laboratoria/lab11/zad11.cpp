#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;
struct Stat
{
    float srednia;
    float mediana;
    float wariacja;
    float odchylenie;
};
Stat f(const int *arr,int c)
{
    Stat x;
    x.srednia =0;
    for(int i=0;i<c;i++)
    {
        x.srednia+=arr[i];
    }
    x.srednia/=c;
    int *cp= new int [c];
    cp=copy(arr,arr+c,cp);
    sort(cp,cp+c);
    if(c%2==1)
    {
        x.mediana=cp[c/2];
    }
    else
    {
        x.mediana=(cp[c/2]+cp[c/2]+1)/2;
    }
     for(int i=0;i<c;i++)
    {
        x.wariacja+=(arr[i]-x.srednia)*(arr[i]-x.srednia);
    }
    x.odchylenie =sqrt(x.wariacja);
}
int main()
{
      int arr[5] = {1, 5, 2, 8, 4};
    Stat y = f(arr, 5);
    cout<<y.srednia<<endl;
    cout<<y.mediana<<endl;
    cout<<y.wariacja<<endl;
    cout<<y.odchylenie<<endl;
    return 0;
}
