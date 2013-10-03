#ifndef NOEUD_H_INCLUDED
#define NOEUD_H_INCLUDED
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

#endif // NOEUD_H_INCLUDED
