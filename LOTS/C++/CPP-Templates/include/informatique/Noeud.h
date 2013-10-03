#ifndef NOEUD_H
#define NOEUD_H

#include "generalT/GrapheT.h"
#include "generalT/AreteT.h"
#include "generalT/SommetT.h"
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>


class Lien;
class Reseau;

class Noeud : public  generalT::SommetT<Reseau,Lien,Noeud>
{
    public:
        Noeud();
        Noeud(Reseau * gra, string x, string y);
        virtual ~Noeud();

    protected:
    private:
};

#endif // NOEUD_H
