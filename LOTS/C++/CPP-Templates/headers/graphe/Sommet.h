#ifndef SOMMET_H
#define SOMMET_H

#include "../grapheTemplate/GrapheTemplate.h"
#include "../grapheTemplate/AreteTemplate.h"
#include "../grapheTemplate/SommetTemplate.h"
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>


class Arete;
class Graph;

class Sommet : public  grapheTemplate::SommetTemplate<Graphe,Arete,Sommet>
{
    public:
        Sommet();
        Sommet(Graphe * gra, string x, string y);
        virtual ~Sommet();

    protected:
    private:
};

#endif // SOMMET_H
