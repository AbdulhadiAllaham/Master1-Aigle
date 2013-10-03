#include "../../headers/graphe/Graphe.h"
#include "../../headers/graphe/Sommet.h"
#include "../../headers/graphe/Arete.h"


Arete::Arete()
{
    //ctor
}

Arete::Arete(Sommet * s1 , Sommet *s2) : AreteTemplate(s1,s2)
{
    //ctor
}

Arete::~Arete()
{
    //dtor
}
