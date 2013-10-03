#include <typeinfo>
#include <iostream>
#include <string>
#include <vector>
#include "Molecule.h"
#include "Atome.h"
#include "Liaison.h"

using namespace std;

namespace Chimie{


  Liaison::Liaison ( ) {
  }

  Liaison::Liaison(Sommet* sommet1, Sommet* sommet2)
  {
    if((sommet_1 != sommet_2) && (sommet1->getGraphe() == sommet2->getGraphe()))
      {
	sommet_1=sommet1;
	sommet_2=sommet2;
	sommet1->addAretes(this);
	sommet2->addAretes(this);
	this->graphe_1 = sommet1->getGraphe();
      }
    else{
      cout << "Erreur lors de l'instanciation d'une arete, veuillez vérifier les sommets" << endl;
    }


  }

  Liaison::~Liaison ( ) {
  }



  void Liaison::setSommet1(Sommet* sommet){

    if(typeid(*sommet)==typeid(Atome)){
      sommet_1 = sommet;
    }
    else{
      cout << "Sommet n'est pas de type atome";
    }

  }
  void Liaison::setSommet2(Sommet* sommet){

    if(typeid(*sommet)==typeid(Atome)){
      sommet_2 = sommet;
    }
    else{
      cout << "Sommet n'est pas de type atome";
    }

  }


}
