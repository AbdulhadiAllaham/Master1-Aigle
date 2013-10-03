#ifndef SERVER_H
#define SERVER_H

/*-----------------INCLUDE----------------*/

#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <glib.h>
#include <time.h>
#include <locale.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <errno.h>
#include <strings.h>

/*-----------------DEFINE-----------------*/

#define STR_EGAL 0
#define INVALID_SOCKET -1
#define SOCKET_ERROR -1
#define PORT 21026
#define TAILLEBUF 100
#define FICHIERIMAGE "vuillemin.jpg"
#define MAX_EMPLOYE 50
#define LENGTH 512 

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

typedef  struct{
		SOCKET SockClient;
		pthread_t ThreadClient;
		Identifiant Pseudo;
		}Client;		

/*---------------PROTOTYPES---------------*/

SOCKET server_init(void);
void* controleur(void* data);
void* employe(void* data);
int Ecrit(const char *message, const char *employe);
int OuvreRapport(const char *employe);
void envoiFichier(SOCKET sock, char *path);
void serveur(void);
void exitConnexion(SOCKET sock);

#endif
