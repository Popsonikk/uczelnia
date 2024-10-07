#include <iostream>
#include <cmath>
#include <limits.h>
using namespace std;
float dystans(float *pkt_1, float *pkt_2)
{
 return hypot(pkt_1[0]-pkt_2[0],pkt_1[1]-pkt_2[1]);
 // tab[0] = *tab, tab[1] = *(tab+1)
}
float funkcja_1(float *poczatek_tablicy, float rozmiar_tablicy, float *&a,
float *&b)
{
 float min=FLT_MAX;
 for (int i=0; i<rozmiar_tablicy; i+=2)
 {
 for (int j=i+2; j<rozmiar_tablicy; j+=2)
 {
 // dystans(&poczatek_tablicy[i],&poczatek_tablicy[j])
 float tmp = dystans(poczatek_tablicy+i, poczatek_tablicy+j);
 if(tmp <min)
 {
 min=tmp;
 a=poczatek_tablicy+i;
 b=poczatek_tablicy+j;
 }
 }
 }
 return min;
}
int main()
{
 float tablica[20];
 for (int a=0; a<20; a++)
 {
 tablica[a]=rand()%50;
 cout << tablica[a] << (a%2?" ":" ");
 }
 float *a, *b;
 cout << funkcja_1(tablica, 20, a, b) << endl;
 cout << endl << a[0] << " " << a[1] << " " << b[0] << " " << b[1]
<< endl;
