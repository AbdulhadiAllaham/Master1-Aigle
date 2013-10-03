all: Serveur clean

Serveur: Serveur.o
	gcc -o Serveur -lpthread Serveur.o `pkg-config --cflags --libs gtk+-2.0` 


Serveur.o: Serveur.c Serveur.h
	gcc -o Serveur.o -c Serveur.c -W -Wall -ansi -pedantic -std=c99 `pkg-config --cflags --libs gtk+-2.0` 

clean:
	rm *.o
