#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#ifndef GRAPHE_H_
#define GRAPHE_H_

#include <vector>

using namespace std;

namespace grapheTemplate {


template<class Gra, class Are, class Som>
class AreteTemplate;

template<class Gra, class Are, class Som>
class SommetTemplate;


template<class Gra, class Are, class Som>
class GrapheTemplate {
public:
	GrapheTemplate() {
	}

	virtual ~GrapheTemplate() {
	}


    void addSommet(Som * sommet){

        ensembleSommets.push_back(sommet);
        cout <<"Sommet ajouté dans addSommet"<< endl;

    }
    void addArrete(Are * arete){

        if(ensembleSommets.empty())
      {
	cout << "Le graphe ne comporte pas de sommets" << endl;
      }



    if((find(ensembleSommets.begin(), ensembleSommets.end(), arete->getSommet1())) != ensembleSommets.end() && (find(ensembleSommets.begin(), ensembleSommets.end(), arete->getSommet2())) != ensembleSommets.end())
      {
	cout<< "L'arrete a les memes sommets que le graphe" <<endl;
	ensembleAretes.push_back(arete);
    arete->setGraphe(dynamic_cast<Gra*>(this));

      }
    else
      {
	cout<<"Le graphe n'a pas les meme sommets que l'arrete" <<endl;
      }

    }

    void removeSommet(Som * sommet){



        if((find(ensembleSommets.begin(), ensembleSommets.end(), sommet)) != ensembleSommets.end()){
                    cout << ensembleSommets.size()<< endl;

      cout<<"Sommet trouvé et va être supprimé" <<endl;
      typename vector<Som*>::iterator it = remove(ensembleSommets.begin(), ensembleSommets.end(), sommet);
      ensembleSommets.erase(it, ensembleSommets.end());
        cout << ensembleSommets.size()<< endl;



      typename vector<Are *>::iterator IS;
      typename vector<Are *>::iterator itsupp;

      for (typename vector<Are *>::iterator i = ensembleAretes.begin(); i != ensembleAretes.end(); ++i) {


	Are * arre = *i;
	if(arre->getSommet1() == sommet || arre->getSommet2() == sommet ){
      cout<<"Sommet correspond" <<endl;

	  itsupp = remove(ensembleAretes.begin(), ensembleAretes.end(), arre);


	}

      }

      ensembleAretes.erase(itsupp, ensembleAretes.end());

    }
    else
      {
	cout<< "Sommet ne fait pas partie du graphe" <<endl;
      }

    }

    void removeArete(Are * arete){

        cout << ensembleAretes.size()<< endl;
    if((find(ensembleAretes.begin(), ensembleAretes.end(), arete)) != ensembleAretes.end()){
      cout<<"Arete trouvé et va être supprimé" <<endl;
      typename vector<Are *>::iterator it = remove(ensembleAretes.begin(), ensembleAretes.end(), arete);
      ensembleAretes.erase(it, ensembleAretes.end());

      cout << ensembleAretes.size()<< endl;

    }
    else{
      cout<< "Arete ne fait pas partie du graphe" <<endl;
    }

    }


    bool invarianceGraphe(){

        typename vector<Are*>::iterator IS;
        typename vector<Are* > ::iterator itsupp;
        for (typename vector<Are*>::iterator i = ensembleAretes.begin(); i != ensembleAretes.end(); ++i) {
        cout << ensembleAretes.size()<< endl;
        cout <<"test"<< endl;


        Are * arre = *i;
        if(arre->getGraphe() != this){

        cout << "Graphe n'est pas égal à un des graphes des aretes" << endl;
        return false;

        }


        }
        cout << "Toutes les arretes ont le bon graphe" << endl;
        return true;

    }


    void createArete(Som * sommet1, Som * sommet2){


     if(sommet1 != NULL && sommet2 != NULL){


//      this->addArrete(newAr());
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
	vector<Som*> ensembleSommets;
	vector<Are*> ensembleAretes;


protected:

    Are* newAr();
    Som* newSom(string x, string y);

};

}
#endif /* GRAPHE_H_ */
