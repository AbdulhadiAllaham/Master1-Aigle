#include "../include/informatique/Lien.h"
#include "../include/informatique/Noeud.h"
#include "../include/informatique/Reseau.h"

Lien::Lien(){

}

Lien::Lien(Noeud * s1 , Noeud *s2) : AreteT(s1,s2)
{
    //ctor
}

Lien::~Lien()
{
    //dtor
}
