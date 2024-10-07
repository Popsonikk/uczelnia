#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
size_t rozmiar(char **&arr, int n)
{
    float avg=0;
    int *rozmiary=new int[n];
    int i=0;
    for_each(arr,arr+n,[&avg,&i,rozmiary](char *tekst)
    {
        *(rozmiary+i)=count(tekst,tekst+strlen(tekst),' ');
        avg+=rozmiary[i++];
    });
    avg/=n;
     for(int i=0;i<n;i++)
     {
         if(rozmiary[i]<avg)
         {
             delete[]arr[i];
             arr[i]=nullptr;
         }
     }
     delete[] rozmiary;
     char **end =remove(arr,arr+n,nullptr);
     n=end-arr;
     char **newarr=new char*[n];
     copy(arr,end ,newarr);
     delete[]arr;
     arr=newarr;
     return n;

}
int main()
{
    const int n=5;
    char **arr=new char*[n];
    for(int i=0;i<n;i++)
        *(arr+i)=new char[20];
    strcpy(*(arr+0),"aa aaa aaaa");
    strcpy(*(arr+1),"aa aaa aaaa aa");
    strcpy(*(arr+2),"aa aaa aaaa aaaaaaa");
    strcpy(*(arr+3),"aa aaa ");
    strcpy(*(arr+4),"aaca");
    const int wynik=rozmiar(arr,n);
    for(int i=0;i<wynik;i++)
    {
        cout<<arr[i]<<' ';
        delete[]*(arr+i);
    }
    delete[]arr;
}
