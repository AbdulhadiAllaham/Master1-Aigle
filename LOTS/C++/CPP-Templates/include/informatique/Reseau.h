#ifndef RESEAU_H
#define RESEAU_H

#include "generalT/GrapheT.h"
#include "generalT/AreteT.h"
#include "generalT/SommetT.h"

class Lien;
class Noeud;

class Reseau : public generalT::GrapheT<Reseau,Lien, Noeud>
{
    public:
        Reseau();
        virtual ~Reseau();
        virtual Lien* newAr();
        virtual Noeud* newSom(Reseau g, string x, string y);

    protected:
    private:
};

#endif // RESEAU_H
