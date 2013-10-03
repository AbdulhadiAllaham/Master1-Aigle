#ifndef SOMMET_H_INCLUDED
#define SOMMET_H_INCLUDED
#include <string>
#include <iostream>
#include <vector>
#include "Arete.h"

using namespace std;
namespace general{

  class Graphe;
  class Arete;

    class Sommet{
    public:
      Sommet ();
      Sommet(std::string nom);
      Sommet(Graphe* graphe,string x,string y);
      virtual ~Sommet ();
      virtual Graphe* getGraphe();
      virtual void removeArete(Arete* arete);
      virtual void addAretes(Arete* arete);
      virtual void addAretes(Arete* arete,Sommet* sommet);


    protected:
      vector<Arete*>* ensembleAretes;
      std::string x;
      std::string y;
      Graphe* graphe_sommet;




    };
}

#endif // SOMMET_H_INCLUDED
