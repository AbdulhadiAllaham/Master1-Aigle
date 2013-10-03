#include "Graphe.h"
#include "Arete.h"
#include "Sommet.h"
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
class Graphe;
using namespace std;

namespace general{

template <typename G, typename S, typename A>
  Graphe::Graphe ( ) {
    ensembleSommets = new vector<Sommet*>();
    ensembleAretes = new vector<Arete*>();
  }
template <typename G, typename S, typename A>

  Graphe::Graphe(string nom)
  {
    nomgraphe = nom;
    ensembleSommets = new vector<Sommet*>();
    ensembleAretes = new vector<Arete*>();
  }

template <typename G, typename S, typename A>


  Graphe::~Graphe ( ) {
  }

  Sommet* sommet2;

template <typename G, typename S, typename A>

  void Graphe::addSommet(S* sommet){
    ensembleSommets->push_back(sommet);
    cout <<"Sommet a été ajouté avec succès" << endl;
    cout << ensembleSommets->size()<< endl;
  }

template <typename G, typename S, typename A>

  void Graphe::addArrete(A* arete){

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

template <typename G, typename S, typename A>
  void Graphe::removeSommet(S* sommet){

    if((find(ensembleSommets->begin(), ensembleSommets->end(), sommet)) != ensembleSommets->end()){
      cout<<"Sommet trouvé et va être supprimé" <<endl;
      vector<Sommet*>::iterator it = remove(ensembleSommets->begin(), ensembleSommets->end(), sommet);
      ensembleSommets->erase(it, ensembleSommets->end());

      cout << ensembleSommets->size()<< endl;

      typedef vector<Arete*>::iterator IS;
      vector<Arete*>::iterator itsupp;
      for (IS i = ensembleAretes->begin(); i != ensembleAretes->end(); ++i) {
	cout << ensembleAretes->size()<< endl;


	Arete* arre = *i;
	if(arre->getSommet1() == sommet || arre->getSommet2() == sommet ){

	  itsupp = remove(ensembleAretes->begin(), ensembleAretes->end(), arre);


	}

      }
      ensembleAretes->erase(itsupp, ensembleAretes->end());
      cout<<"Une arete a été supprimée" <<endl;

      cout << ensembleAretes->size()<< endl;

    }
    else
      {
	cout<< "Sommet ne fait pas partie du graphe" <<endl;
      }


  }

template <typename G, typename S, typename A>

  void Graphe::removeArete(A* arete){

    cout << ensembleAretes->size()<< endl;
    if((find(ensembleAretes->begin(), ensembleAretes->end(), arete)) != ensembleAretes->end()){
      cout<<"Arete trouvé et va être supprimé" <<endl;
      vector<Arete*>::iterator it = remove(ensembleAretes->begin(), ensembleAretes->end(), arete);
      ensembleAretes->erase(it, ensembleAretes->end());

      cout << ensembleAretes->size()<< endl;

    }
    else{
      cout<< "Arete ne fait pas partie du graphe" <<endl;
    }

  }

  bool Graphe::invarianceGraphe(){


    typedef vector<Arete*>::iterator IS;
    vector<Arete*>::iterator itsupp;
    for (IS i = ensembleAretes->begin(); i != ensembleAretes->end(); ++i) {
      cout << ensembleAretes->size()<< endl;
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

template <typename G, typename S, typename A>
  void Graphe::createArete(S* sommet1, S* sommet2){

    if(sommet1 != NULL && sommet2 != NULL){

      Arete* arete = new Arete(sommet1, sommet2);
      this->addArrete(arete);
      cout <<"Arete ajouté" << endl;

    }
    else{
      cout <<"Arret n'a pas pu être créé, problème avec les sommets" << endl;
    }






  }

}



