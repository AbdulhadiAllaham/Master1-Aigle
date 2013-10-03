#ifndef ATOME_H
#define ATOME_H

#include "../grapheTemplate/GrapheTemplate.h"
#include "../grapheTemplate/AreteTemplate.h"
#include "../grapheTemplate/SommetTemplate.h"

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>


class Liaison;
class Molecule;

class Atome : public  grapheTemplate::SommetTemplate<Molecule,Liaison,Atome>
{
    public:
        Atome();
        Atome(Molecule * gra, string x, string y);
        virtual ~Atome();

    protected:
    private:
};

#endif // ATOME_H
