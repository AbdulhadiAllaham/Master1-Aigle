using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using RemotingInterfaces;

namespace WebServiceClient
{
    class Program
    {
        static void Main(string[] args)
        {


            localhost.Service service = new localhost.Service();

            if (service.TestDeConnexion("test", "test"))
            {
                Console.WriteLine("connexion ok");
            }
            
            Console.WriteLine(service.Connexion("gilles","gilles"));
            Console.WriteLine(service.Connexion("anne", "anne"));
            Console.WriteLine(service.Connexion("test", "test"));
            //Console.WriteLine(service.RechercheParISBN("abc"));
            String [] titresparAuteur;
            titresparAuteur = service.RechercheParAteur("blabla");
            foreach (String titre in titresparAuteur)
            {
                Console.WriteLine(titre);
            }
            
            Console.WriteLine(service.AjoutCommentaire("test","test","blabla","commentblabla"));
            
           
        }
    }
}
