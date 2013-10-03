#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <typeinfo>
#include "Graphe.h"

class Graphe;

using namespace std;

int main()
{
    cout << "Hello World!" << endl;

    Graphe<Graphe,Graphe,Graphe> grap = new Graphe();
    //Graphe <Graphe<int,int>,float> *test;

   // Graphe <int,float> *s = new Graphe <Graphe,float>();
//    Graphe <Graphe,Graphe> *s2 = new Graphe <Graphe,Graphe>();
//    Graphe <int,float> *ss = new Graphe <int,float>();
//    Graphe <int,float> *s = new Graphe <Graphe,float>("test");
//    int *test = new int(1);
//    int test2 = 2;
//
//
//    s->addSommet(ss);
//    s->addSommet(&s2);

cout << "Hello World!" << endl;

    return 0;
}
