
#ifndef GRAPHE_H_INCLUDED
#define GRAPHE_H_INCLUDED
#include <string>
#include <vector>
#include "Sommet.h"
#include "Arete.h"
#include <iostream>

using namespace std;
template <typename S, typename A>
class Graphe;


//class Aret;
//class Sommet;

template <typename S, typename A>
class Graphe
{
public:
    Graphe();
    Graphe(string nom);

    virtual ~Graphe ();
    string nomgraphe;
    vector<S*>* ensembleSommets;
    vector<A*>* ensembleAretes;

void addSommet(S* s);

};

template <typename S, typename A>
   Graphe<S,A>::Graphe ( ) {
    ensembleSommets = new vector<S*>();
    ensembleAretes = new vector<A*>();
  }

template <typename S, typename A>
  Graphe<S,A>::Graphe(string nom)
  {
    nomgraphe = nom;
    ensembleAretes = new vector<A*>();
    ensembleSommets = new vector<S*>();
  }


template < typename S, typename A>

  Graphe<S,A>::~Graphe ( ) {
  }


    //Sommet* sommet2;
template < typename S, typename A>

  void Graphe<S,A>::addSommet(S* s){
    ensembleSommets->push_back(s) ;
    cout <<"Sommet a été ajouté avec succès" << endl;
    cout << ensembleSommets->size()<< endl;
  }





#endif // GRAPHE_H_INCLUDED
