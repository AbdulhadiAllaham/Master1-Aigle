#include "../../headers/graphe/Graphe.h"
#include "../../headers/graphe/Sommet.h"
#include "../../headers/graphe/Arete.h"

using namespace std;
using namespace grapheTemplate;


class Arete;

Graphe::Graphe()
{
    //ctor
}

Graphe::~Graphe()
{
    //dtor
}

Arete* arr = new Arete();

Arete* Graphe::newAr() {
		// TODO Auto-generated method stub
		return new Arete();
	}


Sommet* Graphe::newSom(Graphe* gra, string x, string y){
        return new Sommet(this,x,y);
}



