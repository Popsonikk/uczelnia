#include <iostream>
#include <ctime>
#include <cstdio>
#include <cstdlib>
using namespace std;
bool condition(int n)
{
    bool czy=true;
    int arr[10]={0},x=0;
    while(n)
    {
        x=n%10;
        arr[x]+=1;
        if(arr[x]>=2)
            czy=false;
        n/=10;
    }
    return czy;
}
void show(int *arr,int n)
{
    for(int i=0;i<n;i++)
    {
        cout<<*(arr+i)<<' ';
    }
    printf("\n");
}
void action(int &n)
{
    int x=n;
    n=0;
    while(x)
    {
        n*=10;
        n+=x%10;
        x/=10;
    }
}
int modify_array(int * arr,int n,bool(*con)(int),void(*act)(int&))
{
    for(int i=0;i<n;i++)
    {
        if(con(*(arr+i)))
            act(*(arr+i));
    }
}
int main()
{
    srand(time(NULL));
    int n;
    cout<<"podaj n ";
    cin>>n;
    int *arr=new int[n];

    for(int i=0;i<n;i++)
    {
        *(arr+i)=rand()%5000+600;
    }
    show(arr,n);
    bool(*con)(int)=condition;
    void(*act)(int&)=action;
    modify_array(arr,n,con,act);
    show(arr,n);
    delete[]arr;
}
