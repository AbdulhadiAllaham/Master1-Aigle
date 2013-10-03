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
}


#endif // GRAPHE_H_INCLUDED
