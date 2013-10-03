all: Controleur clean

Controleur: Controleur.o
	gcc -o Controleur Controleur.o 

Controleur.o: Controleur.c Controleur.h
	gcc -o Controleur.o -c Controleur.c -W -Wall -ansi -pedantic  -std=c99

clean:
	rm *.o
