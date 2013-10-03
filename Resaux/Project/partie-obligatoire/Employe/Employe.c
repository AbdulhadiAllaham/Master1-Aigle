/*Use this command to compile : gcc Employe.c -o Employe */

#include "Employe.h"


SOCKET csock;
BLOC bloc;
Identifiant IDEmp;

/*
 *======================================================================================================================
 * 							LE MAIN							
 *======================================================================================================================
 */

int main(int argc, char *argv[]) 
{  
  
  //Erreur dans le passage de paramêtre lors du lancement du processus Employé
  if(argc != 2)
  {
    fprintf(stderr, "\n\t[ERREUR] Syntaxe Incorrecte.\n\t--->Essayez plutot : %s adresseIP\n\n", argv[0]);
    exit(0);
  }
  
  int msgErr=-1;
  
  printf("\n\t\t+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
  printf("\n\t\t+								     +");
  printf("\n\t\t+			   IDENTIFICATION		             +");
  printf("\n\t\t+								     +");
  printf("\n\t\t+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\n");
  
  printf("\n\tSaisir l'ID de l'employé: ");
  scanf("%s",IDEmp);
  
  //Pour passer l'@ IP en paramètre à la fonction CONNEXION()
  char param[30];
  strcpy(param, argv[1]);
  
  // Procedure de connexion de l'employe
  int connexionEmpl;
  connexionEmpl = connexion(param, IDEmp); // Appel à la fonction connexion qui permet à l'employé de se connecter au serveur.
  
  
  int ackList = recv(csock, &msgErr, sizeof(int),0); // Accusé de reception de la liste sur le serveur
  
  if(ackList != SOCKET_ERROR)
  {
    // Message retourné si le serveur indique que la liste n'a pas encore été envoyée par le controleur.
    if(msgErr == 2)
    {
	printf("\n\t---------------------------------------------------------------");
	printf("\n\t\tLa liste n'a pas encore été envoyée. \n\t\tAU REVOIR.");
	printf("\n\t---------------------------------------------------------------\n");
	exitConnexion(csock); // Déconnexion.
    } 
    
    // Message retourné si le serveur signale que l'employé n'a pas de rapport à rédiger pour le moment.
    if(msgErr == 4)
    {
	printf("\n\t---------------------------------------------------------------------------");
	printf("\n\t\t%s, pas de rapport à rédiger de votre part pour le moment.", IDEmp);
	printf("\n\t-------------------------------------------------------------------------\n");
	exitConnexion(csock); // Déconnexion.
    }
    
    // Si la liste a été envoyée et que l'employé figure dans la liste de ceux qui doivent rédiger un rapport.
      else if (msgErr == 3)
      {
	  if(connexionEmpl != CONNEXION_ECHEC)
	  {
	      sendBlocRapport();  // Appel de la fonction sendBlocRapport() qui permet de rédiger un rapport.
	  }
	      recevoirFichier(csock); // Appel à la fonction qui permet de recevoir le rapport après rédaction et de l'ouvrir automatiquement.
	      
	      exitConnexion(csock); // Déconnexion.
	}
    }
  return 0;
}

/*
 * ====================================================================================================================================
 * 							CONNEXION DE L'EMPLOYE
 * ====================================================================================================================================
 */

int connexion(char param[30], Identifiant IDEmp)
{	

  printf("\n\t\t+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
  printf("\n\t\t+								      +");
  printf("\n\t\t+			CONNEXION AU SERVEUR			      +");
  printf("\n\t\t+								      +");
  printf("\n\t\t+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
  
  
  SOCKADDR_IN sin;
  
  Identifiant IDEmploye;
  strcpy(IDEmploye, IDEmp);
  
  //Création de la socket 
  csock = socket(AF_INET, SOCK_STREAM, 0);
  
  //Configuration de la connexion 
  sin.sin_addr.s_addr = inet_addr(param);
  sin.sin_family = AF_INET;
  sin.sin_port = htons(PORT);
  
  int connEmp = connect(csock, (SOCKADDR*)&sin, sizeof(sin)); // Pour se connecter au serveur
  printf("\nConnexion à %s sur le port %d avec la socket %d...\n\n", inet_ntoa(sin.sin_addr), htons(sin.sin_port), csock);
    	
  //Si le client arrive à se connecter au serveur.
  if(connEmp != SOCKET_ERROR)
  {
      int sen = send(csock, &IDEmploye, sizeof(IDEmploye), 0); // Envoi de l'identifiant de l'employé au serveur.
      //Si envoi == succès
      if(sen != SOCKET_ERROR)
      {
	  printf("Envoi de l'identifiant %s au serveur [OK]....\n", IDEmp); 
      }
      else
      {
	  printf("Envoi de l'identifiant [ECHEC]....\n");
	  exitConnexion(csock); // Déconnexion sur erreur.
      }
  }
  else
  {
      printf("Impossible de se connecter...\n");
      exitConnexion(csock); // Déconnexion sur erreur.
  }
  
  return connEmp;
}

/*
 * ======================================================================================================================================================
 * 									ENVOI DU BLOC DE RAPPORT
 * ======================================================================================================================================================
 */

void sendBlocRapport(void)
{
  int nbrCarac; 
  int nbr_carac_env;
  int senRep; 
  char rep[2]; 
  
  printf("\n\t\t+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
  printf("\n\t\t+								      +");
  printf("\n\t\t+			REDACTION DU RAPPORT			      +");
  printf("\n\t\t+								      +");
  printf("\n\t\t+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
  do
  {

      printf("\n\nVeuillez saisir votre bloc de données: \n");
      lire_chaine(); // Donc on a notre message stocké dans la variable "bloc".
    
    
    int len = strlen(bloc);
    
    //envoi de la longueur du bloc
    nbrCarac = send(csock, &len, sizeof(len), 0);
    if (nbrCarac != SOCKET_ERROR)
    {
	printf("Envoi nbrCarac bloc [OK]...%d\n",len);
    }
    else
    {
      printf("Envoi nbrCarac bloc [ECHEC]...\n");
    }
    
    nbr_carac_env = send(csock, bloc, len, 0);  // Envoi du bloc de données au serveur.
    
    if(nbr_carac_env != SOCKET_ERROR)
    {
	printf("Envoi du bloc [OK]...\n");
    }
    else
    {
	printf("Envoi du bloc [ECHEC]...\n");
    }

    printf("\n");

    do
    {
      printf("Encore un bloc de données à saisir? (O/N): ");
      scanf("%s",&rep[0]);
    }while(strcmp("O",&rep[0]) != STR_EGAL && strcmp("N",&rep[0]) != STR_EGAL);
    
    senRep = send(csock, &rep, sizeof(char), 0);
    if(senRep != SOCKET_ERROR)
    {
      printf("Envoi reponse [OK]...\n");
    }
    else
    {
      printf("Envoi reponse [ECHEC]...\n");
      exitConnexion(csock); // Déconnexion sur erreur.
    }
  
  }while(strcmp("N",&rep[0]) != STR_EGAL);
  
}


/*
 * ======================================================================================================================================================
 * 							PROCEDURE POUR ECRIRE UNE SECTION DU RAPPORT
 * ======================================================================================================================================================
 */

void lire_chaine(void)
{
    int i=0;
    char c;

    c = getchar();
    do
    {
	bloc[i]=c;
	c=getchar();
	i++;
    }while(c!='\n');
    
    bloc[i]='\0';
}

/*
 * ==========================================================================================================================
 * 						PROCEDURE - RECEVOIR UN FICHIER
 * ==========================================================================================================================
 */


void recevoirFichier(SOCKET sock)
{
  printf("\n\t\t+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
  printf("\n\t\t+								      +");
  printf("\n\t\t+			CONSULTATION DU RAPPORT		       +");
  printf("\n\t\t+								      +");
  printf("\n\t\t+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\n");
  
  long taille_fichier;
  char repertoire [100] = "Rapport_";
  strcat(repertoire,IDEmp); // ajout du nom de l'employé 
  
  mkdir(repertoire, S_IRWXU|S_IRGRP|S_IXGRP|S_IROTH|S_IXOTH); // Création du répertoire
  
  recv(sock, &taille_fichier, sizeof(taille_fichier),0); //Recevoir la taille du fichier qui sera envoyé par le serveur
  
  //printf("on recoit %d octets\n", (int)taille_fichier); 

  char slash[10]  = "/"; 
  char chemin_rapport[100]  = ".";
    
  printf("%s\n",IDEmp);
  printf("%s\n",slash);
  printf("%s\n",chemin_rapport);

  strcat(chemin_rapport,slash);
  strcat(chemin_rapport,repertoire);
  strcat(chemin_rapport,slash);
  strcat(chemin_rapport,IDEmp);
  strcat(chemin_rapport,".pdf"); // on a une chaîne de caractère avec le chemin complet et le nom du fichier à créer
  
  printf("%s\n",chemin_rapport);
    
  int inc=0;
  char* nom_fichier = chemin_rapport; // crée pointeur avec chemin vers fichier pdf
  FILE *fich = fopen(nom_fichier, "w+"); // Ouvre le fichier en mode Lecture et ecriture
  char reception_buffer[LENGTH]; // buffer de réception
  
  if(fich == NULL)
  {
    printf("Fichier %s ne peut pas être créé.\n", nom_fichier); 
    exitConnexion(sock);
  }
  else //si fichier pdf a été créé
  {
    bzero(reception_buffer, LENGTH); //initialisation à zéro
    int recvRapport = 0; 
    while(inc < taille_fichier ) //tant que tout le fichier n'a pas été reçu
    {
      recvRapport = recv(sock, reception_buffer, LENGTH, 0); // on reçoit le fichier pdf
      int write_sz = fwrite(reception_buffer, sizeof(char), recvRapport, fich); // on écrit dans le fichier pdf
      if(write_sz < recvRapport) // en cas d'erreur
      {
	perror("fwrite");
	exitConnexion(sock);
      }
      bzero(reception_buffer, LENGTH); //remise à zéro tant que la boucle tourne
      if (recvRapport == 0)  //cas d'erreur
      {
	break;
      }
      inc += recvRapport;//incrémenter inc du résultat du recv
    } 
    if(recvRapport < 0) // En cas d'erreur de réception du fichier
    {
	perror("recv()");
	exitConnexion(sock);
    }
    printf("Reception du rapport [OK]...\n");
    
    if(fclose(fich)!=0) //fermeture du fichier
    {
      perror("fclose()");
    } 
    
    char ouvir_rapport [100] = "evince";
      
    strcat(ouvir_rapport," ");
    strcat(ouvir_rapport, chemin_rapport);
    strcat(ouvir_rapport, "&");

    system(ouvir_rapport); //affichage automatique du fichier pdf

  }
}

/*
 * ===============================================================================================================================================
 * 					PROCEDURE - EXITCONNEXION()
 * 								  # Permet de fermer la socket dans les deux sens (Emission et Reception)
 * ===============================================================================================================================================
 */

void exitConnexion(SOCKET sock)
{
       shutdown(sock, 2);
}


