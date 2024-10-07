#include <iostream>
class Prosto
{
    int x;
    int y;
public:
    Prosto(int x,int y)
    {
        this-> x=x;
        this-> y=y;
    }
    pole()
    {
        return x*y;
    }
};
int main()
{
    int x=5,y=4;
    Prosto figura(5,4);
    std::cout<<figura.pole();
}
