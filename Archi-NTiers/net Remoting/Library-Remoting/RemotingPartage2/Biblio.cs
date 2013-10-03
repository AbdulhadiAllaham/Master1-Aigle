using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using RemotingInterfaces;


namespace RemotingPartage2
{
    // Classe qui va être distribuée, comportant des méthodes générales utilisables par toutes les "sous-classes" de la classe biblio
    // partial class :  Chaque fichier source contient une section de la définition de classe, et toutes les parties sont combinées lorsque l'application est compilée. Il est souhaitable de fractionner une définition de classe dans plusieurs situations
    public partial class Biblio : MarshalByRefObject
    {
        List<ILivre> listeLivres;
        Dictionary<String, String> listeAbonnes;
        Dictionary<String, String> listeAdmins;

        // Construction d'une bibliothèque, ajout de deux administrateurs
        public Biblio()
        {
            listeLivres = new List<ILivre>();
            listeAbonnes = new Dictionary<string, string>();
            listeAdmins = new Dictionary<string, string>();

            this.AddAmin("gilles", "test");
            this.AddAmin("foo", "foo");
            Console.WriteLine("Création de l'instance Bibliotèhque");
            foreach (String key in listeAdmins.Keys)
            {
                Console.WriteLine("Admin du nom" + key +" ajouté ");
            }
        }

       
        // Méthode pour s'autentifier (utilisé pour authentifier l'abonné)
       public bool AuthentificationServer(String nomUtilisateur, String password)
       {
           String passw = "";
           if (listeAbonnes.ContainsKey(nomUtilisateur))
           {
               listeAbonnes.TryGetValue(nomUtilisateur, out passw);
               if (password.Equals(passw))
               {
                   return true;
               }
               else
               {
                   Console.WriteLine("Password non ok");
                   return false;
               }
           }
           else{
               return false;
           }
       }

        // Méthode pour authentifier l'administrateur
       public bool AuthentificationAdmin(String nomUtilisateur, String password)
       {
           if (listeAdmins.ContainsKey(nomUtilisateur))
           {
               string passwo;
               listeAdmins.TryGetValue(nomUtilisateur, out passwo);
               if (password.Equals(passwo))
               {
                   return true;
               }
               else
               {
                   return false;
               }
           }
           else
           {
               return false;
           }
       }

        // Méthode pour ajouter un livre
       public void AjouterLivreServer(ILivre livre)
       {
           Console.WriteLine("Livre de titre " + livre.Titre + " ajouté à la bibliothèque");
           listeLivres.Add(livre);
       }

        // Ajouter un nouveau abonné
       public String AjouterAbonne(string nomUtilisateur, string password)
       {
           if (nomUtilisateur.Length != 0 && password.Length != 0)
           {
               if (!listeAbonnes.ContainsKey(nomUtilisateur))
               {
                   listeAbonnes.Add(nomUtilisateur, password);
                   Console.WriteLine("Nouveau abonné ajouté avec le nom d'utilisateur : " + nomUtilisateur);
                   return "Ajout de l'abonné " + nomUtilisateur + " effectué";
               }
               else
               {
                   return "Abonné existe déjà";
               }
           }
           else
           {
               return "erreur";
           }
       }


        // Ajouter un nouveau administrateur
       public void AddAmin(string nomAdmin, string password)
       {
           if (nomAdmin.Length != 0 && password.Length != 0)
           {
               if(!listeAdmins.ContainsKey(nomAdmin)){
                    listeAdmins.Add(nomAdmin,password);
               }
           }
       }


       public override String ToString()
       {
           String tostring = "Les livres de la bibliothèque: ";
           foreach (ILivre livre in listeLivres)
           {
               tostring += livre.Affiche();
           }

           return tostring;
       }


     




    }
        
}
