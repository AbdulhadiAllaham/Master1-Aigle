#ifndef LIEN_H
#define LIEN_H

#include "../grapheTemplate/GrapheTemplate.h"
#include "../grapheTemplate/AreteTemplate.h"
#include "../grapheTemplate/SommetTemplate.h"


class Reseau;
class Noeud;

class Lien :public  grapheTemplate::AreteTemplate<Reseau,Lien, Noeud>
{
    public:
        Lien();
        Lien(Noeud * s1 , Noeud *s2);
        virtual ~Lien();
    protected:
    private:
};

#endif // LIEN_H
