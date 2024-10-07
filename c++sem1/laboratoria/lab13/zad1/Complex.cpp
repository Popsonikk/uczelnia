#include "Complex.h"
#include <cmath>

Complex::Complex()
{
    re = 0;
    im = 0;
}

Complex::Complex(float re, float im)
{
    this->re = re;
    this->im = im;
}

float Complex::getReal() const
{
    return re;
}

float Complex::getImaginary() const
{
    return im;
}

float Complex::getModule() const
{
    return sqrt(re*re + im*im);
}

Complex Complex::addComplex(const Complex& toAdd) const
{
    return Complex(this->re+toAdd.re, this->im+toAdd.im);
}

Complex Complex::operator+(const Complex& toAdd) const
{
    return this->addComplex(toAdd);
}

Complex Complex::operator*(const Complex& toMultiply) const
{
    return Complex(this->re * toMultiply.re - this->im * toMultiply.im,
                    this->re * toMultiply.re + this->im * toMultiply.im);
}


std::ostream& operator<<(std::ostream& os, const Complex& value)
{
    os << "Real: " << value.getReal() << std::endl;
    os << "Imaginary: " << value.getImaginary() << std::endl;
    return os;
}
