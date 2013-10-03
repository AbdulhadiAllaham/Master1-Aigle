using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RemotingPartage2
{
    public class Livre : MarshalByRefObject, RemotingInterfaces.ILivre
    {
        private String auteur;
        private String titre;
        private String isbn;
        private String editeur;
        private String nombreExamplaire;
        
        private List<string> commentaires;
        // Constructeur
        public Livre(String auteur, String titre, String isbn, String editeur, String nombreex)
        {
            this.auteur = auteur;
            this.titre = titre;
            this.isbn = isbn;
            this.editeur = editeur;
            this.nombreExamplaire = nombreex;
            this.commentaires = new List<String>();
           
            
        }

        //Getter / setters pour Auteur etc.
        public String Auteur
        {
            get { return this.auteur; }
        }

        public String Titre {
            get { return this.titre; }
        }

        public String Isbn {
            get { return this.isbn; }
        }

        public String Editeur {
            get { return this.editeur; }
        }

        public String NombreExamplaire
        {
            get { return this.nombreExamplaire; }
            set { this.nombreExamplaire = value; }
        }


        public List<string> Commentaires
        {
            get { return this.commentaires; }
            
        }


        public String Affiche()
        {
            String affiche = "";
            affiche += "Nom Livre :\t" + this.Titre + "\n";
            affiche += "Auteur :\t" + this.Auteur + "\n";
            affiche += "Editeur :\t" + this.Editeur + "\n";
            affiche += "ISBN13 :\t" + this.Isbn + "\n";
            affiche += "Examplaire :\t" + this.NombreExamplaire + "\n";
            return affiche;
        }
    }
}
