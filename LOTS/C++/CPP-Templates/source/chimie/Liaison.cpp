#include "../../headers/chimie/Molecule.h"
#include "../../headers/chimie/Liaison.h"
#include "../../headers/chimie/Atome.h"

Liaison::Liaison(){

}

Liaison::Liaison(Atome * s1 , Atome *s2) : AreteTemplate(s1,s2)
{
    //ctor
}

Liaison::~Liaison()
{
    //dtor
}
