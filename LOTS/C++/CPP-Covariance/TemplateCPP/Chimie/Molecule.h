#ifndef MOLECULE_H_INCLUDED
#define MOLECULE_H_INCLUDED
#include <string>
#include <vector>

#include "../General/Graphe.h"

using namespace general;
using namespace std;

namespace Chimie{

  class Molecule : public virtual Graphe
  {
  public:
    Molecule();
    Molecule(string nom);
    virtual ~Molecule();
    virtual void addSommet(Sommet* sommet);
    virtual void addArrete(Arete* arete);
    virtual void createArete(Sommet* sommet1, Sommet* sommet2);

  protected:

  };

}

#endif // MOLECULE_H_INCLUDED
