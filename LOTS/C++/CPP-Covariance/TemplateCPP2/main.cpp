#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <typeinfo>

#include "General/Arete.h"
#include "General/Graphe.h"
#include "General/Sommet.h"

#include "Chimie/Atome.h"
#include "Chimie/Liaison.h"
#include "Chimie/Molecule.h"



using namespace std;
//using namespace Informatique;
using namespace general;
using namespace Chimie;



int main()
{
    cout << "Hello world!" << endl;

    Graphe* graphe = new Graphe("testgraphe");
    //Graphe* molecule = new Molecule("molecule");
    Graphe* res = new Molecule("testresreau");

    cout << typeid(*res).name() << endl;
    //Graphe* graphe2 = new Molecule("Molecule");
//    Graphe* graphe2 = new Graphe("graphe2");

   //Arete* arete = new Arete();

   // Sommet* sommet1 = new Sommet("1","2");
	//	Sommet* sommet12 = new Sommet("3","4");
//		Sommet* sommet3 = new Sommet(graphe, "4","5");
	//	Sommet* sommet4 = new Sommet(graphe, "8","7");
      //  Sommet* sommet5 = new Sommet(graphe, "3","66");
       // Sommet* sommet6 = new Sommet(graphe, "6","46");
        Sommet* sommet12 = new Sommet(graphe, "3","46");
        Sommet* noeud1 = new Atome(res,"45","45");
        Sommet* noeud2 = new Atome(res,"47","48");

//		Arete* arete1 = new Arete(sommet3,sommet4);
	//	Arete* arete11 = new Arete(sommet5,sommet6);
        Arete* lien = new Liaison(noeud1,noeud2);
		//==arete1->setGraphe(graphe);

		//graphe->addSommet(sommet3);
		//graphe->addSommet(sommet4);
		res -> addSommet(noeud1);
        res -> addSommet(noeud2);
        res -> addSommet(sommet12);
		//graphe->addArrete(arete1);
		//res -> addArrete(lien);
		//graphe->invarianceGraphe();
	//	graphe->removeSommet(sommet3);
	//	graphe->removeSommet(sommet5);
		//graphe->removeArete(arete1);
		//graphe->createArete(sommet5,sommet6);

//		sommet3->addAretes(arete11, sommet12);



    return 0;
}


