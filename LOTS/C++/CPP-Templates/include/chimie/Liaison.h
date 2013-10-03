#ifndef LIAISON_H
#define LIAISON_H

#include "generalT/GrapheT.h"
#include "generalT/AreteT.h"
#include "generalT/SommetT.h"


class Molecule;
class Atome;

class Liaison :public  generalT::AreteT<Molecule,Liaison, Atome>
{
    public:
        Liaison(Atome * s1 ,  Atome *s2);
        Liaison();
        virtual ~Liaison();
    protected:
    private:
};

#endif // LIAISON_H
