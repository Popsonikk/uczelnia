//
//
//  Generated by StarUML(tm) C++ Add-In
//
//  @ Project : Untitled
//  @ File Name : Wlasciciel.cpp
//  @ Date : 28.04.2022
//  @ Author :
//
//


#include "Wlasciciel.h"
#include "Baza.h"
#include "Konto.h"
#include "Towar.h"
#include "Serwisant.h"
#include "Sklepikarz.h"
#include<string>
#include<iostream>

void Wlasciciel::ZmienCene(std::string nazwa,float cena) {

    baza.znajdz(nazwa,cena);
}


Wlasciciel::Wlasciciel(std::string name,Baza baza,Konto konto)
{
    this->name=name;
    this->baza=baza;
    this->konto=konto;


}
void Wlasciciel::setBaza(Baza baza)
{
    this->baza=baza;
}
void Wlasciciel::setKonto(Konto konto)
{
        this->konto=konto;
}
Konto Wlasciciel::getKonto()
{
    return konto;
}
Baza Wlasciciel::getBaza()
{
    return baza;
}
void Wlasciciel::showHistory()
{
    std::cout<<"Historia"<<'\n';
    for(int i=0;i<hisT.size();i++)
        std::cout<<hisT.at(i).getstr()<<'\n';
}
void Wlasciciel::addHistory(std::string name)
{
    hisT.push_back(HistoriaTransakcji(name));
}


