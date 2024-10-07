#include <ostream>



class Complex{
private:
    float re, im;
public:
    Complex();
    Complex(float re, float im);
    float getReal() const;
    float getImaginary() const;
    float getModule() const;
    Complex addComplex(const Complex& toAdd) const;
    Complex operator*(const Complex& toMultiply) const;
    Complex operator+(const Complex& toAdd) const;
};

std::ostream& operator<<(std::ostream& os, const Complex& value);
