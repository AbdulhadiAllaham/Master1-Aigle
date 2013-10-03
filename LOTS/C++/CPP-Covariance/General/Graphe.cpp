#include "Graphe.h"
#include "Arete.h"
#include "Sommet.h"
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

namespace general{


  Graphe::Graphe ( ) {
    ensembleSommets = new vector<Sommet*>();
    ensembleAretes = new vector<Arete*>();
  }

  Graphe::Graphe(string nom)
  {
    nomgraphe = nom;
    ensembleSommets = new vector<Sommet*>();
    ensembleAretes = new vector<Arete*>();
  }



  Graphe::~Graphe ( ) {
  }

  Sommet* sommet2;

  void Graphe::addSommet(Sommet* sommet){
    ensembleSommets->push_back(sommet);
    cout <<"Sommet a été ajouté avec succès" << endl;
    //cout << ensembleSommets->size()<< endl;
  }

  void Graphe::addArrete(Arete* arete){

    if(ensembleSommets->empty())
      {
	cout << "Le graphe ne comporte pas de sommets" << endl;
	cout << "Le graphe ne comporte pas de sommets" << endl;
      }

    //cout << ensembleSommets->size()<< endl;


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

  void Graphe::removeSommet(Sommet* sommet){

    if((find(ensembleSommets->begin(), ensembleSommets->end(), sommet)) != ensembleSommets->end()){
      cout<<"Sommet trouvé et va être supprimé" <<endl;
      vector<Sommet*>::iterator it = remove(ensembleSommets->begin(), ensembleSommets->end(), sommet);
      ensembleSommets->erase(it, ensembleSommets->end());

     // cout << ensembleSommets->size()<< endl;

      typedef vector<Arete*>::iterator IS;
      vector<Arete*>::iterator itsupp;
      for (IS i = ensembleAretes->begin(); i != ensembleAretes->end(); ++i) {
	//cout << ensembleAretes->size()<< endl;


	Arete* arre = *i;
	if(arre->getSommet1() == sommet || arre->getSommet2() == sommet ){

	  itsupp = remove(ensembleAretes->begin(), ensembleAretes->end(), arre);


	}

      }
      ensembleAretes->erase(itsupp, ensembleAretes->end());
      cout<<"Une arete a été supprimée" <<endl;

     // cout << ensembleAretes->size()<< endl;

    }
    else
      {
	cout<< "Sommet ne fait pas partie du graphe" <<endl;
      }


  }


  void Graphe::removeArete(Arete* arete){

   // cout << ensembleAretes->size()<< endl;
    if((find(ensembleAretes->begin(), ensembleAretes->end(), arete)) != ensembleAretes->end()){
      cout<<"Arete trouvé et va être supprimé" <<endl;
      vector<Arete*>::iterator it = remove(ensembleAretes->begin(), ensembleAretes->end(), arete);
      ensembleAretes->erase(it, ensembleAretes->end());

   //   cout << ensembleAretes->size()<< endl;

    }
    else{
      cout<< "Arete ne fait pas partie du graphe" <<endl;
    }

  }

  bool Graphe::invarianceGraphe(){


    typedef vector<Arete*>::iterator IS;
    vector<Arete*>::iterator itsupp;
    for (IS i = ensembleAretes->begin(); i != ensembleAretes->end(); ++i) {
    //  cout << ensembleAretes->size()<< endl;
      cout <<"test"<< endl;


      Arete* arre = *i;
      if(arre->getGraphe() != this){

	cout << "Graphe n'est pas égal à un des grapges des aretes" << endl;
	return false;

      }


    }
    cout << "Toutes les arretes ont le bon graphe" << endl;
    return true;


  }

  void Graphe::createArete(Sommet* sommet1, Sommet* sommet2){

    if(sommet1 != NULL && sommet2 != NULL){

      cout <<"Création arete" << endl;


      Arete* arete = new Arete(sommet1, sommet2);
      this->addArrete(arete);

    }
    else{
      cout <<"Arret n'a pas pu être créé, problème avec les sommets" << endl;
    }


  }

  void Graphe::createSommet(string x, string y){

    Sommet* som = new Sommet(this,x,y);

    this->addSommet(som);

    cout <<"Le sommet a été ajouté avec succès" << endl;


  }

}



