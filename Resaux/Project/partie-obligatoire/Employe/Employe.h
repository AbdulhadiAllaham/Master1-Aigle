#ifndef CHECK_H
#define CHECK_H

/*-----------------INCLUDE----------------*/

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <string.h>
#include <strings.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>

/*-----------------DEFINE-----------------*/

#define INVALID_SOCKET -1
#define SOCKET_ERROR -1
#define PORT 21026
#define CONNEXION_ECHEC -1
#define LENGTH 512 
#define STR_EGAL 0

/*-----------------TYPEDEF----------------*/

typedef int SOCKET;
typedef struct sockaddr_in SOCKADDR_IN;
typedef struct sockaddr SOCKADDR;
typedef char Identifiant[30];
typedef char BLOC[4096];

/*---------------PROTOTYPES---------------*/

int connexion(char param[30], Identifiant IDEmp);
void sendBlocRapport(void);
int menu(void);
void lire_chaine(void);
void recevoirFichier(SOCKET sock);
void exitConnexion(SOCKET sock);

#endif

