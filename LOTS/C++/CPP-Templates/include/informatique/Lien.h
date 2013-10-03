#ifndef LIEN_H
#define LIEN_H

#include "generalT/GrapheT.h"
#include "generalT/AreteT.h"
#include "generalT/SommetT.h"


class Reseau;
class Noeud;

class Lien :public  generalT::AreteT<Reseau,Lien, Noeud>
{
    public:
        Lien();
        Lien(Noeud * s1 , Noeud *s2);
        virtual ~Lien();
    protected:
    private:
};

#endif // LIEN_H
