/*
 * Arete.h
 *
 *  Created on: 24 mai 2013
 *      Author: amayas
 */

#ifndef ARETE_H_
#define ARETE_H_



namespace generalT {

template<class Gra, class Are, class Som>
class GrapheT;

template<class Gra, class Are, class Som>
class SommetT;


template<class Gra, class Are, class Som>
class AreteT {
public:

    AreteT(){
    }

	AreteT(SommetT<Gra,Are,Som> * s1,SommetT<Gra,Are,Som> * s2) : graphe_1(0) {
		sommet_1 = s1;
		sommet_2 = s2;
	}

	virtual ~AreteT() {
	}


	bool invarianceArrete(){

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


  void removefromSommets(){

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



  SommetT<Gra,Are,Som>* getSommet1(){
    return sommet_1;
  }

  SommetT<Gra,Are,Som>* getSommet2(){
    return sommet_2;
  }

  GrapheT<Gra,Are,Som>* getGraphe(){
    return graphe_1;
  }


  void setSommet1(SommetT<Gra,Are,Som>* sommet){
    sommet_1 = sommet;
  }

  void setSommet2(SommetT<Gra,Are,Som>* sommet){
    sommet_2 = sommet;
  }

  void setGraphe(GrapheT<Gra,Are,Som>* graphe){
    graphe_1 = graphe;
  }

private:
	SommetT<Gra,Are,Som> * sommet_1;
	SommetT<Gra,Are,Som> * sommet_2;
	GrapheT<Gra,Are,Som> * graphe_1;

};

} /* namespace general */
#endif /* ARETE_H_ */
