#include <iostream>
#include <cstdlib>
#include <algorithm>
using namespace std;
void fill(int *arr,int n)
{
    for(int i=0;i<n;i++)
        *(arr+i)=rand()%15;

}
void show(int *arr,int n)
{
    for(int j=0;j<n;j++)
        cout<<*(arr+j)<<' ';
    printf("\n");
}
void f(void *wsk,int n,int size,int group)
{

        int *arr=(int*)wsk;
        int *arrcp=new int [n];
        copy(arr,arr+n,arrcp);

    int k=0;
    for(int i=0;i<n/group;i++)
    {
        for(int j=0;j<group;j++)
        {
            *(arr+k)=*(arrcp+i+j*(n/group));
            k++;
        }
    }


}
int main()
{
    int n;
    cout<<"podaj n ";
    cin>>n;
    int m;
    cout<<"podaj m bedacy dzielnikiem n";
    cin>>m;
    int *arr=new int[n];
    fill(arr,n);
    show(arr,n);
    void *wsk=arr;
    f(wsk,n,sizeof(int),m);
    show(arr,n);
    delete[]arr;
}
