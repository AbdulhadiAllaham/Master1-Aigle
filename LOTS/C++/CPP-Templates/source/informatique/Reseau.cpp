#include "../../headers/informatique/Reseau.h"
#include "../../headers/informatique/Noeud.h"
#include "../../headers/informatique/Lien.h"

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


Noeud* Reseau::newSom(Reseau* g, string x, string y){
        return new Noeud(this,x,y);
}
