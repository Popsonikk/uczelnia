#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
void get(int **arr, int n)
{

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            *(*(arr+i)+j)=rand()%10;
        }
    }
}
void show(int**arr, int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
           std::cout<<arr[i][j]<<' ';
        }
        printf("\n");
    }
    printf("\n");
}
void sum(int **arr1,int **arr2,int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            arr1[i][j]+=arr2[i][j];
        }
    }
}
void roz(int **arr1,int **arr2,int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            arr1[i][j]-=arr2[i][j];
        }
    }
}
void mat_operation(int **arr1,int **arr2,int n,void(*fun)(int**,int**,int))
{
    fun(arr1,arr2,n);
}
int main()
{
    srand(time(NULL));
    int n;
    printf("podaj rozmiar");
    scanf("%d",&n);
    int **arr1=new int*[n];
    for(int i=0;i<n;i++)
    {
        arr1[i]=new int[n];
    }
    get(arr1,n);
    show(arr1,n);
    int **arr2=new int*[n];
    for(int i=0;i<n;i++)
    {
        arr2[i]=new int[n];
    }
    get(arr2,n);
    show(arr2,n);
    void(*fun)(int**,int**,int)=roz;
    mat_operation( arr1, arr2, n,fun);
    show(arr1,n);
    for(int i=0;i<n;i++)
    {
        delete[]arr1[i];
    }
    delete[]arr1;
    for(int i=0;i<n;i++)
    {
        delete[]arr2[i];
    }
    delete[]arr2;
}
