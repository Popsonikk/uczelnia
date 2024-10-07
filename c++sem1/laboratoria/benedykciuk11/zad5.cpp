#include <iostream>
#include <cstdlib>
void dod(int **arr1, int **arr2 ,int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            *(*(arr1+i)+j)+=*(*(arr2+i)+j);
        }
    }
}
void ode(int **arr1, int **arr2 ,int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            *(*(arr1+i)+j)-=*(*(arr2+i)+j);
        }
    }
}
void get1(int **arr ,int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            *(*(arr+i)+j)=i+j;
        }
    }
}
void get2(int **arr ,int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            *(*(arr+i)+j)=j-i+2;
        }
    }
}
void show(int **arr ,int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
           std::cout<< *(*(arr+i)+j);
        }
        printf("\n");
    }
    printf("\n");
}
void f(int **arr1, int **arr2 ,int n , void(*fun)(int**,int**,int))
{
    fun(arr1,arr2,n);
    show(arr1,n);
}

int main()
{
    int n;
   int x;
    printf ("podaj rozmiar i dzia³anie ");
    scanf("%d",&n);
    std::cin>>x;
    int **arr1=new int*[n];
    int **arr2=new int*[n];
    for(int j=0;j<n;j++)
    {
        arr1[j]=new int[n];
    }
     for(int j=0;j<n;j++)
    {
        arr2[j]=new int[n];
    }
    get1(arr1,n);
    get2(arr2,n);
    show(arr1,n);
    show(arr2,n);
    void (*fun[2])(int**,int**,int)={dod,ode};
    x?f(arr1,arr2,n,fun[1]):f(arr1,arr2,n,fun[0]);
    for(int j=0;j<n;j++)
    {
        delete[]arr1[j];
    }
    for(int j=0;j<n;j++)
    {
        delete[]arr2[j];
    }
    delete[]arr1;
    delete[]arr2;



}
