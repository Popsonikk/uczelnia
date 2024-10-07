#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
void get(float **arr,int n,int m)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            arr[i][j]=rand()%10;
        }
    }
}
void show(float **arr,int n,int m)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            cout<<*(*(arr+i)+j)<<' ';
        }
        printf("\n");
    }
    printf("\n");
}
void T(float **arr,float **result ,int n,int m)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            *(*(result+j)+i)=*(*(arr+i)+j);
        }
    }
}
int main()
{
    srand(time(NULL));
    int n,m;
    printf("poadj n,m");
    cin>>n>>m;
    float **arr=new float*[n];
    for(int i=0;i<n;i++)
    {
        arr[i]=new float[m];
    }
    float **result=new float*[m];
    for(int i=0;i<m;i++)
    {
        result[i]=new float[n];
    }
    get(arr,n,m);
    show(arr,n,m);
    T(arr,result,n,m);
    show(result,m,n);
    for(int i=0;i<n;i++)
    {
        delete[]arr[i];
    }
    for(int i=0;i<m;i++)
    {
        delete[]result[i];
    }
    delete[]arr;
    delete[]result;
}
