#ifndef HISTORIATRANSAKCJI_H
#define HISTORIATRANSAKCJI_H
#include <string>

class HistoriaTransakcji
{
    public:
        HistoriaTransakcji(std::string s);
        std::string getstr();
        virtual ~HistoriaTransakcji();

    protected:

    private:
    std::string s;
};

#endif // HISTORIATRANSAKCJI_H
