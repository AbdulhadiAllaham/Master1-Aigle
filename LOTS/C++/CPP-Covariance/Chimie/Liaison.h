#ifndef LIAISON_H_INCLUDED
#define LIAISON_H_INCLUDED
#include <string>
#include <vector>

#include "../General/Arete.h"


using namespace std;

namespace Chimie{

  class Liaison : public virtual Arete
  {
  public:
    Liaison();
    Liaison(Sommet* sommet1, Sommet* sommet2);
    virtual ~Liaison();
    virtual void setSommet1(Sommet* sommet);
    virtual void setSommet2(Sommet* sommet);

  protected:

  };

}

#endif // LIAISON_H_INCLUDED
