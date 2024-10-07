#include <string>


class Person
{
public:
    enum Gender{M, F};
private:
    std::string name;
    unsigned int currentAge;
    unsigned int maxAge;
    Gender gender;

    void (*killFunction)(Person * person);

    static std::string maleNames[10];
    static std::string femaleNames[10];
public:


    Person(std::string name, unsigned int currentAge,
           unsigned int maxAge, Gender gender);
    void advance();
    void setFunction(void (*killFunction)(Person*));
    std::string details();


};
