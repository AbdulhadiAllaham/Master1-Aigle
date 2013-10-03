#include "../include/general/Arret.h"
#include "../include/general/Sommet.h"
#include "../include/general/Graph.h"


Arret::Arret()
{
    //ctor
}

Arret::Arret(Sommet * s1 , Sommet *s2) : AreteT(s1,s2)
{
    //ctor
}

Arret::~Arret()
{
    //dtor
}
