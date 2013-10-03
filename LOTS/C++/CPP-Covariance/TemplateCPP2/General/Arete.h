#ifndef ARETE_H_INCLUDED
#define ARETE_H_INCLUDED
#include <string>
#include"Sommet.h"
#include <iostream>


namespace general{

  class Graphe;
  class Sommet;



  class Arete
  {
  public:

    Arete();
    Arete(Sommet* sommet1, Sommet* sommet2);

    virtual ~Arete ();
    virtual void setGraphe(Graphe* graphe);
    virtual Graphe* getGraphe();
    virtual Sommet* getSommet1();
    virtual Sommet* getSommet2();
    virtual bool invarianceArrete();
    virtual void removefromSommets();
    virtual void setSommet1(Sommet* sommet);
    virtual void setSommet2(Sommet* sommet);



  protected:
    Sommet* sommet_1;
    Sommet* sommet_2;
    Graphe* graphe_1;





  };

}



#endif // ARETE_H_INCLUDED
