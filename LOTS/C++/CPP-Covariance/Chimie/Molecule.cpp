#include <typeinfo>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include "Molecule.h"
#include "Atome.h"
#include "Liaison.h"

using namespace std;

namespace Chimie{

  Molecule::Molecule(){
    ensembleSommets = new vector<Sommet*>();
    ensembleAretes = new vector<Arete*>();
  }

  Molecule::Molecule(string nom){
    nomgraphe = nom;
    ensembleSommets = new vector<Sommet*>();
    ensembleAretes = new vector<Arete*>();
  }

  Molecule::~Molecule() {
    delete ensembleSommets;
    delete ensembleAretes;
  }


  void Molecule::addSommet(Sommet* sommet){

    if(dynamic_cast<Atome*>(sommet)){
      ensembleSommets->push_back(sommet);
      cout <<"Sommet a été ajouté avec succès" << endl;
      cout << ensembleSommets->size()<< endl;
    }
    else
      {
	cout << "Sommet n'est pas un instance d'Atome" << endl;
      }

  }



  void Molecule::addArrete(Arete* arete){

    if( dynamic_cast<Liaison*>(arete)){

 //  if(typeid(*arete) == typeid(Liaison)){


      if(ensembleSommets->empty())
	{
	  cout << "Le graphe ne comporte pas de sommets" << endl;
	}

      cout << ensembleSommets->size()<< endl;


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
      cout<<"L'arete n'est pas de type liaison" <<endl;
    }

  }






  void Molecule::createArete(Sommet* sommet1, Sommet* sommet2){

      if(dynamic_cast<Atome*>(sommet1) &&  dynamic_cast<Atome*>(sommet2)){

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
      cout<<"Un des sommets  n'est pas de type atome" <<endl;
    }
  }






}
