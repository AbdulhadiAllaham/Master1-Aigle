using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using RemotingInterfaces;

namespace RemotingAdministrator
{
    class Executer
    {
        public static int Main(string[] args)
        {
            Administrator admin = new Administrator("tcp://localhost:8089/Biblio");
            
            Console.WriteLine("test de connexion");

            if (admin.Connexion("gilles", "test"))
            {
                Console.WriteLine("OK");
            }
            else
            {
                Console.WriteLine("PAS OK");
            }


            String livree = admin.Createlivre("Gilles", "Gilles", "isbn", "gillesedit", "12");
            String livree2 = admin.Createlivre("Gilles2", "Gilles2", "Gilles2", "Gilles2edit", "15");


            Console.WriteLine(livree);
            Console.WriteLine(livree2);

           // Console.WriteLine(admin.DeleteLivre("Gilles2"));

            Console.WriteLine(admin.AddAbonne("Foofoo","foo"));
            //Console.WriteLine(admin.addLivre("gilles", "test", livree));

           
               // Console.WriteLine(admin.AjouterAbonnee("moh", "oran"));

            Console.ReadLine();
            return 0;
        }
    }
}
