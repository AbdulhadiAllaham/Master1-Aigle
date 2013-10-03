using System;
using System.Collections.Generic;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Http;
using System.Runtime.Remoting.Channels.Tcp;

using RemotingInterfaces;

namespace RemotingAbonne
{
    public class Abonne
    {

        String nomAbonne = "";
        String password = "";
        bool estConnecte = false;
        String URL = "";
        IAbonne abonne;
        
        public Abonne()
        {
        }

        public Abonne(String UrlServer)
        {
            TcpChannel chan = new TcpChannel();
            ChannelServices.RegisterChannel(chan, true);
            this.URL = UrlServer;
            // Récupération de l'objet distribué
            // Activation par client : (IAbonne)Activator.CreateInstance(typeof(IAbonne), URL);
            abonne = (IAbonne)Activator.GetObject(typeof(IAbonne), URL);
           
        }


        public bool Connexion(String nomabonne, String pswabonne)
        {
            
            if (abonne.Authentifaction(nomabonne, pswabonne))
            {
                this.nomAbonne = nomabonne;
                this.password = pswabonne;
                this.estConnecte = true;
                return true;
            }

            return false;
        }

        public String AjoutCommentaire(String isbn, String commentaire)
        {
            if (this.estConnecte == true)
            {
                return abonne.AjouterCommentaire(isbn, commentaire);
                
            }
            else
            {
                return "impossible d'ajouter le comentaire, veuillez vous connecter";
            }
        }

        public ILivre RecherparISBN(String isbn)
        {
      
                return abonne.RechercheParISBN(isbn);

        }

        public List<ILivre> RechercheparAteur(String auteur)
        {
            return abonne.RechercheParAuteur(auteur);
        }

        public List<String> RecupererCommentaires(ILivre livre)
        {
            return abonne.RecupererCommentaires(livre);
        }

        public bool EstConnecte()
        {
            return this.estConnecte;
        }

        public bool Deconnexion()
        {
            this.estConnecte = false;
            //abonne.DeconnexionAbonne();
            return true;
        }
         
    }
}
