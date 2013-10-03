
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#ifndef SOMMET_H_
#define SOMMET_H_
#include <vector>

namespace generalT {

template<class Gra, class Are, class Som>
class GrapheT;

template<class Gra, class Are, class Som>
class AreteT;


template<class Gra, class Are, class Som>
class SommetT {
public:
	SommetT() {
	}

	virtual ~SommetT() {
	}

	SommetT(GrapheT<Gra,Are,Som> * graphe, string x, string y)
  {
    graphe_sommet = graphe;
    x=x;
    y=y;
   // ensembleAretes = new vector<Arete*>();
  }


  GrapheT<Gra,Are,Som> * getGraphe(){
    return graphe_sommet;
  }


  void addAretes(AreteT<Gra,Are,Som> * arete){
    ensembleAretes->push_back(arete);
  }

  void addAretes(AreteT<Gra,Are,Som>* arete,SommetT<Gra,Are,Som>* sommet){

    if(this->getGraphe()!=NULL && this->getGraphe() == sommet->getGraphe()){
      cout << "verification des graphes ok" << endl;
      if(arete->getSommet1()!=this && arete->getSommet2()!=sommet){

	arete->removefromSommets();
	arete->setSommet1(this);
	if(sommet != NULL){
	  arete->setSommet2(sommet);
	}
	ensembleAretes->push_back(arete);
	cout << "L'arete a été remplacé et ajouté" << endl;

      }
      else{
        cout << "Veuillez vérifier le graphe de l'arete et des sommets" << endl;
      }

    }
    else{
      cout << "Veuillez vérifier le graphe de l'arete et des sommets" << endl;
    }


  }


  void removeArete(AreteT<Gra,Are,Som>* arete){

    cout << ensembleAretes->size()<< endl;
    if((find(ensembleAretes->begin(), ensembleAretes->end(), arete)) != ensembleAretes->end()){
      cout<<"Arete trouvé et va être supprimé" <<endl;
      typename vector<AreteT<Gra,Are,Som>*>::iterator it = remove(ensembleAretes->begin(), ensembleAretes->end(), arete);
      ensembleAretes->erase(it, ensembleAretes->end());

      cout << ensembleAretes->size()<< endl;

    }
    else{
      cout<< "L'arete ne se trouve pas au sommet indiqué" <<endl;
    }



  }


private :
	std::vector<AreteT<Gra,Are,Som>* > ensembleAretes;
	GrapheT<Gra,Are,Som>  *graphe_sommet;
	std::string x;
    std::string y;


};

} /* namespace general */
#endif /* SOMMET_H_ */
