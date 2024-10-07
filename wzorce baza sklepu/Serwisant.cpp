#include "Pracownik.h"
#include <string>
#include "Serwisant.h"
#include "Baza.h"
#include "Konto.h"
#include <tuple>
Serwisant::Serwisant(std::string name,int number):Pracownik(name,number)
{

}
std::tuple<Baza,Konto> Serwisant::wykonajPrace(std::string name,bool flag,Baza baza,Konto konto)
{
   Konto k= baza.zmienStan(name,konto);
    return std::make_pair(baza,k);
}
