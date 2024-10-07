#include <iostream>
using namespace std;
void f(char* arr)
{
    int i=0;
    while(*(arr+i))
    {
        if(i==0)
            *arr>='a'?*arr-=32:*arr+=32;
        if(*(arr+i-1)==' '&&i>0)
            *(arr+i)>='a'?*(arr+i)-=32:*(arr+i)+=32;
        i++;

    }
    i=0;
    while(*(arr+i))
    {
        cout<<*(arr+i);
        i++;

    }


}
int main()
{
    char arr[100]="Dark Side of the Moon";
    f(arr);
}
