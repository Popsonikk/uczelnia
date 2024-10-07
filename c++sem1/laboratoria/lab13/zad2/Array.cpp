#include "Array.h"
Array::Array(size_t n)
{
    this -> n=n;
    arr=new unsigned int [n];
}
unsigned int &Array::at(size_t i)
{
     return arr[i];
}
