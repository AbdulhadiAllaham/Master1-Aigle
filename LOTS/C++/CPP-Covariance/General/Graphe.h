#ifndef GRAPHE_H_INCLUDED
#define GRAPHE_H_INCLUDED
#include <string>
#include <vector>
#include "Sommet.h"
#include "Arete.h"
#include <iostream>

using namespace std;

namespace general{

  class Graphe
  {

  public:
    Graphe ();
    Graphe(string nom);
    //std::vector<Sommet> ensembleSommets;
    //std::vector<Sommet>::iterator iterSommets;
    //std::vector<int> ensebmeint;
    // std::vector<Arete> ensembleAretes;
    virtual ~Graphe ();
    std::string nomgraphe;
    virtual void addSommet(Sommet* sommet);
    virtual void addArrete(Arete* arete);
    virtual void removeSommet(Sommet* sommet);
    virtual void removeArete(Arete* arete);
    virtual bool invarianceGraphe();
    virtual void createArete(Sommet* sommet1, Sommet* sommet2);
    virtual void createSommet(string x, string y);




  protected:

    vector<Sommet*>* ensembleSommets;
    vector<Arete*>* ensembleAretes;


  };
}



#endif // GRAPHE_H_INCLUDED
