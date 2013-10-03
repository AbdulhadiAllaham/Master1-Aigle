#ifndef CHECK_H
#define CHECK_H

/*-----------------INCLUDE----------------*/

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <string.h>
#include <sys/stat.h>
#include <strings.h>
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
#define MAX_EMPLOYE 50
#define STR_EGAL 0


/*-----------------TYPEDEF----------------*/

typedef int SOCKET;
typedef struct sockaddr_in SOCKADDR_IN;
typedef struct sockaddr SOCKADDR;
typedef char Identifiant[30];
typedef struct{
		Identifiant tabId[MAX_EMPLOYE];
		int nbrEmp;
		}ListeEmp;

typedef struct{
		Identifiant rapId[MAX_EMPLOYE];
		int nbrRapp;
		}ListeRapport;	
		
		
/*---------------PROTOTYPES---------------*/

int connexion(char param[30]);
int menu(void);
int send_list(void);
void recevoirFichier(SOCKET sock, char* path);
void exitConnexion(SOCKET sock);


#endif
