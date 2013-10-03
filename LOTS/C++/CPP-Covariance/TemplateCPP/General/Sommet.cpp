#include "Sommet.h"
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>


using namespace std;

namespace general{


  Sommet::Sommet ( ) {
  }

  Sommet::Sommet(Graphe* graphe, string x, string y)
  {
    graphe_sommet = graphe;
    x=x;
    y=y;
    ensembleAretes = new vector<Arete*>();
  }

  Sommet::~Sommet ( ) {
    ensembleAretes = new vector<Arete*>();
  }


  Graphe* Sommet::getGraphe(){
    return graphe_sommet;
  }


  void Sommet::addAretes(Arete* arete){
    ensembleAretes->push_back(arete);
  }

  void Sommet::addAretes(Arete* arete,Sommet* sommet){

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


  void Sommet::removeArete(Arete* arete){

    cout << ensembleAretes->size()<< endl;
    if((find(ensembleAretes->begin(), ensembleAretes->end(), arete)) != ensembleAretes->end()){
      cout<<"Arete trouvé et va être supprimé" <<endl;
      vector<Arete*>::iterator it = remove(ensembleAretes->begin(), ensembleAretes->end(), arete);
      ensembleAretes->erase(it, ensembleAretes->end());

      cout << ensembleAretes->size()<< endl;

    }
    else{
      cout<< "L'arete ne se trouve pas au sommet indiqué" <<endl;
    }



  }
}




