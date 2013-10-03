#include "../../headers/chimie/Molecule.h"
#include "../../headers/chimie/Liaison.h"
#include "../../headers/chimie/Atome.h"



Molecule::Molecule()
{
    //ctor
}

Molecule::~Molecule()
{
    //dtor
}


Liaison* Molecule::newAr() {
		// TODO Auto-generated method stub
		return new Liaison();
	}


Atome* Molecule::newSom(Molecule* g, string x, string y){
        return new Atome(this,x,y);
}
