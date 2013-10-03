#include "../include/chimie/Molecule.h"
#include "../include/chimie/Liaison.h"
#include "../include/chimie/Atome.h"



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


Atome* Molecule::newSom(Molecule g, string x, string y){
        return new Atome(this,x,y);
}
