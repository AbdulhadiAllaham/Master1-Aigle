#include <typeinfo>
#include <iostream>
#include <string>
#include <vector>
#include "Molecule.h"
#include "Atome.h"
#include "Liaison.h"

using namespace std;

namespace Chimie{




  Atome::Atome(){

    ensembleAretes = new vector<Arete*>();
  }

  Atome::Atome(Graphe* graphe,string x,string y){
    graphe_sommet = graphe;
    x=x;
    y=y;
    ensembleAretes = new vector<Arete*>();
  }

  Atome::~Atome() {
    delete ensembleAretes;
  }


  void Atome::addAretes(Arete* arete){

    if(typeid(*arete) == typeid(Liaison)){
      ensembleAretes->push_back(arete);
    }
    else{
      cout << "arete n'est pas de type liaison" << endl;
    }

  }

  void Atome::addAretes(Arete* arete,Sommet* sommet){

    if(typeid(*arete) == typeid(Liaison) && typeid(sommet) == typeid(this)){

      if(this->getGraphe()!=NULL && this->getGraphe() == sommet->getGraphe()){
	cout << "verification des graphes ok" << endl;
	if(arete->getSommet1()!=this && arete->getSommet2()!=sommet){

	  arete->removefromSommets();
	  arete->setSommet1(this);
	  if(sommet != NULL){
            arete->setSommet2(sommet);
	  }
	  ensembleAretes->push_back(arete);
	  cout << "L'arete a été remplacé et ajouté" << endl;

	}
	else{
	  cout << "Veuillez vérifier le graphe de l'arete et des sommets" << endl;
	}

      }
      else{
	cout << "Veuillez vérifier le graphe de l'arete et des sommets" << endl;
      }

    }

    else{
      cout << "Erreur de type" << endl;
    }



  }
}
