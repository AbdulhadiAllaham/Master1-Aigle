#include "../include/informatique/Lien.h"
#include "../include/informatique/Noeud.h"
#include "../include/informatique/Reseau.h"

Reseau::Reseau()
{
    //ctor
}

Reseau::~Reseau()
{
    //dtor
}


Lien* Reseau::newAr() {
		// TODO Auto-generated method stub
		return new Lien();
	}


Noeud* Reseau::newSom(Reseau g, string x, string y){
        return new Noeud(this,x,y);
}
