#ifndef NOEUD_H
#define NOEUD_H

#include "../grapheTemplate/GrapheTemplate.h"
#include "../grapheTemplate/AreteTemplate.h"
#include "../grapheTemplate/SommetTemplate.h"
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>


class Lien;
class Reseau;

class Noeud : public  grapheTemplate::SommetTemplate<Reseau,Lien,Noeud>
{
    public:
        Noeud();
        Noeud(Reseau * gra, string x, string y);
        virtual ~Noeud();

    protected:
    private:
};

#endif // NOEUD_H
