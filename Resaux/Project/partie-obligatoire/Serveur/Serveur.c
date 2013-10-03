/*Use this command to compile : gcc Serveur.c -lpthread -o Serveur `pkg-config --cflags --libs gtk+-2.0` */

#include "Serveur.h"


Identifiant IDClient;
ListeEmp lEmp;
ListeRapport lRapp;
Client clients[LENGTH]; //tableau de type structure "Client",où seront stocker tous les clients qui se connectent
int nombre_controleur = 0;
int bloquer = 1;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t mutex2 = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t condition = PTHREAD_COND_INITIALIZER;

int numEmp;
char** Emp_ayant_redige_un_rapport = NULL;


/*
 *========================================================================================================================= 
 * 							LE MAIN								
 *========================================================================================================================= 
 */

int main() 
{  
  serveur(); 	/* Lancement du serveur */
  
  pthread_cond_destroy(&condition);	/* Détruit une variable conditionnelle et libére les ressources qu'elle possède. */
  pthread_mutex_destroy(&mutex);	/* Détruit un mutex et libére les ressources qu'il possède. */
  pthread_mutex_destroy(&mutex2);	
  free(Emp_ayant_redige_un_rapport);   /* Libére l'espace mémoire pointé par le pointeur Emp_ayant_redige_un_rapport */
  
  return 0;
}

/*
 *========================================================================================================================= 
 * 							THREAD_CONTROLEUR								
 *========================================================================================================================= 
 */

void* controleur(void* data)
{
  char selection[30];
  char demande [10];
  int i;
  
  printf("Thread du Controleur.\n");
  
  Client *client = (Client*) data;
  int recvList=0;

  recv(client->SockClient, &demande, sizeof(demande),0); //attente si le Controleur veut saisir une liste ou s'il veut consulter un rapport

  if(strcmp("verifi",demande) == STR_EGAL)
  {
    if (lEmp.nbrEmp == 0)
    {
	sprintf(demande,"listVide");
	send(client->SockClient, &demande, sizeof(demande),0); // s'il n'y a pas de liste, on l'indique au controleur
    }
    else
    {
	sprintf(demande,"listOK");
	send(client->SockClient, &demande, sizeof(demande),0); // S'il y a déjà une liste de saisie (pour savoir si on affiche l'option 1 dans le menu du controleur)
	recv(client->SockClient, &demande, sizeof(demande),0); // pour vérifier si un des employés de la liste a enregisté un rapport

	if(strcmp("rappVeri",demande) == STR_EGAL)
	{
	    if (lRapp.nbrRapp == 0)
	    {
		sprintf(demande,"pasRapp");
		send(client->SockClient, &demande, sizeof(demande),0);  // S'il n'y a pas de rapport d'enregistrer par un employé
	    }
	    else 
	    {
		sprintf(demande,"rappOK");
		send(client->SockClient, &demande, sizeof(demande),0); // S'il y a au moins un rapport d'enregistrer
	    }
	}
    }
  }
     
     
  do
  { 
      recv(client->SockClient, &demande, sizeof(demande),0); // recevoir le choix du controleur
      if(strcmp("laListe",demande) == STR_EGAL)  // S'il souhaite consulter un des rapports et demande la liste des employés ayant enregistrés un rapport
      {
	  lRapp.nbrRapp = numEmp; // numEmp = nombre d'employés ayant enregistrés un rapport
      
	  for(i = 0 ; i< lRapp.nbrRapp ; i++)
	  {
	      strcpy(lRapp.rapId[i], Emp_ayant_redige_un_rapport[i]); // On copie le contentu du tableau malloc dans un tableau de chaînes de caractère pour l'envoyer
	  }
      
	  send(client->SockClient, &lRapp, sizeof(lRapp),0); // Envoi de la liste contenant l'identifiant des employés ayant rédigés un rapport
	  recv(client->SockClient, &selection, sizeof(selection),0); // Récupération de l'identifiant de l'employé choisi par le contrôleur pour consulter son rapport

      
	  char path [20];
	  strcpy(path,selection);
	  sprintf(selection,"dispo");
	  
	  send(client->SockClient, &selection, sizeof(selection),0); // Signaler au contrôleur que le rapport est disponible
	  
	  envoiFichier(client->SockClient, path); // Envoi du fichier PDF au contrôleur
      }
  }while(strcmp("laListe",demande) == STR_EGAL);
  
  
  if(strcmp("saiListe",demande) == STR_EGAL) /*Si le contrôleur souhaite saisir une nouvelle liste (attention: si nouvelle liste et un employé est encore connecté, 
						le controleur se met en attente*/
  {
	pthread_mutex_lock(&mutex2);
	
	while(bloquer != 1)
	{
	  pthread_cond_wait(&condition, &mutex2);
	} 
	Emp_ayant_redige_un_rapport = malloc(sizeof(Identifiant)); //Allocation de l'espace mémoire
	
	lRapp.nbrRapp = 0;
	numEmp = 0;
	bzero(lEmp.tabId,MAX_EMPLOYE);
	lEmp.nbrEmp = 0;

      recvList = recv(client->SockClient, &lEmp, sizeof(lEmp), 0); //Reçoit la liste des employés
      
      pthread_mutex_unlock(&mutex2);

      if(recvList != SOCKET_ERROR) // Vérification de la liste
      {
	  printf("Reception de la liste [OK]...\n"); 
	  for(i=0; i<lEmp.nbrEmp; i++)
	  {
	      printf("Employe %d = %s\n",i+1,lEmp.tabId[i]);
	  }
      }
      else
      {
	  printf("Reception de la liste [ECHEC]...\n");
      }
  }
  nombre_controleur = 0;
  pthread_exit(NULL); // Fermeture du thread
}

/*
 *========================================================================================================================= 
 * 							THREAD_EMPLOYE									
 *========================================================================================================================= 
 */

void* employe(void* data)
{
  printf("Thread de l'Employe.\n");
  
  Client *client = (Client*) data; //Structure passé en argument lors de la création du thread
  
  bloquer ++;
  int i, k;
  int receptionReponse, len, verificationListe;
  char rep;
  
  do // Tant que l'Employé n'a pas signalé la fin de la saisie
  {
	recv(client->SockClient, &len, sizeof(len), 0); //Reçoit la taille du bloc qui va être envoyé par l'Employé
	
	char *bloc = malloc(len + 1); /*Allocation d'un bloc de mémoire*/
	
	if(bloc == NULL)
	{
	    printf("[ERREUR] Echec lors de l'allocation mémoire.\n"); 
	}	
	
	int nb_carac_recu = 0;
	while(nb_carac_recu != len)
	{
	  int nb_carac = recv(client->SockClient, &bloc[nb_carac_recu], len - nb_carac_recu, 0);
	  if(nb_carac == SOCKET_ERROR)
	  {
	      printf("[ERREUR] Echec lors de la reception du bloc.\n");
	  }
	  nb_carac_recu = nb_carac_recu + nb_carac;
	}
	bloc[len] = 0;

	Ecrit(bloc,client->Pseudo); // On sauvegarde le bloc dans le fichier .tex

	printf("%s\n",bloc); // Affiche le bloc reçu

	receptionReponse = recv(client->SockClient, &rep, sizeof(char), 0); // On vérifie si l'employé continue la saisie de son rapport (O/N)

	if(receptionReponse != SOCKET_ERROR)
	{
	    printf("Reception reponse [OK]...\n");
	}
	else
	{
	    printf("Reception reponse [ECHEC]...\n");
	}
	
  }while(rep !='N');

  OuvreRapport(client->Pseudo); //Enregistrement du rapport que l'employé vient de rédiger au format pdf sur le serveur
   
  pthread_mutex_lock(&mutex2);	/* Protéger l'accès à la variable "bloquer" lorsqu'un Controleur essayes d'envoyer une nouvelle liste alors qu'un employé 
				est entrain de rédiger un rapport (Utilisé avec la Variable Conditionnelle)*/
				
  pthread_mutex_lock(&mutex); /* Protéger l'accès au tableau malloc si plusieurs employés ont fini de rédiger un rapport en même temps.*/
	
  for(i=0;i<lRapp.nbrRapp;i++)
  {	
      // Vérification si l'employé n'est pas déjà dans la liste
      if(strcmp(Emp_ayant_redige_un_rapport[i],client->Pseudo) == STR_EGAL)
      { 
	  verificationListe = 1;
      }
  }
	
  //Enregistrement de l'identifiant de l'employé dans un tableau malloc
  if(verificationListe != 1)
  {
      Emp_ayant_redige_un_rapport[numEmp] = client->Pseudo; //Ajout de l'employé dans la liste des employés ayant rédigés un rapport.
      numEmp++;
  }	
	
  pthread_mutex_unlock(&mutex); /*Libérer le verrou*/

  
  
  /*Afficher la liste des employés ayant rédigés un rapport (En guise de vérification)*/
  for(k=0; k<numEmp; k++)
  {
      printf("Employé sauvegardé = %s\n",Emp_ayant_redige_un_rapport[k]);
  }
     
  lRapp.nbrRapp = numEmp;// Enregistrement du nombre de rapports
  bloquer--;
     
  if(bloquer == 1)
  {
      pthread_cond_signal(&condition); /*Signaler au thread Controleur la fin de la saisie d'un rapport.*/
  }
     
  pthread_mutex_unlock(&mutex2); /*Libérer le verrou*/
   
  envoiFichier(client->SockClient, client->Pseudo); // Envoi du fichier PDF à l'Employé
  
  pthread_exit(NULL); //Fin du thread
}

/*
 *=================================================================================================================================
 * 					FONCTION - SERVER_INIT()
 *								# Création et itialisation des paramêtres du serveur									
 *=================================================================================================================================
 */

SOCKET server_init(void)
{
  int sock_err;
  int yes = 1; 
  /* Création d'une socket */
  SOCKET sockS = socket(AF_INET, SOCK_STREAM, 0);
  
  SOCKADDR_IN sin;
  
  if(sockS == INVALID_SOCKET)
  {
      perror("socket()");
  }
  printf("\n\nLa socket %d est maintenant ouverte en mode TCP/IP\n", sockS);
  
  /*Configuration de la socket*/
  sin.sin_addr.s_addr = htonl(INADDR_ANY);  /* Adresse IP automatique */
  sin.sin_family = AF_INET;                 /* Protocole familial (IP) */
  sin.sin_port = htons(PORT);               /* Listage du port */
  
  /*Pour éviter le problème : "bind(): address already in use"*/
  if(setsockopt(sockS, SOL_SOCKET, SO_REUSEADDR, &yes, sizeof(int)) == -1) 
  {
      perror("setsockopt()");
  }
  
  sock_err = bind(sockS, (SOCKADDR*)&sin, sizeof(sin));
  
  // Si la socket echoue 
  if(sock_err == SOCKET_ERROR)
  {
      perror("bind()");
  }
  
  //Démarrage du listage (mode server) 
  sock_err = listen(sockS, MAX_EMPLOYE);
  
  if(sock_err == SOCKET_ERROR)
  {
      perror("listen()");
  }
  else
  {
      printf("Socket en mode listen sur le port %d...\n", PORT);
  }
   
  return sockS;   
}

/*
 * ==========================================================================================================================
 * 						FONCTION - ECRIT()
 * 								 # Saisi du rapport au format .TEX
 * ==========================================================================================================================
 */

int Ecrit(const char *message, const char *employe) 
{
  FILE *f;
  int res;
  struct stat st; 
  time_t t;
  struct tm *tmp;
  char buff[TAILLEBUF];
  GString *s = NULL;
  
  // setlocale(LC_TIME, "fr_FR") si vous n'utilisez pas l'encodage utf8
  if (setlocale(LC_TIME, "fr_FR.utf8")==NULL) {
    perror("probleme avec setlocal ");
    return -1;
  }
  
  if (strlen(employe) >= 20) {
    fprintf(stderr, "Le nom de l'employé est trop long : %s\n", employe);
    return -1;
  }

  res = stat(employe, &st);
  if (res == -1) {
    if (errno == ENOENT) { // le répertoire n'existe pas
      res = mkdir(employe, S_IRWXU|S_IRGRP|S_IXGRP|S_IROTH|S_IXOTH);
      if (res == -1) {
	perror("problème à la création du répertoire");
	return -1;
      }
    } else {
      perror("problème à l'ouverture du répertoire");
      return -1;
    }
  } else {
    if (!(S_ISDIR(st.st_mode))) {
      fprintf(stderr, "problème car '%s' existe déja mais n'est pas un répertoire\n", employe);
      return -1;
    }
  }
  
  s = g_string_new(employe);
  g_string_append(s, "/");
  g_string_append(s, employe);
  g_string_append(s, ".tex");
  
  f = fopen(s->str, "a+");
  
  // calcul du temps
  t = time(NULL);
  tmp = localtime(&t);
  if (tmp == NULL) {
    perror("problème avec localtime : ");
    exit(-1);
  }
  
  //  titre = g_string_new("\n\section{");
  res = strftime(buff, TAILLEBUF, "\n\\section{%A %e %B %Y %Hh %Mmin %Ss}\n",tmp);
  if (res == 0) {
    perror("probleme avec strftime : ");
    return -1;
  }
  
  fprintf(f, "%s\n", buff);
  fprintf(f, "%s\n", message);
  
  g_string_free(s, TRUE);
  fclose(f);
  return 0;
}

/*
 * ==========================================================================================================================================
 * 						PROCEDURE - ENVOIFICHIER()
 * 								         #Envoi d'un fichier a l'employe ou au controleur
 * ==========================================================================================================================================
 */


void envoiFichier(SOCKET sock, char *path)
{
    char slash[10]  = "/";
    char point[100]  = ".";
    strcat(point,slash);
    strcat(point,path);
    strcat(point,slash);
    strcat(point,"temp.pdf");  // chemin vers le fichier en question
    printf("Path :%s\n",point);

    struct stat s;
    if(stat(point,&s) != 0)
    {
      printf("error");
    }
  
    long file_size = s.st_size; //On récupère la taille en bytes du fichier pdf
    printf("%d\n", (int) file_size);
    
    send(sock, &file_size, sizeof(file_size),0);    // Envoi de la taille du fichier pdf
  
    char buffer_rapport[LENGTH]; 
    printf("[Client] Envois le fichier %s au client... ", point);
    FILE *fich;
    fich = fopen(point, "r"); //Ouverture du fichier en format lecture
    if(fich == NULL)
    {
      printf("ERROR: Ficher %s pas trouvé.\n", point);
      exit(1);
    }
    
    bzero(buffer_rapport, LENGTH);  // on reinitialise buffer_rapport 
    
    int size_rapport; 
    while((size_rapport = fread(buffer_rapport, sizeof(char), LENGTH, fich)) > 0)
    {
      if(send(sock, buffer_rapport, size_rapport, 0) < 0)
      {
	fprintf(stderr, "ERROR: Pouvait pas envoyer fichier %s. (errno = %d)\n", point, errno);
	break;
      }

    bzero(buffer_rapport, LENGTH);
    }
    fclose(fich);
    printf("Ficher %s a été envoyé au client [OK].... \n", point); 		
}

/*
 * ==========================================================================================================================
 * 						PROCEDURE - SERVEUR()
 * 								    # Lancement du serveur ...
 * ==========================================================================================================================
 */

void serveur(void)
{
  SOCKADDR_IN size_rapport;
  socklen_t csocksize = sizeof(size_rapport);
  int i, j=0, msgErr=2, msgOk=3, rec;
  char verif_Controleur[20];
  SOCKET sockServ = server_init();//Initialisation du serveur
  
  while(1)
  {	
      // Attente pendant laquelle un employe se connecte 
      printf("\nPatientez pendant qu'un employe se connecte sur le port %d...\n", PORT);
      
      clients[j].SockClient = accept(sockServ, (SOCKADDR*)&size_rapport, &csocksize); //Accepter connexion d'un client
      if(clients[j].SockClient != INVALID_SOCKET)
      {
	  rec = recv(clients[j].SockClient, clients[j].Pseudo, sizeof(clients[j].Pseudo), 0); //Réception de l'identifant
      }
    
      //Si reception == succès
      if(rec != SOCKET_ERROR)
      {
	  printf("Reception Identifiant [OK]...\n");
	  int test = 0;

	  if(strcmp("Controleur",clients[j].Pseudo) == STR_EGAL) // Identifiant = Contrôleur
	  {     
	    if(nombre_controleur == 0)
	    {  
	      strcpy(verif_Controleur,"ok"); // si pas d'autre controleur connecté
	      send(clients[j].SockClient, &verif_Controleur, sizeof(verif_Controleur),0); // Signaler qu'il est le premier contrôleur à se connecter
	      printf("Le controleur se connecte avec la socket %d de %s:%d\n", clients[j].SockClient, inet_ntoa(size_rapport.sin_addr), htons(size_rapport.sin_port));
	      printf("Identifiant = %s\n\n",clients[j].Pseudo);
	      
	      pthread_create(&clients[j].ThreadClient, NULL, controleur, &clients[j]); // Création du thread Contrôleur
	      nombre_controleur = 1;
	    }
	    else
	    {
	      strcpy(verif_Controleur,"non-ok"); // si pas d'autre controleur connecté
	      send(clients[j].SockClient, &verif_Controleur, sizeof(verif_Controleur),0); // Signaler qu'il est le premier contrôleur à se connecter

	    }
	  }	
	  else
	  {
	      printf("L'employe se connecte avec la socket %d de %s:%d\n", clients[j].SockClient, inet_ntoa(size_rapport.sin_addr), htons(size_rapport.sin_port));    
	      printf("Identifiant = %s\n",clients[j].Pseudo); 
	      if(lEmp.nbrEmp != 0) // Si la liste des employés n'est pas vide
	      {
		  for(i=0; i<lEmp.nbrEmp; i++)
		  {
		      printf("Employe %d = %s\n",i+1,lEmp.tabId[i]);
		      if(strcmp(lEmp.tabId[i],clients[j].Pseudo) == STR_EGAL)
		      {
			  
			  send(clients[j].SockClient, &msgOk, sizeof(int), 0); /* On envoi à l'employé le message stipulant qu'il figure bien dans la liste 
										  des employés qui doivent rédiger un rapport.*/
			  printf("IDENTIFIANT TROUVÉ %s\n",clients[j].Pseudo);
			  
			  test = 1; // On met à 1 la variable test pour s'assurer qu'un employé s'est connecté
			  
			  pthread_create(&clients[j].ThreadClient, NULL, employe, &clients[j]);//on lance le thread ou va etre recu les donnes de se client
		      }
		  }
		  if(test !=1) // Si identifiant n'est pas dans la liste
		  {
		      msgErr=4;
		      send(clients[j].SockClient, &msgErr, sizeof(int), 0); // On indique à l'employé qu'il ne doit pas rédiger de rapport
		      printf("Liste envoyée par le controleur mais identifiant pas trouvé.\n");
		  }
	      }
	      else
	      {
		  printf("[NOTE] La liste n'a pas encore été envoyée...\n");
		  
		  int senErr = send(clients[j].SockClient, &msgErr, sizeof(int), 0); // On indique à l'employé que la liste n'a pas encore été envoyé
		  if(senErr != SOCKET_ERROR)
		    {
		      printf("Envoi du message d'erreur [OK]...\n");
		    }
		  else
		    {
		      printf("Envoi du message d'erreur [ECHEC]... \n");
		    }
	      }	
	    }
      }
      else
      {
	  printf("Reception Identifiant [ECHEC]...\n"); // Dans le cas où l'identifiant du controleur ou de l'employé n'a pas été reçu
      }
      
      j++; // On incrémente j pour créer une nouvelle structure dans le tableau de structures "clients" lors de la prochaine connexion d'un client.
    }
    exitConnexion(sockServ);
}

/*
 * ==========================================================================================================================
 * 						FONCTION - OUVRERAPPORT()
 * 									 # Ouverture d'un rapport au format .PDF
 * ==========================================================================================================================
 */

int OuvreRapport(const char *employe) {
  int res, r;
  FILE *f;
  GString *s = NULL;
  struct stat st;
  
  res = stat(employe, &st);
  if (res == -1) {
    perror("problème à l'ouverture du répertoire");
    return -1;
  }
  if (!(S_ISDIR(st.st_mode))) {
    fprintf(stderr,
	    "problème car '%s' existe mais n'est pas un répertoire\n",
	    employe);
    return -1;
  }
  
  s = g_string_new(employe);
  g_string_append(s, "/");
  g_string_append(s, employe);
  g_string_append(s, ".tex");

  res = open(s->str, O_RDONLY);
  if (res == -1) {
    fprintf(stderr, "problème à l'ouverture du fichier %s\n",
	    s->str);
    perror("");
    return -1;
  }
  close(res);
  g_string_free(s, TRUE);

  res = open(FICHIERIMAGE, O_RDONLY);
  if (res == -1) {
    fprintf(stderr, "problème à l'ouverture du fichier image %s\n",
	    FICHIERIMAGE);
    perror("");
    return -1;
  }
  close(res);
  

  s = g_string_new(employe);
  g_string_append(s, "/temp.tex");

  f = fopen(s->str, "w");
  g_string_free(s, TRUE);

  fprintf(f, "\\documentclass{article}\n\\usepackage[utf8]{inputenc}\n\\usepackage[frenchb]{babel}\n\\usepackage{graphics,graphicx}\n");
  fprintf(f, "\\title{Rapport d'activité}\n\\date{Université Montpellier 2 \\\\ \\mbox{}\\\\ \\mbox{}\\\\\\includegraphics[width=13cm]{../vuillemin.jpg}}\n");
  fprintf(f, "\\author{%s}", employe);
  fprintf(f, "\\begin{document}\n\\maketitle\n\\newpage\n");
  fprintf(f, "\\include{%s}\n", employe);
  fprintf(f, "\\end{document}\n");
  fclose(f);
  
  s = g_string_new("cd ");
  g_string_append(s, employe);
  g_string_append(s, "/; pdflatex temp.tex");
  system(s->str);
  g_string_free(s, TRUE);
  
  s = g_string_new(employe);
  g_string_append(s, "/temp.pdf");
  
  r = open(s->str, O_RDONLY);
  if (r < 0) {
    fprintf(stderr, "problème à l'ouverture du fichier pdf %s\n",
	    s->str);
    perror("");
    return -1;
  }
  g_string_free(s, TRUE);
  
  return r;
}

/*
 * ==========================================================================================================================
 * 						PROCEDURE - EXITCONNEXION()
 * 									  # FERME LA SOCKET DANS LES DEUX SENS
 * ==========================================================================================================================
 */

void exitConnexion(SOCKET sock)
{
       shutdown(sock, 2);
}

