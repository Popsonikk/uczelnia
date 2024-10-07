#include <iostream>
#include <ctime>
#include <cstdio>
#include <cstdlib>
using namespace std;
void get(int *arr,int n)
{
    srand(time(NULL));
    for(int i=0;i<n;i++)
    {
        *(arr+i)=rand()%10;
    }
}
void show(int *arr,int n)
{
    for(int i=0;i<n;i++)
    {
        cout<<*(arr+i)<<' ';
    }
}
void copy(int *arr,int n ,int *result,int k)
{
    int i=0,MAX=0,j=0;
    while(i<k)
    {
        MAX=0;
        for(int a=0;a<n;a++)
        {
            if(*(arr+a)>MAX)
            {
                MAX=*(arr+a);
                j=a;
            }
        }
        *(result+i)=MAX;
        i++;
        *(arr+j)=0;
    }
}
int main()
{
    int n;
    printf("podaj rozmiar");
    scanf("%d",&n);
    int *arr=new int[n]();
    get(arr,n);
    show(arr,n);
    int k;
    printf("podaj rozmiar");
    scanf("%d",&k);
    int *result=new int[k]();
    copy(arr,n,result,k);
    show(result,k);
    delete[]arr;
    delete[]result;


}
