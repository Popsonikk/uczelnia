#include <iostream>
#include <cstring>
using namespace std;
int main()
{
    char arr[]="jakis napis";
    int lenght=sizeof(arr)/sizeof(arr[0]);
    int counter[128]={0};
    int licz=0;
    for(int i=0;arr[i]!='\0';i++)
    {
        if(arr[i]>='A'&&arr[i]<='Z')
            counter[arr[i]+32]++;
        else
            counter[arr[i]]++;
    }
    for(int i=0;i<128;i++)
    {
        if(counter[i]>licz)
            licz=counter[i];
    }
    for(int i=0;i<128;i++)
    {
        if(counter[i]==licz);
        {
            cout<<(char)i<<" "<<counter[i]<<"\n";
        }
    }
}
