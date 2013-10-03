#ifndef LIAISON_H
#define LIAISON_H

#include "../grapheTemplate/GrapheTemplate.h"
#include "../grapheTemplate/AreteTemplate.h"
#include "../grapheTemplate/SommetTemplate.h"


class Molecule;
class Atome;

class Liaison :public  grapheTemplate::AreteTemplate<Molecule,Liaison, Atome>
{
    public:
        Liaison(Atome * s1 ,  Atome *s2);
        Liaison();
        virtual ~Liaison();
    protected:
    private:
};

#endif // LIAISON_H
