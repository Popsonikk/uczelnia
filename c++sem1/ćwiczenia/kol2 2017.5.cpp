#include <iostream>
using namespace std;
bool czy_pierwsza(int* arr,int n)
{
    int k=1;
    bool czy=true;
    for(int i=0;i<n;i++)
    {
        k=1;
        for(int j=0;j<n;j++)
        {
            if(i==j) ++j;
            if(*(arr+i)==*(arr+j)) k++;
        }
        if(*(arr+i)!=k)
        {
            czy=false;
            break;
        }
    }
    return czy;
}
int main()
{
    int* arr=new int[10]{1,2,3,4,4,3,2,4,3,4};
    cout<<czy_pierwsza(arr,10);
    delete[] arr;
}
