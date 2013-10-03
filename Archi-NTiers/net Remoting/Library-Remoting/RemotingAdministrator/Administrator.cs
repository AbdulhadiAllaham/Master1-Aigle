using System;
using System.Collections.Generic;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Http;
using System.Runtime.Remoting.Channels.Tcp;

using RemotingInterfaces;

namespace RemotingAdministrator
{
    public class Administrator
    {
        
        //Paramètres adminsitrateur
        String nomAdmin = "";
        String password = "";
        bool estConnecte = false;
        String URL = "";
        IAdministrateur biblio;
        

        public Administrator()
        {

            
        }


        public Administrator(String UrlServer){

            TcpChannel chan = new TcpChannel();
            ChannelServices.RegisterChannel(chan, true);
            this.URL = UrlServer;
            // Récupération de l'objet distribué => 1 seule isntance pour tous les clients
            biblio = (IAdministrateur)Activator.GetObject(typeof(IAdministrateur), URL);
            
        }

        public bool Connexion(String nomadm, String pswadm)
        {

            if (biblio.AutentifierBib(nomadm, pswadm))
            {
                this.nomAdmin = nomadm;
                this.password = pswadm;
                this.estConnecte = true;
                return true;
            }

            return false;
        }

        public String Createlivre(String auteur, String titre, String isbn, String editeur, String nombreex)
        {
            if (this.estConnecte == true)
            {
                return biblio.AddLivre(auteur, titre, isbn, editeur, nombreex);
            }
            else
            {
                return "vousn n'est pas connecté";
            }
           
        }


        
        

        public String AddLivre(String verfiAdmin, String verifpassword,ILivre livre)
        {
            return biblio.AjouterLivre(verfiAdmin, verifpassword);
        }

        

       

        public String AddAbonne(String nomAbonne, String pswdabbone)
        {
            return biblio.AddAbonne(nomAbonne, pswdabbone);
        }

        public String DeleteLivre(String isbn)
        {
            return biblio.DeleteLivre(isbn);
        }

        public bool EstConnecte()
        {
            return this.estConnecte;
        }

        public bool Deconnexion()
        {
            this.estConnecte = false;
            biblio.DeconnexionAbonne();
            return true;
        }
    }
}
