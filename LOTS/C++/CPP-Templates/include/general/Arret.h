#ifndef ARRET_H
#define ARRET_H

#include "../generalT/GrapheT.h"
#include "../generalT/AreteT.h"
#include "../generalT/SommetT.h"


class Graph;
class Sommet;

class Arret :public  generalT::AreteT<Graph,Arret, Sommet>
{
    public:
        Arret(Sommet * s1 , Sommet *s2);
        Arret();
        virtual ~Arret();
    protected:
    private:
};

#endif // ARRET_H
