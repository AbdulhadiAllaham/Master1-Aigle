#ifndef SOMMET_H
#define SOMMET_H

#include "../generalT/GrapheT.h"
#include "../generalT/AreteT.h"
#include "../generalT/SommetT.h"
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>


class Arret;
class Graph;

class Sommet : public  generalT::SommetT<Graph,Arret,Sommet>
{
    public:
        Sommet();
        Sommet(Graph * gra, string x, string y);
        virtual ~Sommet();

    protected:
    private:
};

#endif // SOMMET_H
