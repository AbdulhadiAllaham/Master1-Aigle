#ifndef MOLECULE_H
#define MOLECULE_H

#include "generalT/GrapheT.h"
#include "generalT/AreteT.h"
#include "generalT/SommetT.h"

class Atome;
class Liaison;

class Molecule : public generalT::GrapheT<Molecule,Liaison, Atome>
{
    public:
        Molecule();
        virtual ~Molecule();
        virtual Liaison* newAr();
        virtual Atome* newSom(Molecule g, string x, string y);

    protected:
    private:
};

#endif // MOLECULE_H
