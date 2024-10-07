#include<iostream>
#include<cstdlib> //od funkcji rand
#include <limits>
enum mono{malejacy,staly,rosnacy};
int main()
{
    double arr[]= {1,2,3,1,3,5,6,8,9,2,1,1,4,5};
    int n=sizeof(arr)/sizeof(arr[0]);
    mono m;
    double diff=arr[1]-arr[0];
    int max_dlugosc=0, akt_dlugosc=2,indeks=0;
    if(arr[1]>arr[0])
        m=rosnacy;
    else if(arr[1]<arr[0])
        m=malejacy;
    else
        m=staly;
    for(int i=1;i<n-1;i++)
    {
        double diff=arr[i+1]-arr[i];
        if(diff>0)
        {
            if(m==rosnacy)
                akt_dlugosc++;
            else
            {
                if(akt_dlugosc>max_dlugosc)
                {
                    max_dlugosc=akt_dlugosc;
                    indeks=i-akt_dlugosc;
                }
                m=rosnacy;
                akt_dlugosc=2;
            }
        }
        else if(diff<0)
        {
            if(m==malejacy)
                akt_dlugosc++;
            else
            {
                if(akt_dlugosc>max_dlugosc)
                {
                    max_dlugosc=akt_dlugosc;
                    indeks=i-akt_dlugosc;
                }
                m=malejacy;
                akt_dlugosc=2;
            }
        }
        else
        {
            if(m==staly)
                akt_dlugosc++;
            else
            {
                if(akt_dlugosc>max_dlugosc)
                {
                    max_dlugosc=akt_dlugosc;
                    indeks=i-akt_dlugosc;
                }
                m=staly;
                akt_dlugosc=2;
            }
        }
    }
    std::cout<<"dlugosc "<<max_dlugosc<<" indeks "<<indeks;
    return 0;
}
