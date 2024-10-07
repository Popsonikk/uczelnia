#ifndef ARRAY_H_INCLUDED
#define ARRAY_H_INCLUDED
#include <cstddef>//size_t

class Array
{
    unsigned int *arr;
    size_t n;
public:
    Array(size_t n);
    unsigned int &at(size_t i);
    //size_t n() const;
};


#endif // ARRAY_H_INCLUDED
