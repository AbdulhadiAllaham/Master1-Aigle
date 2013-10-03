#include <typeinfo>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include "Reseau.h"
#include "Noeud.h"
#include "Lien.h"

using namespace std;

namespace Informatique{

  Reseau::Reseau(){
    ensembleSommets = new vector<Sommet*>();
    ensembleAretes = new vector<Arete*>();
  }

  Reseau::Reseau(string nom){
    nomgraphe = nom;
    ensembleSommets = new vector<Sommet*>();
    ensembleAretes = new vector<Arete*>();
  }

  Reseau::~Reseau() {
    delete ensembleSommets;
    delete ensembleAretes;
  }


  void Reseau::addSommet(Sommet* sommet){


    if(dynamic_cast<Noeud*>(sommet)){
      ensembleSommets->push_back(sommet);
      cout <<"Sommet a été ajouté avec succès" << endl;
    }
    else
      {
	cout << "Sommet n'est pas un instance de Noead" << endl;
      }

  }



  void Reseau::addArrete(Arete* arete){

    if(dynamic_cast<Lien*>(arete)){

      if(ensembleSommets->empty())
	{
	  cout << "Le graphe ne comporte pas de sommets" << endl;
	}



      if((find(ensembleSommets->begin(), ensembleSommets->end(), arete->getSommet1())) != ensembleSommets->end() && (find(ensembleSommets->begin(), ensembleSommets->end(), arete->getSommet2())) != ensembleSommets->end())
	{
	  cout<< "L'arrete a les memes sommets que le graphe" <<endl;
	  ensembleAretes->push_back(arete);
	  arete->setGraphe(this);

	}
      else
	{
	  cout<<"Le graphe n'a pas les meme sommets que l'arrete" <<endl;
	}

    }

    else{
      cout<<"L'arete n'est pas de type Lien" <<endl;
    }

  }






  void Reseau::createArete(Sommet* sommet1, Sommet* sommet2){

    if(dynamic_cast<Noeud*>(sommet1) && dynamic_cast<Noeud*>(sommet2)){
      if(sommet1 != NULL && sommet2 != NULL){

        Arete* arete = new Arete(sommet1, sommet2);
        this->addArrete(arete);
        cout <<"Arete ajouté" << endl;

      }
      else{
        cout <<"Arret n'a pas pu être créé, problème avec les sommets" << endl;
      }


    }
    else{
      cout<<"Un des sommets  n'est pas de type Noead" <<endl;
    }
  }






}
