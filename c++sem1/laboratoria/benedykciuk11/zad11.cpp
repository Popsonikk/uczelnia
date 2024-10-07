#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
void get(int *arr,int n)
{
    for(int i=0;i<n;i++)
    {
        *(arr+i)=rand()%5;
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
int* search(int *arr, int n,int x)
{
        int *result=nullptr;
        for(int i=0;i<n;i++)
        {
            if(*(arr+i)==x)
                result=arr+i;
        }
        return result;

}
int main()
{
    srand(time(NULL));
    int n,x;
    printf("poadj n x ");
    cin>>n>>x;
    int *arr=new int[n];
    get(arr,n);
    show(arr,n);
    search(arr,n,x)==nullptr?cout<<search(arr,n,x):cout<<search(arr,n,x)-arr;
    delete[]arr;
}
