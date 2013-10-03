#ifndef GRAPH_H
#define GRAPH_H

#include "../generalT/GrapheT.h"
#include "../generalT/AreteT.h"
#include "../generalT/SommetT.h"

class Sommet;
class Arret;

class Graph : public generalT::GrapheT<Graph,Arret, Sommet>
{
    public:
        Graph();
        virtual ~Graph();
        virtual Arret* newAr();
        virtual Sommet* newSom(string x, string y);


    protected:


    private:
};

#endif // GRAPH_H
