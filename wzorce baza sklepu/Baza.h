//
//
//  Generated by StarUML(tm) C++ Add-In
//
//  @ Project : Untitled
//  @ File Name : Baza.h
//  @ Date : 28.04.2022
//  @ Author :
//
//


#if !defined(_BAZA_H)
#define _BAZA_H

#include "Towar.h"
#include "Konto.h"
#include <string>
#include <vector>
#include <tuple>

class Baza {
public:
    void znajdz(std::string nazwa,float cena);
	void SprawdzDostepnoscKatalogu();
	void PokazSzczegoloweDane();
	Konto zmienStan(std::string nazwa,Konto konto);
	Konto odejmij(std::string nazwa,Konto konto);
	Konto dodaj (std::string nazwa,Konto konto,int ilosc,float cena);
	Baza();
private:
	std::vector<Towar> nazwy;
	std::vector<int> stan;
};

#endif  //_BAZA_H
