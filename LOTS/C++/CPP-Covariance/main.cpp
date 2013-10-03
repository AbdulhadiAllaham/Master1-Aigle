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

#include "Informatique/Noeud.h"
#include "Informatique/Lien.h"
#include "Informatique/Reseau.h"

using namespace std;
using namespace general;
using namespace Chimie;
using namespace Informatique;



int main()
{

    cout << "------------Test de Graphe------------" << endl;
    Graphe* graphe = new Graphe("testgraphe");
    //Graphe* molecule = new Molecule("molecule");
    Graphe* mol = new Molecule("testresreau");
    Reseau* reseau = new Reseau("testresreau");

//    cout << typeid(*res).name() << endl;


		Sommet* sommet3 = new Sommet(graphe, "4","5");
		Sommet* sommet4 = new Sommet(graphe, "8","7");
        Sommet* sommet5 = new Sommet(graphe, "3","66");
        Sommet* sommet6 = new Sommet(graphe, "6","46");
        Sommet* sommet12 = new Sommet(graphe, "3","46");
        Sommet* atome1 = new Atome(mol,"45","45");
        Sommet* atome2 = new Atome(mol,"47","48");

		Arete* arete1 = new Arete(sommet3,sommet4);
		Arete* arete11 = new Arete(sommet5,sommet6);
      //  Arete* liaison = new Liaison(noeud1,noeud2);
        graphe->addArrete(arete1);

		graphe->addSommet(sommet3);
		graphe->addSommet(sommet4);
		graphe->addSommet(sommet5);
		graphe->addSommet(sommet6);
        mol -> addSommet(atome1);
        mol -> addSommet(atome2);
        mol -> addSommet(sommet12);
        graphe->addArrete(arete1);
		graphe->invarianceGraphe();
		//graphe->removeSommet(sommet3);
		//graphe->removeSommet(sommet5);
		//graphe->removeArete(arete1);
		graphe->createArete(sommet5,sommet6);

		sommet3->addAretes(arete11, sommet12);


		cout << "------------Test de inforamtique------------" << endl;
		Graphe* reseau1 = new Reseau("Reseau");
		Arete* lien0 = new Lien();
		Sommet* noeud1 = new Noeud(reseau1,"10","11");
		Sommet* noeud2 = new Noeud(reseau1,"5","6");
		Sommet* noeud3 = new Noeud(reseau1,"7","9");

		Arete* lien1 = new Lien(noeud2,noeud3);
		Lien* lien2 = new Lien(noeud1,noeud2);

		reseau->addSommet(noeud3);
		reseau->addSommet(sommet3);
		reseau->addSommet(noeud1);
		reseau->addSommet(noeud2);
		lien0->setGraphe(reseau);
		lien0->setGraphe(graphe);
		lien0->setSommet1(sommet12);
		lien0->setSommet1(noeud1);
		lien0->setSommet2(noeud2);
		reseau->addArrete(lien1);
		reseau->addArrete(lien2);
		reseau->addArrete(arete11);
		reseau->removeSommet(sommet3);
		reseau->removeArete(arete1);
		reseau->removeSommet(atome2);
		reseau->removeSommet(noeud3);
		reseau->removeArete(lien1); // désactiver removesommet
		reseau->invarianceGraphe();
		lien0->invarianceArrete();



    return 0;
}


