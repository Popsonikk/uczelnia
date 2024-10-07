#include <iostream>
using namespace std;
void stado(int nrok,int npora, float populacja,int rok,int pora)
{
   switch(npora)
   {
       case 0: populacja*=1.5, npora++; break;
       case 1: npora++; break;
       case 2: populacja-=10, npora++ ; break;
       case 3: populacja*=0.6,npora=0; nrok++;
   }
   if(nrok<rok||(nrok==rok&&npora<=pora))
        stado(nrok,npora,populacja,rok,pora);
   else
        cout<<"populacja wyniosla "<<(int)(populacja);
}
int main()
{
    int rok,pora;
    float populacja;
    cout<<"Podaj rok i pora i populacja ";
    cin>>rok>>pora>>populacja;
    stado(1,0,populacja,rok,pora);
}
