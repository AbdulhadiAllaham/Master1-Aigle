#include "../../headers/informatique/Reseau.h"
#include "../../headers/informatique/Noeud.h"
#include "../../headers/informatique/Lien.h"

Lien::Lien(){

}

Lien::Lien(Noeud * s1 , Noeud *s2) : AreteTemplate(s1,s2)
{
    //ctor
}

Lien::~Lien()
{
    //dtor
}
