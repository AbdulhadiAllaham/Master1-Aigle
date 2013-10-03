all: Employe clean

Employe: Employe.o
	gcc -o Employe Employe.o

Employe.o: Employe.c Employe.h
	gcc -o Employe.o -c Employe.c -W -Wall -ansi -pedantic  -std=c99

clean:
	rm *.o
