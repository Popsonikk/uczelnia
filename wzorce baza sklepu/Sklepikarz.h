//
//
//  Generated by StarUML(tm) C++ Add-In
//
//  @ Project : Untitled
//  @ File Name : Sklepikarz.h
//  @ Date : 28.04.2022
//  @ Author :
//
//


#if !defined(_SKLEPIKARZ_H)
#define _SKLEPIKARZ_H

#include "Pracownik.h"
#include "Baza.h"
#include "Konto.h"

class Sklepikarz : public Pracownik {
    public:
    Sklepikarz(std::string name,int number);
    std::tuple<Baza,Konto> wykonajPrace(std::string name,bool flag,Baza baza,Konto konto,int ilosc,float cena);
};

#endif  //_SKLEPIKARZ_H