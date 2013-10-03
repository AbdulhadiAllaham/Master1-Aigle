using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using RemotingInterfaces;

namespace RemotingPartage2
{
    public partial class Biblio : IAbonne
    {
        bool autenthifieverif = false;

        //Ajout d'un commentaire par rapport à l'isbn d'un livre
        public String AjouterCommentaire(String isbn, String commentaire)
        {
            bool trouve = false;
            //Verficiation si l'utilisateur est connecté
            if (this.autenthifieverif==true)
            {
                foreach (ILivre livres in listeLivres)
                {
                    if (livres.Isbn.Equals(isbn))
                    {
                        livres.Commentaires.Add(commentaire);
                        Console.WriteLine(commentaire);
                        trouve = true;
                        return "Le commentaire "+commentaire+" a été ajouté au livre de titre "+livres.Titre;
                    }
                }
                // Si aucun livre correspond à l'isbn indiquée
                if (trouve == false)
                {
                    return "Livre avec l'ISBN "+isbn+" n'existe pas";
                }
            }
            // Si l'utilisateur n'est pas connecté
            else
            {
                Console.WriteLine("Erreur lors de l'authentifaction");
                return "Mauvais Nom d'utilisateur ou Password";
            }
            return null;
        }
        // Vérification des identifiants de l'utilisateur
        public bool Authentifaction(String nomUtilisateur, String password)
        {
            this.autenthifieverif = AuthentificationServer(nomUtilisateur, password);
            return AuthentificationServer(nomUtilisateur, password);
        }
        //Créer un nouveau livre
        public ILivre Livre(String auteur, String titre, String isbn, String editeur, String nombreex)
        {
            ILivre NewLivre = new Livre(auteur, titre, isbn, editeur, nombreex);
            return NewLivre;
        }
        //Déconnexion
        public void Deconnecter()
        {
            this.autenthifie = false;
        }

  
    }



}
