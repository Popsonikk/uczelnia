#include <iostream>
#include <cstdlib>
using namespace std;
int compare(const void *v1, const void *v2)
{
    int *a,*b;
    a=*(int**)v1;
    b=*(int**)v2;
    if(*a==*b)return 0;
    else if (*a<*b) return 1;
    else return-1;
}
int main()
{
   int arr[5]={1,3,2,5,1};
   int *wsk[5];
   for(int i=0;i<5;i++)
   {
       *(wsk+i)=&arr[i];
   }
   qsort(wsk,5,sizeof(int*),compare);
   for(int i=0;i<5;i++)
   {
       cout<<**(wsk+i)<<' ';
   }
}

