
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#ifndef GRAPHE_H_
#define GRAPHE_H_

#include <vector>

using namespace std;
namespace generalT {


template<class Gra, class Are, class Som>
class AreteT;

template<class Gra, class Are, class Som>
class SommetT;


template<class Gra, class Are, class Som>
class GrapheT {
public:
	GrapheT() {
	}

	virtual ~GrapheT() {
	}

	/*void ajouterArete (AreteT<Gra,Are,Som> * arete){
		ensembleAretes.push_back(arete);
	}

    inline vector<SommetT<Gra, Are, Som>* > & Sommets(){
        return ensembleSommets;
    }

    inline  vector<AreteT<Gra, Are, Som>* > & Aretes(){
        return ensembleAretes;
    }*/

    void addSommet(SommetT<Gra,Are,Som> * sommet){

        ensembleSommets.push_back(sommet);
        cout <<"Sommet a été ajouté avec succès" << endl;
        cout << ensembleSommets.size()<< endl;

    }
    void addArrete(AreteT<Gra,Are,Som> * arete){

        if(ensembleSommets.empty())
      {
	cout << "Le graphe ne comporte pas de sommets" << endl;
      }

    cout << ensembleSommets.size()<< endl;


    if((find(ensembleSommets.begin(), ensembleSommets.end(), arete->getSommet1())) != ensembleSommets.end() && (find(ensembleSommets.begin(), ensembleSommets.end(), arete->getSommet2())) != ensembleSommets.end())
      {
	cout<< "L'arrete a les memes sommets que le graphe" <<endl;
	ensembleAretes.push_back(arete);
	arete->setGraphe(this);

      }
    else
      {
	cout<<"Le graphe n'a pas les meme sommets que l'arrete" <<endl;
      }

    }

    void removeSommet(SommetT<Gra,Are,Som> * sommet){

        if((find(ensembleSommets.begin(), ensembleSommets.end(), sommet)) != ensembleSommets.end()){
      cout<<"Sommet trouvé et va être supprimé" <<endl;
      typename vector<SommetT<Gra,Are,Som>*>::iterator it = remove(ensembleSommets.begin(), ensembleSommets.end(), sommet);
      ensembleSommets.erase(it, ensembleSommets.end());

      cout << ensembleSommets.size()<< endl;

      typename vector<AreteT<Gra,Are,Som> *>::iterator IS;
      typename vector<AreteT<Gra,Are,Som> *>::iterator itsupp;

      for (typename vector<AreteT<Gra,Are,Som> *>::iterator i = ensembleAretes.begin(); i != ensembleAretes.end(); ++i) {
	cout << ensembleAretes.size()<< endl;


	AreteT<Gra,Are,Som> * arre = *i;
	if(arre->getSommet1() == sommet || arre->getSommet2() == sommet ){

	  itsupp = remove(ensembleAretes.begin(), ensembleAretes.end(), arre);


	}

      }
      ensembleAretes.erase(itsupp, ensembleAretes.end());
      cout<<"Une arete a été supprimée" <<endl;

      cout << ensembleAretes.size()<< endl;

    }
    else
      {
	cout<< "Sommet ne fait pas partie du graphe" <<endl;
      }

    }

    void removeArete(AreteT<Gra,Are,Som> * arete){

        cout << ensembleAretes.size()<< endl;
    if((find(ensembleAretes.begin(), ensembleAretes.end(), arete)) != ensembleAretes.end()){
      cout<<"Arete trouvé et va être supprimé" <<endl;
      typename vector<AreteT<Gra,Are,Som> *>::iterator it = remove(ensembleAretes.begin(), ensembleAretes.end(), arete);
      ensembleAretes.erase(it, ensembleAretes.end());

      cout << ensembleAretes.size()<< endl;

    }
    else{
      cout<< "Arete ne fait pas partie du graphe" <<endl;
    }

    }


    bool invarianceGraphe(){

        typename vector<AreteT<Gra,Are,Som>*>::iterator IS;
        typename vector<AreteT<Gra, Are, Som>* > ::iterator itsupp;
        for (typename vector<AreteT<Gra,Are,Som>*>::iterator i = ensembleAretes->begin(); i != ensembleAretes->end(); ++i) {
        cout << ensembleAretes->size()<< endl;
        cout <<"test"<< endl;


        AreteT<Gra,Are,Som> * arre = *i;
        if(arre->getGraphe() != this){

        cout << "Graphe n'est pas égal à un des grapges des aretes" << endl;
        return false;

        }


        }
        cout << "Toutes les arretes ont le bon graphe" << endl;
        return true;

    }


    void createArete(SommetT<Gra,Are,Som> * sommet1, SommetT<Gra,Are,Som> * sommet2){


     if(sommet1 != NULL && sommet2 != NULL){


      this->addArrete(newAr());
      cout <<"Arete ajouté" << endl;

    }
    else{
      cout <<"Arret n'a pas pu être créé, problème avec les sommets" << endl;
    }

    }

    void createSommet(string x, string y){

		//this->addSommet(newSom(dynamic_cast<Gra*>(this),x,y));
		cout <<"Sommet ajouté dans create sommet" << endl;
	}



private:
	vector<SommetT<Gra, Are, Som>*> ensembleSommets;
	vector<AreteT<Gra, Are, Som>*> ensembleAretes;


protected:

    Are* newAr();
    Som* newSom(string x, string y);

};

} /* namespace general */
#endif /* GRAPHE_H_ */
