#include <iostream>
using namespace std;

int* sort(int tab[],int n,bool &zmiana)
{
    for(int i=0;i<n;i++)
        for(int j=n-1;j>=i;j--)
            if(arr[i]%2==1&&arr[j]%2==0)
                {
                    int tmp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=tmp;
                    zmiana=true;
                }
}
int main()
{

}
