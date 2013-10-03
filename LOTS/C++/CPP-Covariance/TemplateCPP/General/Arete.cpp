#include "Arete.h"
#include "Sommet.h"
#include "Graphe.h"
#include <iostream>
#include <string>

using namespace std;

namespace general{


  Arete::Arete ( ) {
  }

  Arete::Arete(Sommet* sommet1, Sommet* sommet2)
  {
    // A revoir cause segmenation fault
    if((sommet_1 != sommet_2) && (sommet1->getGraphe() == sommet2->getGraphe()))
      {
	sommet_1=sommet1;
	sommet_2=sommet2;
	sommet1->addAretes(this);
	sommet2->addAretes(this);
	this->graphe_1 = sommet1->getGraphe();
      }
    else{
      cout << "Erreur lors de l'instanciation d'une arete, veuillez vérifier les sommets" << endl;
    }


  }

  Arete::~Arete ( ) {
  }

  bool Arete::invarianceArrete(){

    if((getSommet1() == NULL && getSommet2() == NULL) || (getSommet1()!=NULL && getSommet2()!=NULL)){
      if(getSommet1()->getGraphe()==graphe_1 && graphe_1==getSommet2()->getGraphe()){
	cout <<"test invariance arete ok" << endl;
	return true;

      }
      else{
	cout <<"Les deux arretes n'ont pas le meme graphe" << endl;
	return false;

      }

    }
    else{
      cout <<"Erreur : L'arete est branché d'un côté seulement" << endl;
      return false;

    }

  }


  void Arete::removefromSommets(){

    if(sommet_1 != NULL && sommet_2 != NULL)
      {
	sommet_1->removeArete(this);
	sommet_2->removeArete(this);
      }
    else
      {
	cout << "Les sommets sont null" << endl;
      }
  }



  Sommet* Arete::getSommet1(){
    return sommet_1;
  }

  Sommet* Arete::getSommet2(){
    return sommet_2;
  }

  Graphe* Arete::getGraphe(){
    return graphe_1;
  }


  void Arete::setSommet1(Sommet* sommet){
    sommet_1 = sommet;
  }

  void Arete::setSommet2(Sommet* sommet){
    sommet_2 = sommet;
  }

  void Arete::setGraphe(Graphe* graphe){
    graphe_1 = graphe;
  }

}
