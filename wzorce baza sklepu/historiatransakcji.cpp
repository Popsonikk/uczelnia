#include "historiatransakcji.h"
#include <string>

HistoriaTransakcji::HistoriaTransakcji(std::string s)
{
    this->s =s;
}

HistoriaTransakcji::~HistoriaTransakcji()
{
    //dtor
}
std::string HistoriaTransakcji::getstr()
{
    return s;
}
