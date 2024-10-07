#include <iostream>
#include "Complex.h"

using namespace std;

int main()
{
    Complex kompleks(4.0f, 5.0f);
    Complex uroj2(6.0f, 7.0f);
    cout << kompleks.getReal() << endl;
    cout << kompleks.getImaginary() << endl;
    cout << kompleks.getModule() << endl;
    Complex suma;
    suma = kompleks + uroj2;
    cout << suma.getReal() << endl;
    cout << suma.getImaginary() << endl;
    Complex wynik = kompleks*uroj2;
    cout << wynik;
    return 0;
}
