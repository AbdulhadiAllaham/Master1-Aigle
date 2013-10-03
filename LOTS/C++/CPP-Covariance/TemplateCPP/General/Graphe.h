#ifndef GRAPHE_H_INCLUDED
#define GRAPHE_H_INCLUDED
#include <string>
#include <vector>
#include "Sommet.h"
#include "Arete.h"
#include <iostream>

using namespace std;


namespace General{

//class Aret;
//class Sommet;

template <typename G, typename S, typename A>
class Graphe
{
public:
    Graphe();
    Graphe(string nom);

    virtual ~Graphe ();
    string nomgraphe;
    virtual void addSommet(S*);
    virtual void addArrete(A*);
    virtual void removeSommet(S*);
    virtual void removeArete(A*);
    virtual bool invarianceGraphe();
    virtual void createArete(S*, S*);
vector<S*> ensembleSommets;
    vector<A*> ensembleAretes;



};

template <typename G, typename S, typename A>
  Graphe<G,S,A>::Graphe ( ) {
    ensembleSommets = new vector<S*>();
    ensembleAretes = new vector<A*>();
  }

template <typename G, typename S, typename A>
  Graphe<G,S,A>::Graphe(string nom)
  {
    nomgraphe = nom;
    ensembleSommets = new vector<S*>();
    ensembleAretes = new vector<A*>();
  }


template <typename G, typename S, typename A>

  Graphe<G,S,A>::~Graphe ( ) {
  }

  //Sommet* sommet2;
template <typename G, typename S, typename A>

  void Graphe<G,S,A>::addSommet(S* s){
    ensembleSommets->push_back(s) ;
    cout <<"Sommet a été ajouté avec succès" << endl;
    cout << ensembleSommets->size()<< endl;
  }
template <typename G, typename S, typename A>

  void Graphe<G,S,A>::addArrete(A* a){

    if(ensembleSommets->empty())
      {
	cout << "Le graphe ne comporte pas de sommets" << endl;
      }

    cout << ensembleSommets->size()<< endl;


    if((find(ensembleSommets->begin(), ensembleSommets->end(), a->getSommet1())) != ensembleSommets->end() && (find(ensembleSommets->begin(), ensembleSommets->end(), a->getSommet2())) != ensembleSommets->end())
      {
	cout<< "L'arrete a les memes sommets que le graphe" <<endl;
	ensembleAretes->push_back(a);
	a->setGraphe(this);

      }
    else
      {
	cout<<"Le graphe n'a pas les meme sommets que l'arrete" <<endl;
      }



  }
template <typename G, typename S, typename A>

  void Graphe<G,S,A>::removeSommet(S* sommet){

    if((find(ensembleSommets->begin(), ensembleSommets->end(), sommet)) != ensembleSommets->end()){
      cout<<"Sommet trouvé et va être supprimé" <<endl;
      typename vector<S*>::iterator it = remove(ensembleSommets->begin(), ensembleSommets->end(), sommet);
      ensembleSommets->erase(it, ensembleSommets->end());

      cout << ensembleSommets->size()<< endl;

      typename vector<A*>::iterator IS;
      typename vector<A*>::iterator itsupp;

      for (IS = ensembleAretes->begin(); IS != ensembleAretes->end(); ++IS) {
	cout << ensembleAretes->size()<< endl;


	A* arre = IS;
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

  void Graphe<G,S,A>::removeArete(A* arete){

    cout << ensembleAretes->size()<< endl;
    if((find(ensembleAretes->begin(), ensembleAretes->end(), arete)) != ensembleAretes->end()){
      cout<<"Arete trouvé et va être supprimé" <<endl;
      typename vector<A*>::iterator it = remove(ensembleAretes->begin(), ensembleAretes->end(), arete);
      ensembleAretes->erase(it, ensembleAretes->end());

      cout << ensembleAretes->size()<< endl;

    }
    else{
      cout<< "Arete ne fait pas partie du graphe" <<endl;
    }

  }

template <typename G, typename S, typename A>

  bool Graphe<G,S,A>::invarianceGraphe(){


    typename vector<A*>::iterator IS;
    typename vector<A*>::iterator itsupp;
    for (IS = ensembleAretes->begin(); IS != ensembleAretes->end(); ++IS) {
      cout << ensembleAretes->size()<< endl;
      cout <<"test"<< endl;


      A* arre = IS;
      if(arre->getGraphe() != this){

	cout << "Graphe n'est pas égal à un des grapges des aretes" << endl;
	return false;

      }


    }
    cout << "Toutes les arretes ont le bon graphe" << endl;
    return true;


  }

template <typename G, typename S, typename A>
 void Graphe<G,S,A>::createArete(S* sommet1, S* sommet2){

    if(sommet1 != NULL && sommet2 != NULL){

      //A arete = new Arete(sommet1, sommet2);
      //this->addArrete(arete);
      //cout <<"Arete ajouté" << endl;

    }
    else{
      cout <<"Arret n'a pas pu être créé, problème avec les sommets" << endl;
    }






  }

}


#endif // GRAPHE_H_INCLUDED
