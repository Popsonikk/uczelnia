#include <iostream>
#include <string>
struct Flower{   // struktura do przechowania danych z zadania
    std::string name;
    int counts;
};
template <typename T>
class ArrayList{ //lista tablicowa
private:
    int array_capacity, elements_counter;
    T *array;
public:
    ArrayList( int array_capacity):
        array_capacity(array_capacity),
        elements_counter(0),
        array(new T[array_capacity])
        {}
    ArrayList():
        array_capacity(1),
        elements_counter(0),
        array(new T[array_capacity])
        {}
   void push_back(T new_element){ //wstaw na koniec
        if (elements_counter == array_capacity){
            array_capacity *= 2;
            T *temp_array = new T[array_capacity];
            for ( int i = 0; i < elements_counter; ++i){
                temp_array[i] = array[i];
            }
            delete [] array;
            array = temp_array;
        }
        array[elements_counter++] = new_element;
    }
    void insert(T element , int id) //wstaw gdziekolwiek
    {
         if (elements_counter == array_capacity){
            array_capacity *= 2;
            T *temp_array = new T[array_capacity];
            for ( int i = 0; i < elements_counter; ++i){
                temp_array[i] = array[i];
            }
            delete [] array;
            array = temp_array;
        }
        for(int i=elements_counter;i>id;i--)
            array[i]=array[i-1];
        array[id] =element;
        elements_counter++;
    }
    void erase(int id) //usun gdziekolwiek
    {
        for(int i=id;i<elements_counter-1;i++)
            array[i]=array[i+1];
        elements_counter--;
    }
    T &at( int id) const{ //zwroc dowolny
        return array[id];
    }
    T &front() const{ //zwroc pierwszy
        return array[0];
    }
    T &back() const{ //zwroc ostatni
        return array[elements_counter - 1];
    }
    void replace(T element ,int id) //zamien w wskazanym miejscu
    {
        array[id]=element;
    }

     void pop_front() //usun pierwszy
    {
        for(int i=0;i<elements_counter-1;i++)
            array[i]=array[i+1];
        elements_counter--;
    }
    bool empty(){ //sprawdz czy pusty
        return elements_counter == 0;
    }
    int size() const{ //zwroc obecna wielkosc
        return elements_counter;
    }
    int capacity() const{ //zwroc zadeklarowany rozmiar
        return array_capacity;
    }
};
struct IndexFlowers{
    ArrayList <Flower> Flowers;
    int index;
};

int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);  //do sprawdzarki
    int n,m;
    int rc=0; // zsumowana wartosc powierzchni wskazanych roslin
    Flower flower;
    std::cin>>n; // rozmiar listy glownej
    ArrayList<IndexFlowers> lista(n); //lista glowna
   // ArrayList<int> rabatID(n); //pomocnicza lista do przechowania indexow ostatnio ogladanych roslin w podliscie
    for(int i=0;i<n;i++)
    {
        std::cin>>m;//rozmiar podlisty
        ArrayList <Flower> flowers(m); //podlista
        for(int j=0;j<m;j++)
        {
            std::cin>>flower.name>>flower.counts;
            flowers.push_back(flower); //wczytanie i wlozenie rosliny do podlisty
            if(j==0)
            {
                rc+=flower.counts; //sumowanie obszaru zajetego przez rosliny
                //rabatID.push_back(0); //indeks w podliscie 0 bo nic jeszcze nie prezegladalismy
            }
        }
        IndexFlowers infl={flowers,0};
        lista.push_back(infl); //wlozenie listy roslin do glownej listy gatonkow
    }
    std::cin>>n;
    ArrayList <int> rabat(n);
    for(int i=0;i<rabat.capacity();i++)
    {
        std::cin>>n;
        rabat.push_back(n);
    }
    std::cin>>m; //wczytanie sygnalow sterujacych
    m*=2;
    int *signal= new int[m];
    for(int i=0;i<m;i+=2)
        std::cin>>signal[i]>>signal[i+1];
    int posx=0,posy=0; //zmienne do poruszania sie po liscie
    int id,l,p,sr; //zmienie do wyszukiwania binarnefo zapelnioneh rabaty
    int j=0,i=0;
    l=0,p=rabat.size();
    int pom; //zmienna pomocnicza
    bool flag=true,flag1;
    while(!lista.empty()&&flag) //glowna petla dziala gdy glowna lista nie jest pusta i wykonuje sie jeden z ponizszych if
    {
       flag=false;
        id=-1;
        flag1=rc>=rabat.front()&&rc<=rabat.back();
        while(l<=p&&flag1)
        {
            sr = (l + p)/2;
            if(rabat.at(sr)==rc)
            {
                id=sr;
                break;
            }
            if(rabat.at(sr)>rc)
                p=sr-1;
            else
                l=sr+1;
        }
        if(id==-1&&i<m) //jezeli nie znalezlismy zapelnionej rabaty to uzywamy sygnalow sterujacych
        {
            flag=true;
            pom=rc;
            posx+=signal[i]; //pozycja w glownej liscie
            posx%=lista.size(); //%n by nie wyjsc poza zakres
            posy=lista.at(posx).index; //pozycja ostatnio przegladana w podliscie
            rc-=lista.at(posx).Flowers.at(posy).counts; //zmiana przegladanej rosliny wiec zmiana sumy powierzni
            posy+=signal[i+1];//zmiana pozycji w podliscie
            posy%=lista.at(posx).Flowers.size();
            lista.at(posx).index=posy;
            i+=2;
            rc=rc+lista.at(posx).Flowers.at(posy).counts;
             if(pom>rc)
            {

                if(rc<rabat.at(rabat.size()/2)&&p>rabat.size()/2)
                    p=rabat.size()/2;
                l=0;
            }

            else
            {

                if(rc>rabat.at(rabat.size()/2)&&l<rabat.size()/2)
                    l=rabat.size()/2;
                p=rabat.size();
            }
        }
        else if(id>-1&&!rabat.empty()) //wyszukiwanie binarne znalazlo zapelniona rabate
        {
            flag=true;
            pom=rc;
            std::cout<<rabat.at(id)<<' '; //wyswietlenie wartosci zapelnionej rabaty
            rabat.erase(id);
            rc=0;//zerowanie powierzchni bo usuwamy rosliny ktore zapelnily pole rabaty
            for( int k=0;k<lista.size();k++)
            {
                pom=lista.at(k).index;
                std::cout<<lista.at(k).Flowers.at(pom).name<<' '; //wyswietlanie uzytych nazw roslin
                lista.at(k).Flowers.erase(pom);// i ich usuniecie
                if(lista.at(k).Flowers.size()==0) //jezeli po usunieciu rosliny podlista ma dlugosc 0 usuwamy ja calkowicie
                {
                    lista.erase(k);
                    if(k<posx)
                        posx--;
                    k--;
                }
                else //jezeli nie to sumujemy wartosc kolejnej rosliny w tej podliscie
                {
                    if(pom==lista.at(k).Flowers.size())
                        pom=0;
                    rc+=lista.at(k).Flowers.at(pom).counts;
                    lista.at(k).index=pom;
                }

            }
             if(pom>rc)
            {

                if(rc<rabat.at(rabat.size()/2)&&p>rabat.size()/2)
                    p=rabat.size()/2;
                l=0;
            }

            else
            {

                if(rc>rabat.at(rabat.size()/2)&&l<rabat.size()/2)
                    l=rabat.size()/2;
                p=rabat.size();
            }

            std::cout<<"\n"; //nowa linia bo tak chce zadanie
        }
    }
    delete []signal;

}
