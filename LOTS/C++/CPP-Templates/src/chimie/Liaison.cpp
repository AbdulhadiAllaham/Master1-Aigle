#include "../include/chimie/Molecule.h"
#include "../include/chimie/Liaison.h"
#include "../include/chimie/Atome.h"

Liaison::Liaison(){

}

Liaison::Liaison(Atome * s1 , Atome *s2) : AreteT(s1,s2)
{
    //ctor
}

Liaison::~Liaison()
{
    //dtor
}
