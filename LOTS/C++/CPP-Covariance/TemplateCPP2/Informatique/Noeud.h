#ifndef ATOME_H_INCLUDED
#define ATOME_H_INCLUDED
#include <string>
#include <vector>
#include "../General/Sommet.h"



using namespace general;
using namespace std;

namespace Informatique{

  class Noeud : public virtual Sommet
  {
  public:
    Noeud();
    Noeud(Graphe* graphe,string x,string y);
    virtual ~Noeud();
    virtual void addAretes(Arete* arete);
    virtual void addAretes(Arete* arete,Sommet* sommet);

  protected:


  };

}

#endif // ATOME_H_INCLUDED
