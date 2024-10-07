#include "Person.h"
#include <iostream>



std::string Person::maleNames[10] = {"John", "Leonardo",
    "Dan", "Paul", "Martin", "Robert", "Brown", "Bradd", "Mel", "Gibson"
};

std::string Person::femaleNames[10] = {"Jessica", "Marta",
    "Marysia", "Kasia", "Krystyna", "Janina", "Ela", "Agata", "Wieslawa", "Floriana"
};

Person::Person(std::string name, unsigned int currentAge,
           unsigned int maxAge, Gender gender)
{
    this->name = name;
    this->currentAge = currentAge;
    this->maxAge = maxAge;
    this->gender = gender;
    std::cout << "Przybyl: " << name << std::endl;
}

void Person::advance()
{
    this->currentAge++;
    if(this->currentAge == this->maxAge)
    {
        this->killFunction(this);
    }
}

void Person::setFunction(void (*killFunction)(Person*))
{
    this->killFunction = killFunction;
}

std::string Person::details()
{
    return this->name + " " + std::to_string(this->currentAge);
}
