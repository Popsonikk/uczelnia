#include <iostream>
class Zespolone
{
    float re,im;
public:
    Zespolone(){re=0,im=0;}
    Zespolone(float x,float y)
    {
        this-> re=x;
        this ->im=y;
    }
    void setre(float x) {this-> re=x;}
    void setim(float y) {this-> im=y;}
    float getre(){return re;}
    float getim(){return im;}

};
Zespolone toadd(Zespolone &x,Zespolone &y)
    {
        return Zespolone(x.getre()+y.getre(),x.getim()+y.getim());
    }

int main()
{
    Zespolone liczba1(3,4);
    Zespolone liczba2(7,-2);
    Zespolone suma =toadd(liczba1,liczba2);

}
