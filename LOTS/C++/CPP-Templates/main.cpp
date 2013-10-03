#include <iostream>

#include "headers/grapheTemplate/GrapheTemplate.h"
#include "headers/grapheTemplate/SommetTemplate.h"
#include "headers/grapheTemplate/AreteTemplate.h"

#include "headers/graphe/Arete.h"
#include "headers/graphe/Graphe.h"
#include "headers/graphe/Sommet.h"

#include "headers/chimie/Liaison.h"
#include "headers/chimie/Atome.h"
#include "headers/chimie/Molecule.h"

#include "headers/informatique/Reseau.h"
#include "headers/informatique/Lien.h"
#include "headers/informatique/Noeud.h"

using namespace std;
using namespace grapheTemplate;


int main()
{

    /*Sommet *s1 = new Sommet();
    Sommet *s2 = new Sommet();
*/
    cout << "-----------Test de Graphe------------" << endl;

    Graphe *graphe = new Graphe();

    Sommet *som = new Sommet(graphe,"1","2");
    Sommet *som2 = new Sommet(graphe,"3","4");
    Arete *ar = new  Arete(som,som2);

    graphe->addSommet(som);
    graphe->addSommet(som2);
    graphe->addArrete(ar);
    graphe->removeArete(ar);

    graphe->createSommet("5","6");
    graphe->createArete(som,som2);
    graphe->invarianceGraphe();
    graphe->removeSommet(som);

    cout << "Test de Chimie" << endl;


    Molecule *mol = new Molecule();
    Atome *atom = new Atome(mol,"1","2");
    Atome *atom2 = new Atome(mol,"3","4");
    Liaison *liai = new Liaison(atom, atom2);

    mol->addSommet(atom);
    mol->addSommet(atom2);
    mol->addArrete(liai);
    mol->removeArete(liai);

    Reseau *reseau = new Reseau();
    Noeud *noeud1 = new Noeud(reseau,"1","2");
    Noeud *noeud2 = new Noeud(reseau,"1","2");
    Lien *lien = new Lien(noeud1,noeud2);

    reseau->addSommet(noeud1);
    reseau->addSommet(noeud2);
    reseau->addArrete(lien);
    reseau->removeArete(lien);

    cout << "Test d'Informatique" << endl;
    Reseau* reseau1 = new Reseau();
		Lien* lien0 = new Lien();
		Noeud* noeud11 = new Noeud(reseau1,"10","11");
		Noeud* noeud21 = new Noeud(reseau1,"5","6");
		Noeud* noeud31 = new Noeud(reseau1,"7","9");

		Lien* lien1 = new Lien(noeud11,noeud21);
		Lien* lien2 = new Lien(noeud1,noeud2);


			reseau->addSommet(noeud31);
//		reseau->addSommet(sommet3);
		reseau->addSommet(noeud11);
		reseau->addSommet(noeud21);
		lien0->setGraphe(reseau);
//		lien0->setGraphe(graphe);
//		lien0->setSommet1(sommet12);
		lien0->setSommet1(noeud11);
		lien0->setSommet2(noeud21);
		reseau->addArrete(lien1);
		reseau->addArrete(lien2);
//		reseau->addArrete(arete11);
//		reseau->removeSommet(sommet3);
//		reseau->removeArete(arete1);
//		reseau->removeSommet(atome2);
		reseau->removeSommet(noeud31);
		//reseau->removeArete(lien1); // désactiver removesommet










    cout << "Fin Main" << endl;
    return 0;
}
