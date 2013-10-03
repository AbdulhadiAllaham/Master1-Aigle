#ifndef GRAPHE_H
#define GRAPHE_H

#include "../grapheTemplate/GrapheTemplate.h"
#include "../grapheTemplate/AreteTemplate.h"
#include "../grapheTemplate/SommetTemplate.h"

class Sommet;
class Arete;

class Graphe : public grapheTemplate::GrapheTemplate<Graphe,Arete, Sommet>
{
    public:
        Graphe();
        virtual ~Graphe();


    protected:
        virtual Arete* newAr();
        virtual Sommet* newSom(Graphe* gra, string x, string y);
    private:
};

#endif // GRAPHE_H
