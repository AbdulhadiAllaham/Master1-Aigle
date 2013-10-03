/*Use this command to compile : gcc Controleur.c -o Controleur */

#include "Controleur.h"

SOCKET csock;

//int envoiDemande, envoiReponse;

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
  
  ListeRapport lRapp;
  char demande [10];
  char selection[30];
  char rappSuppl[2];
  char verif_Controleur [20];
  int choix;
  int envoi;
  //Pour passer l'@ IP en paramètre à la fonction CONNEXION()
  char param[30];

  strcpy(param, argv[1]);
  
  // Procedure de connexion du controleur
  int connexionCtl = connexion(param);
  if(connexionCtl != CONNEXION_ECHEC)
  {
      recv(csock, &verif_Controleur, sizeof(verif_Controleur),0); //Vérification si un autre processus contrôleur s'est déjà connecté
      if(strcmp(verif_Controleur,"ok") == STR_EGAL) //S'il n'y a pas d'autre contrôleur
      {
	  sprintf(demande,"verifi");
	  send(csock, &demande, sizeof(demande),0); // Vérification s'il y a déjà une liste
	  recv(csock, &demande, sizeof(demande),0); 

	  if(strcmp("listVide",demande) == STR_EGAL) // S'il n'y a pas encore de liste, on n'affiche l'option 1, on passe directement à la saisie de la liste
	  {
	      sprintf(demande,"saiListe"); 
	      send(csock, &demande, sizeof(demande),0); // Indication au serveur qu'une liste va être saisie
	      send_list(); 
	  }
	  else if(strcmp("listOK",demande) == STR_EGAL) // S'il y a déjà une liste, on affiche l'option 1
	  {
	      choix = menu(); 
	      switch(choix)
	      {
		  case 1: 
			  sprintf(demande,"saiListe");
			  send(csock, &demande, sizeof(demande),0); // Indication au serveur qu'une liste va être saisie
			  envoi = send_list();
      
			  if(envoi != SOCKET_ERROR)
			  {
			      printf("Envoi de la liste au serveur [OK]....\n"); 
			      exitConnexion(csock);
			  }
			  else
			  {
			      printf("Envoi [ECHEC]....\n");
			  }
			  break;

		  case 2:
			  do
			  {
			      sprintf(demande,"laListe");
			      send(csock, &demande, sizeof(demande),0); // Indication au serveur que le contrôleur veut consulter la liste de rapports
			      recv(csock, &lRapp, sizeof(lRapp),0);

			      int longMalloc = 0;
			      printf("Les employés ayant rédigé un rapport sont: \n");
			      for(longMalloc=0;longMalloc<lRapp.nbrRapp;longMalloc++)
			      {
				  printf("---> Employe %d : %s\n",longMalloc + 1,lRapp.rapId[longMalloc]);
			      }
			      
			      int verification = 0;
      
			      while(verification != 1) // tant que le contrôleur ne saisit pas un identifiant qui figure dans la liste
			      {
				  printf("Veuillez sélectionner le rapport que vous voulez consulter: \n");
				  scanf("%s",selection);
      
				  for(longMalloc=0;longMalloc<lRapp.nbrRapp;longMalloc++)
				  {
				    if(strcmp(lRapp.rapId[longMalloc],selection) == STR_EGAL) 
				    {
				      verification = 1;
				    }
				  }
			      }
      
			      for(longMalloc=0;longMalloc<lRapp.nbrRapp;longMalloc++)
			      {
				  if(strcmp(lRapp.rapId[longMalloc],selection) == STR_EGAL)
				  {
				      send(csock, &selection, sizeof(selection),0); // Envoi de l'identifiant choisi au serveur
				  }
			      }
	 
			      char path[30];
			      strcpy(path,selection);
			      
			      recv(csock, &selection, sizeof(selection),0); //Vérification supplémentaire si rapport est disponible

			      if(strcmp("dispo",selection) == STR_EGAL)
			      {	
				  recevoirFichier(csock,path);
			      }
			      
			      do
			      {
				  printf("Voulez vous consulter un autre rapport? (O/N): "); 
				  scanf("%s",&rappSuppl[0]);
			      }while(strcmp("O",&rappSuppl[0]) != STR_EGAL && strcmp("N",&rappSuppl[0]) != STR_EGAL); //Tant que le contrôleur ne saisit pas "O" ou "N"
			      
			  }while(strcmp("N",&rappSuppl[0]) != STR_EGAL); // Tant que le contrôleur ne saisit pas "N"
										     
			  sprintf(demande,"finliste");
			  send(csock, &demande, sizeof(demande),0); // Fin de la consultation
			  exitConnexion(csock);
			  break;

		  default: 
			  printf("choix invalide.\n");
	      }
	  }
      }
  else
  {
      printf("Un autre contrôleur s'est déjà connecté, essayez ultérieurement.\n");
      exitConnexion(csock);
  }
  }
  
  return 0;
}

/*
 * ====================================================================================================================================
 * 							CONNEXION DU CONTROLEUR
 * ====================================================================================================================================
 */

int connexion(char param[30])
{
  
  Identifiant IDCtl;
  
  SOCKADDR_IN sin;
  
  sprintf(IDCtl, "Controleur");
  
  //Création de la socket 
  csock = socket(AF_INET, SOCK_STREAM, 0);
	
  //Configuration de la connexion 
  sin.sin_addr.s_addr = inet_addr(param);
  sin.sin_family = AF_INET;
  sin.sin_port = htons(PORT);

  int connCtl = connect(csock, (SOCKADDR*)&sin, sizeof(sin));
  printf("\nConnexion à %s sur le port %d avec la socket %d...\n\n", inet_ntoa(sin.sin_addr), htons(sin.sin_port), csock);
  
  //Si le client arrive à se connecter 
  if(connCtl != SOCKET_ERROR)
    {
      int sen = send(csock, &IDCtl, sizeof(IDCtl), 0);
      //Si envoi == succès
      if(sen != SOCKET_ERROR)
	{
	  printf("Envoi de l'identifiant au serveur [OK]....\n"); 
	  printf("%s\n", IDCtl);
	}
      else
	{
	  printf("Envoi de l'identifiant [Echec]....\n");
	  exitConnexion(csock);
	}
    }
  else
    {
      printf("Connexion au serveur [ECHEC]...\n");
      exitConnexion(csock);

    }
  
  return connCtl;
}

/*
 * ====================================================================================================================================
 * 							MENU DU CONTROLEUR
 * ====================================================================================================================================
 */

int menu(void)
{
  char ch [2] ;
  int choix;
  char demande [10];
  
  printf("\t--------------------------------------------------\n");
  printf("\t|          	     MENU CONTROLEUR             |\n");
  printf("\t--------------------------------------------------\n\n\n");
  
  
  printf("\t1. Pour saisir et envoyer une nouvelle la liste d'employés, tapez '1'.\n");
  
  sprintf(demande,"rappVeri");
  send(csock, &demande, sizeof(demande),0);
  recv(csock, &demande, sizeof(demande),0);
  
  if(strcmp("rappOK",demande) == STR_EGAL){
  printf("\t2. Pour consulter un rapport, tapez '2'.\n\n");
  
  do
    {
      printf("Veuillez saisir votre choix : ");
      scanf("%s",&ch[0]);
    }while(strcmp("1",&ch[0]) != STR_EGAL && strcmp("2",&ch[0]) != STR_EGAL);
  
    
  }
  else{
  do
    {
      printf("Veuillez saisir votre choix : ");
      scanf("%s",&ch[0]);
    }while(strcmp("1",&ch[0]) != STR_EGAL);   
  }
  
  if(strcmp("1",&ch[0]) == STR_EGAL)
  {
    choix = 1;
  }
  else if(strcmp("2",&ch[0]) == STR_EGAL)
  {
    choix = 2;
  }

  return choix;
}

/*
 * ====================================================================================================================================
 * 							ENVOI DE LA LISTE
 * ====================================================================================================================================
 */

int send_list(void)
{
  ListeEmp lEmp;
  char buffer [100];
  
  
  do{
   printf("Saisir le nombre d'employés qui doivent rédiger un rapport : ");
   scanf("%s",&buffer[0]);
  }while((sscanf(buffer, "%d", &lEmp.nbrEmp)) != 1);
  
  
  int i;
  for(i=0; i<lEmp.nbrEmp; i++)
    {
      printf("ID employe %d = ",i+1);
      scanf("%s",lEmp.tabId[i]);
    }
  
  
  // POUR AFFICHER LE CONTENU DE LA LISTE (en guise de TEST) 
  printf("\n\n");
  for(i=0; i<lEmp.nbrEmp; i++)   
    {
      printf("%s\n",lEmp.tabId[i]);
    }
  
  int sen;
  sen = send(csock, &lEmp, sizeof(lEmp), 0);
  return sen;
}

/*
 * ====================================================================================================================================
 * 							RECEPTION DU FICHIER
 * ====================================================================================================================================
 */

void recevoirFichier(SOCKET sock, char* id_employe)
{  
  printf("\n\t\t+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
  printf("\n\t\t+								      +");
  printf("\n\t\t+			CONSULTATION DU RAPPORT		       +");
  printf("\n\t\t+								      +");
  printf("\n\t\t+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\n");
  
  long taille_fichier;
  char repertoire [100] = "Rapport_";
  strcat(repertoire,id_employe); // ajout du nom de l'employé 
  
  mkdir(repertoire, S_IRWXU|S_IRGRP|S_IXGRP|S_IROTH|S_IXOTH); // Création du répertoire
  
  recv(sock, &taille_fichier, sizeof(taille_fichier),0); //Recevoir taille du fichier qui va être reçu
  
  printf("on recoit %d octets\n", (int)taille_fichier); 

  char slash[10]  = "/"; 
  char chemin_rapport[100]  = ".";
    
  printf("%s\n",id_employe);
  printf("%s\n",slash);
  printf("%s\n",chemin_rapport);

  strcat(chemin_rapport,slash);
  strcat(chemin_rapport,repertoire);
  strcat(chemin_rapport,slash);
  strcat(chemin_rapport,id_employe);
  strcat(chemin_rapport,".pdf"); // on a une chaîne de caractère avec le chemin complet et le nom du fichier à créer
  printf("%s\n",chemin_rapport);
    
  int inc=0;
  char* nom_fichier = chemin_rapport; // crée pointeur avec chemin vers fichier pdf
  FILE *creer_fichier = fopen(nom_fichier, "w+"); // créer le fichier pdf (opetion w+ pour écraser le fichier s'il existe déjà
  char reception_buffer[LENGTH]; // buffer réception
  if(creer_fichier == NULL)
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
      int write_sz = fwrite(reception_buffer, sizeof(char), recvRapport, creer_fichier); // on écrit dans le fichier pdf
      if(write_sz < recvRapport) // en case d'erreur
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
    if(fclose(creer_fichier)!=0) //fermeture du fichier
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

