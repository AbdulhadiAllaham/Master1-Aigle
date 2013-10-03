#include <typeinfo>
#include <iostream>
#include <string>
#include <vector>
#include "Reseau.h"
#include "Noeud.h"
#include "Lien.h"

using namespace std;

namespace Informatique{

  Lien liaiso;


  Noeud::Noeud(){

    ensembleAretes = new vector<Arete*>();
  }

  Noeud::Noeud(Graphe* graphe,string x,string y){
    graphe_sommet = graphe;
    x=x;
    y=y;
    ensembleAretes = new vector<Arete*>();
  }

  Noeud::~Noeud() {
    delete ensembleAretes;
  }


  void Noeud::addAretes(Arete* arete){

    Lien* lien;
    if(typeid(*arete) == typeid(Lien)){
      ensembleAretes->push_back(arete);
    }
    else{
      cout << "arete n'est pas de type Lien" << endl;
    }

  }

  void Noeud::addAretes(Arete* arete,Sommet* sommet){

    Lien* lien;
    if(typeid(*arete) == typeid(Lien) && typeid(*sommet) == typeid(this)){

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
