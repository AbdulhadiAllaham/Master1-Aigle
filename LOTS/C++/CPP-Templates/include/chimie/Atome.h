#ifndef ATOME_H
#define ATOME_H

#include "generalT/GrapheT.h"
#include "generalT/AreteT.h"
#include "generalT/SommetT.h"

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>


class Liaison;
class Molecule;

class Atome : public  generalT::SommetT<Molecule,Liaison,Atome>
{
    public:
        Atome();
        Atome(Molecule * gra, string x, string y);
        virtual ~Atome();

    protected:
    private:
};

#endif // ATOME_H
