#include <iostream>
#include <cstdio>
class Venc
{
    int *vec;
    int n;
public:

    Venc(int n)
    {
        this -> n=n;
        vec=new int[n];
    }
    int &setv(int i)
    {
        return vec[i];
    }
    int getv(int i)
    {
        return vec[i];
    }
     int getn()
    {
        return n;
    }

    ~Venc()
    {
            delete[]vec;
    }

};
class Matrix
{
    int *mat;
    int n;
public:

    Matrix(int n)
    {
        this->n=n;
        mat=new int[n*n];
    }
    int &setmat(int i,int j)
    {
        return mat[i*n+j];
    }
     int getmat(int i,int j)
    {
        return mat[i*n+j];
    }
    int getn()
    {
        return n;
    }

    ~Matrix()
    {
        delete []mat;
    }
};
void mul (Matrix *mat,Venc *vec ,Venc *suma)
{
    for(int i=0;i<vec->getn();i++)
    {
       suma->setv(i)=0;
    }
    for(int i=0;i<vec->getn();i++)
    {
       for(int j=0;j<vec->getn();j++)
        {
        suma->setv(i)+=vec->getv(j)*mat->getmat(i,j);
        }
        std::cout<<suma->getv(i)<<' ';
    }
}
int main()
{
    int n=3;
    Venc *vec=new Venc(n);
    for(int i=0;i<n;i++)
    {
        vec->setv(i)=rand()%10;
    }
    Matrix *mat=new Matrix(n);
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
        mat->setmat(i,j)=rand()%10;
        }
    }
    for(int i=0;i<n;i++)
    {
       std::cout<< vec->getv(i)<<' ';
    }
    std::cout<<std::endl;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            std::cout<<mat->getmat(i,j)<<' ';
        }
        std::cout<<std::endl;
    }
    Venc suma=Venc(n);
    mul(mat,vec,&suma);
    delete[]vec;
    delete[]mat;
    return 0;

}
