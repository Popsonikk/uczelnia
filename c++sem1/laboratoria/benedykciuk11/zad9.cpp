#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
void get(int *arr,int n,int &a)
{
    for(int i=0;i<n;i++)
    {
        *(arr+i)=rand()%15;
        if(*(arr+i)>a)
            a=*(arr+i);
    }
}
void min(int *arr,int n,int &a,int&b)
{
    for(int i=0;i<n;i++)
    {
        if(*(arr+i)<b)
        {
            if(*(arr+i)<a)
            {
                a=*(arr+i);
            }
            else
            {
                b=*(arr+i);
            }
        }
    }

}
void show(int *arr,int n)
{
    for(int i=0;i<n;i++)
    {
        cout<<*(arr+i)<<' ';
    }
    printf("\n");
}
int main()
{
    srand(time(NULL));
    int n,a=0,b=0;
    printf("poadj n ");
    cin>>n;
    int *arr=new int[n];
    get(arr,n,a);
    b=a;
    show(arr,n);
    min(arr,n,a,b);
    cout<<a<<' '<<b;
    delete[]arr;
}
