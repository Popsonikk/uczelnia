#include <iostream>
#include <vector>
#include <string>

struct Node{
    std::string key;
    std::vector<std::string> values;
};
int hash(std::string key,int size)
{
   unsigned int index = 5381;
   for(char c:key)
       index = ((index << 5) + index)+c;
   return index%size;
}
void dodaj(Node * hashTable,std::string key,std::string value,int size,float &currSize)
{
    int index=hash(key,size);
    for(int i=0;;i++)
    {
        if(hashTable[index].key==key)
        {
            hashTable[index].values.push_back(value);
            return;
        }
        else if(hashTable[index].key=="")
        {
            hashTable[index].key=key;
            hashTable[index].values.push_back(value);
            currSize++;
            return;
        }


        index=(index+3)%size;
    }
}
void dodaj(Node * hashTable,Node &node,int size)
{
    int index=hash(node.key,size);
    for(int i=0;;i++)
    {
        if(hashTable[index].key=="")
        {
            hashTable[index]=node;
            return;
        }
        index=(index+3)%size;
    }
}
Node * resize(Node * hashTable,int size,int currsize)
{
    int newSize = size * 2;
    Node* newTable = new Node[newSize]();
    for (int i = 0, j=0;j<currsize; i++)
    {
        if (hashTable[i].key != "")
        {
            dodaj(newTable, hashTable[i], newSize);
            j++;
        }
    }
    delete[] hashTable;
    return newTable;
}
void pokaz(Node* hashTable,std::string key,int size)
{
    int index=hash(key,size);
    for(int i=0;i<size;i++)
    {
        if(hashTable[index].key==key)
        {
            for(std::vector<std::string>::iterator it=hashTable[index].values.begin();it!=hashTable[index].values.end();++it)
                std::cout<<*it<<' ';
            return;
        }
        index=(index+3)%size;
    }
}

int main()
{
    std::ios_base::sync_with_stdio(false);
    int n;
    std::cin>>n;
    std::cin.ignore();
    std::string x;
    int imieSize=4,nazwiskoSize=4;
    float currImieSize=0,currNazwiskoSize=0;
    Node* hashTableImie=new Node[imieSize]();
    Node* hashTableNazwisko=new Node[nazwiskoSize]();
    for(int i=0;i<n;i++)
    {
        std::getline(std::cin, x);
        if(x=="d")
        {
            std::string imie,nazwisko;
            std::getline(std::cin, imie);
            std::getline(std::cin, nazwisko);
            dodaj(hashTableImie,imie,nazwisko,imieSize,currImieSize);
            dodaj(hashTableNazwisko,nazwisko,imie,nazwiskoSize,currNazwiskoSize);

            if(currImieSize/imieSize>0.8)
            {
                hashTableImie=resize(hashTableImie,imieSize,currImieSize);

                imieSize*=2;
            }
            if(currNazwiskoSize/nazwiskoSize>0.8)
            {
                hashTableNazwisko=resize(hashTableNazwisko,nazwiskoSize,currNazwiskoSize);
                nazwiskoSize*=2;
            }

        }
        else if(x=="i")
        {
            std::string imie;
            std::getline(std::cin, imie);
            pokaz(hashTableImie,imie,imieSize);
        }
        else if(x=="n")
        {
            std::string nazwisko;
            std::getline(std::cin, nazwisko);
            pokaz(hashTableNazwisko,nazwisko,nazwiskoSize);
        }
    }
    delete []hashTableImie;
    delete []hashTableNazwisko;
}
