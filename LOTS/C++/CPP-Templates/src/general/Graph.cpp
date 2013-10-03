#include "../include/general/Graph.h"
#include "../include/general/Arret.h"
#include "../include/general/Sommet.h"
using namespace std;
using namespace generalT;


class Arret;

Graph::Graph()
{
    //ctor
}

Graph::~Graph()
{
    //dtor
}

Arret* arr = new Arret();

Arret* Graph::newAr() {
		// TODO Auto-generated method stub
		return new Arret();
	}


Sommet* Graph::newSom(string x, string y){
        return new Sommet(this,x,y);
}



