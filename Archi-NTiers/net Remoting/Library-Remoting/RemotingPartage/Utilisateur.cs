using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using RemotingInterfaces;

namespace RemotingPartage2
{
    public partial class Biblio : IBibliotheque
    {
        // classe contentant les méthodes accessibles pour toute sorte d'utilisateur
        public ILivre RechercheParISBN(String isbn)
        {
            ILivre liv = null;
            foreach (ILivre livre in listeLivres)
            {
                if (livre.Isbn.Equals(isbn))
                {
                     liv=livre;
                }

            }

            return liv;            

        }

        public List<ILivre> RechercheParAuteur(String auteur)
        {
            List<ILivre> listliv = new List<ILivre>();
            foreach (ILivre livre in listeLivres)
            {
                if(livre.Auteur.Equals(auteur)){
                    listliv.Add(livre);
                }
            }

            return listliv;

        }


        public List<String> RecupererCommentaires(ILivre livre)
        {
           return livre.Commentaires;
    
        }
        




      

    }
}
