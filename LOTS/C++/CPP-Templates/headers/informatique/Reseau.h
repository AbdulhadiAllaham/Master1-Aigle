#ifndef RESEAU_H
#define RESEAU_H

#include "../grapheTemplate/GrapheTemplate.h"
#include "../grapheTemplate/AreteTemplate.h"
#include "../grapheTemplate/SommetTemplate.h"

class Lien;
class Noeud;

class Reseau : public grapheTemplate::GrapheTemplate<Reseau,Lien, Noeud>
{
    public:
        Reseau();
        virtual ~Reseau();


    protected:
        virtual Lien* newAr();
        virtual Noeud* newSom(Reseau* g, string x, string y);
    private:
};

#endif // RESEAU_H
