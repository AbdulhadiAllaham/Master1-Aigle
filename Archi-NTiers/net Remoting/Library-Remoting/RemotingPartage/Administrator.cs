using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using RemotingInterfaces;
namespace RemotingPartage2
{
    public partial class Biblio : IAdministrateur
    {
        public String Verification { get; set; }
        public String Password { get; set; }

        bool autenthifie = false;
        Livre liv = new Livre("Gilles", "Gilles", "1234", "GillesEdit", "100");

        // Ajouter un nouveau abonné
        public String AddAbonne(String numUtilisateur, String password)
        {
            String ajouter = "Ajout de l'abonne impossible";
            if (AuthentificationAdmin(Verification, Password))
            { 
                ajouter = AjouterAbonne(numUtilisateur, password);
            }
            return ajouter;
        }

        // Ajouter un nouveau livre avec vérification des identifiants (seulement pour tester)
        public String AjouterLivre(String verfiAdmin, String verifpassword)
        {
            String ajoutLivre = "Impossible d'ajouter le livre, vérifier les paramètres";
            if(AuthentificationAdmin(verfiAdmin,verifpassword)){
                AjouterLivreServer(liv);
                ajoutLivre= "Ajout du livre de nom "+liv.Auteur+" OK";
            }
            return ajoutLivre;      
        }

        // Supprimer un livre existant
        public String DeleteLivre(String isbn)
        {
            String deletelivre = "Impossible de supprimer ce livre";
            List<ILivre> listeasupprimer = new List<ILivre>();
            if (this.autenthifie == true)
            {
                foreach (ILivre liv in listeLivres)
                {
                    if(liv.Isbn.Equals(isbn)){
                        listeasupprimer.Add(liv);   
                    }
                    else deletelivre = "Livre n'existe pas";
                }
                foreach (ILivre livsupp in listeasupprimer)
                {
                    listeLivres.Remove(livsupp);
                    deletelivre = "Suppression effectuée";
                }
            }
            return deletelivre;
        }

        // Authentifiaction de l'administrateur
        public bool AutentifierBib(String verifAdmin, String verifpassword)
        {
            autenthifie = true;
            this.Verification = verifAdmin;
            this.Password = verifpassword;
            return AuthentificationAdmin(verifAdmin, verifpassword);
        }

        //Ajouter un nouveau livre avec auteur, titre etc.
        public String AddLivre(String auteur, String titre, String isbn, String editeur, String nombreex)
        {
            bool test = false;
            if (autenthifie == true)
            {         
                ILivre liv = new Livre(auteur, titre, isbn, editeur, nombreex);
                foreach (ILivre livv in listeLivres)
                {
                    if (livv.Isbn.Equals(liv.Isbn))
                    {
                        test = true;
                    } 
                }
                    if (test == false)
                    {
                        listeLivres.Add(liv);
                        return "Livre de titre" + titre + " ajouté avec succès à la bibliothèque";
                    }
                    else
                    {
                        return "Livre existe déjà";
                    }
            }
            else return "Veuillez vous authentifier";
        }

        // Se déconnecter
        public bool DeconnexionAbonne()
        {
            this.autenthifie = false;
            return false;
        }
    }
}
