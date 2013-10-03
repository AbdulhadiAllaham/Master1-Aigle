using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RemotingInterfaces
{

        // Différentes interfaces pour Abonné, Administrateur et Livre
        //Interface générale => Méthode accessibles pour tous les utilisateurs
        public interface IBibliotheque
        {
            ILivre RechercheParISBN(String isbn);
            String RechercheParISBNString(String isbn);
            List<ILivre> RechercheParAuteur(String auteur);
            List<String> RecupererCommentaires(ILivre livre);
        }
        // Interface pour l'abonné
        public interface IAbonne : IBibliotheque
        {
            bool Authentifaction(String nomUtilisateur, String password);
            String AjouterCommentaire(String isbn, String commentaire);
            void Deconnecter();
        }
        // Interface pour l'administrateur (méthodes à implémenter)
        public interface IAdministrateur : IBibliotheque
        {
            String AddAbonne(String numUtilsiateur, String password);
            //  String AjouterLivre(String verfiAdmin, String verifpassword, ILivre livre);
            String AjouterLivre(String verfiAdmin, String verifpassword);
            String DeleteLivre(String isbn);
            bool AutentifierBib(String verfiAdmin, String verifpassword);
            ILivre Livre(String auteur, String titre, String isbn, String editeur, String nombreex);
            String AddLivre(String auteur, String titre, String isbn, String editeur, String nombreex);
            bool DeconnexionAbonne();
           
        }
        //Interface Livre (getters et setters)
        public interface ILivre
        {
            String Auteur { get; }
            String Titre { get; }
            String Isbn { get; }
            String Editeur { get; }
            String NombreExamplaire { get; set; }
            String Affiche();
            List<String> Commentaires { get; }

        }
    }

