#ifndef MOLECULE_H_INCLUDED
#define MOLECULE_H_INCLUDED
#include <string>
#include <vector>

#include "../General/Graphe.h"

using namespace general;
using namespace std;

namespace Informatique{

  class Reseau : public virtual Graphe
  {
  public:
    Reseau();
    Reseau(string nom);
    virtual ~Reseau();
    virtual void addSommet(Sommet* sommet);
    virtual void addArrete(Arete* arete);
    virtual void createArete(Sommet* sommet1, Sommet* sommet2);

  protected:

  };

}

#endif // MOLECULE_H_INCLUDED
