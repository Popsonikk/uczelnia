#include <iostream>
#include <string>
#include <fstream>
using namespace std;

void fun(const string  &tekst, const string &sciezka, size_t liczba_kol )
{
    ofstream plik(sciezka);
    if(!plik.is_open()) return;
   // plik<<tekst;

    size_t pozycja = 0, testowa = 0, poprzednia=0;
    while(testowa != string::npos)
    {
        while(testowa != string::npos) //while skladajacy linie
        {

           if(testowa - poprzednia < liczba_kol) pozycja = testowa;
           else  break;
           testowa = tekst.find(' ',testowa+1);
        }
        plik<<tekst.substr(poprzednia,pozycja - poprzednia)<<'\n';
        poprzednia = pozycja + 1;
    }
    plik.close();

}

int main()
{
    const string tekst ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus pulvinar massa in posuere vestibulum. Aenean et neque vitae felis imperdiet euismod. Proin scelerisque est in diam suscipit, sed mattis massa hendrerit. Curabitur pulvinar interdum suscipit. Praesent tincidunt sed mauris at molestie. Suspendisse potenti. Aenean orci arcu, tempor in maximus et, posuere volutpat neque. Sed varius sapien vitae ipsum euismod,"
                  "ac facilisis erat commodo. Nam blandit mollis libero et elementum. Pellentesque bibendum elit quis mauris mattis, ac tristique lacus aliquet. Aenean faucibus, tortor non consequat luctus, mi "
                  "libero interdum dui, eu commodo ante diam sit amet urna. Praesent nunc lectus, tristique varius velit sit amet, interdum dapibus augue. Curabitur nec leo felis. Mauris sem est, posuere vitae "
                  "interdum ut, vulputate nec arcu. In at cursus purus. Praesent dictum vel mi non malesuada.";
    fun(tekst,"plik.txt",20);
    return 0;
}
