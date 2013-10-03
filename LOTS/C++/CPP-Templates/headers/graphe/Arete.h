#ifndef ARETE_H
#define ARETE_H

#include "../grapheTemplate/GrapheTemplate.h"
#include "../grapheTemplate/AreteTemplate.h"
#include "../grapheTemplate/SommetTemplate.h"


class Graphe;
class Sommet;

class Arete :public  grapheTemplate::AreteTemplate<Graphe,Arete, Sommet>
{
    public:
        Arete(Sommet * s1 , Sommet *s2);
        Arete();
        virtual ~Arete();
    protected:
    private:
};

#endif // ARETE_H
