#include "Pracownik.h"
#include <string>
#include "Sklepikarz.h"
#include "Baza.h"
#include "Konto.h"
#include <tuple>
Sklepikarz::Sklepikarz(std::string name,int number):Pracownik(name,number)
{

}
std::tuple<Baza,Konto> Sklepikarz::wykonajPrace(std::string name,bool flag,Baza baza,Konto konto,int ilosc,float cena)
{
    if(flag)
    {
         Konto k= baza.dodaj(name,konto,ilosc,cena);
         return std::make_pair(baza,k);
    }

    else
    {
          Konto k= baza.odejmij(name,konto);
          return std::make_pair(baza,k);
    }


}
