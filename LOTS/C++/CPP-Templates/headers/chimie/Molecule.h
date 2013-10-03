#ifndef MOLECULE_H
#define MOLECULE_H

#include "../grapheTemplate/GrapheTemplate.h"
#include "../grapheTemplate/AreteTemplate.h"
#include "../grapheTemplate/SommetTemplate.h"

class Atome;
class Liaison;

class Molecule : public grapheTemplate::GrapheTemplate<Molecule,Liaison, Atome>
{
    public:
        Molecule();
        virtual ~Molecule();


    protected:
     virtual Liaison* newAr();
    virtual Atome* newSom(Molecule* g, string x, string y);
    private:
};

#endif // MOLECULE_H
