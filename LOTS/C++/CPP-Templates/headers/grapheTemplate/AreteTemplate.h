
#ifndef ARETE_H_
#define ARETE_H_



namespace grapheTemplate {

template<class Gra, class Are, class Som>
class GrapheTemplate;

template<class Gra, class Are, class Som>
class SommetTemplate;


template<class Gra, class Are, class Som>
class AreteTemplate {
public:

    AreteTemplate(){
    }

	AreteTemplate(Som * s1,Som * s2) : graphe1(0) {
		sommet1 = s1;
		sommet2 = s2;
	}

	virtual ~AreteTemplate() {
	}


	bool invarianceArrete(){

    if((getSommet1() == NULL && getSommet2() == NULL) || (getSommet1()!=NULL && getSommet2()!=NULL)){
      if(getSommet1()->getGraphe()==graphe1 && graphe1==getSommet2()->getGraphe()){
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

    if(sommet1 != NULL && sommet2 != NULL)
      {
	sommet1->removeArete(this);
	sommet2->removeArete(this);
      }
    else
      {
	cout << "Les sommets sont null" << endl;
      }
  }



  Som* getSommet1(){
    return sommet1;
  }

  Som* getSommet2(){
    return sommet2;
  }

  Gra* getGraphe(){
    return graphe1;
  }


  void setSommet1(Som* sommet){
    sommet1 = sommet;
  }

  void setSommet2(Som* sommet){
    sommet2 = sommet;
  }

  void setGraphe(Gra* graphe){
    graphe1 = graphe;
  }

private:
	Som * sommet1;
	Som * sommet2;
	Gra * graphe1;

};

} /* namespace general */
#endif /* ARETE_H_ */
