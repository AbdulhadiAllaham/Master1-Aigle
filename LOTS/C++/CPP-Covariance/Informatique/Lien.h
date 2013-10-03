#ifndef LIEN_H_INCLUDED
#define LIEN_H_INCLUDED
#include <string>
#include <vector>

#include "../General/Arete.h"


using namespace general;
using namespace std;

namespace Informatique{

  class Lien : public virtual Arete
  {
  public:
    Lien();
    Lien(Sommet* sommet1, Sommet* sommet2);
    virtual ~Lien();
    virtual void setSommet1(Sommet* sommet);
    virtual void setSommet2(Sommet* sommet);

  protected:

  };

}

#endif // LIEN_H_INCLUDED
