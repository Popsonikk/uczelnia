#include <iostream>
#include <thread>
#include <chrono>
#include "Person.h"


using namespace std;

bool alive = true;

void kill(Person * person)
{
    alive = false;
}

int main()
{
    Person osoba("Jacek", 15, 22, Person::Gender::M);
    osoba.setFunction(kill);
    while(alive)
    {
        osoba.advance();
        cout << osoba.details() << endl;
        std::this_thread::sleep_for(std::chrono::seconds(1));
    }
    return 0;
}
