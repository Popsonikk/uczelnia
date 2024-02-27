#include <iostream>
template<class T>
class Wektor
{
private:
    T *array;
    int max_size;
    int now_size;
    T* it;
public:

    Wektor()
    {
        this->array=new T[10];
        this->max_size=10;
        this->now_size=0;
        this->it=array;
    }

    int size()
    {
        return now_size;
    }
    void push_back(T elem)
    {
       if(max_size==now_size)
       {
           T *pom =new T [max_size];
           for(int i=0;i<now_size;i++)
           {
              pom[i]=array[i];
           }
           delete [] array;
           array=new T [max_size*=2];
           for(int i=0;i<now_size;i++)
           {
              array[i]=pom[i];
           }
           array[now_size]=elem;
           now_size++;
           delete [] pom;
           this->it=array;

       }
       else
       {
           array[now_size]=elem;
           now_size++;
       }
    }


    T operator[](int n)
    {
        return array[n];
    }
    T *  begin()
    {
        return it;
    }
    T * end()
    {
        return it+now_size;
    }






};


int main()
{
    std::ios_base::sync_with_stdio(false);
    Wektor<unsigned int> wektor;
    unsigned int a;
    std::cin>>a;
    while(a!=0)
    {
        wektor.push_back(a);
        std::cin>>a;
    }
    for(int i=wektor.size()-1;i>=0;i--)
        std::cout<<wektor[i]<<' ';


}
