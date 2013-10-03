#include <typeinfo>
#include <iostream>
#include <string>
#include <vector>
#include "Reseau.h"
#include "Lien.h"
#include "Noeud.h"

using namespace std;

namespace Informatique{


  Lien::Lien ( ) {
  }

  Lien::Lien(Sommet* sommet1, Sommet* sommet2)
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

  Lien::~Lien ( ) {
  }



  void Lien::setSommet1(Sommet* sommet){

    //Noeud* noeud;
    if(typeid(*sommet)==typeid(Noeud)){
      sommet_1 = sommet;
    }
    else{
      cout << "Sommet n'est pas de type Noeud";
    }

  }
  void Lien::setSommet2(Sommet* sommet){


    if(typeid(*sommet)==typeid(Noeud)){
      sommet_2 = sommet;
    }
    else{
      cout << "Sommet n'est pas de type Noeud";
    }

  }


}
