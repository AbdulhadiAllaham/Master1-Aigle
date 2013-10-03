using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using RemotingInterfaces;

namespace RemotingAbonne
{
    class LancerAbonne
    {
        public static int Main(string[] args)
        {
            Abonne abonne = new Abonne("tcp://localhost:8089/Biblio");

            Console.WriteLine("test de connexion");

            if (abonne.Connexion("Foofoo", "foo"))
            {
                Console.WriteLine("OK");
            }
            else
            {
                Console.WriteLine("PAS OK");
            }

            Console.WriteLine(abonne.AjoutCommentaire("isbn", "le commenaire pour ce livre"));
            Console.WriteLine(abonne.AjoutCommentaire("isbn", "ce livre est nul"));
            ILivre liv = abonne.RecherparISBN("isbn");

            Console.WriteLine(liv.Auteur);

            List<ILivre> listliv = abonne.RechercheparAteur("Gilles");

            foreach (ILivre livre in listliv)
            {
                Console.WriteLine(livre.Titre);
            }

            List<String> listCommentaire = abonne.RecupererCommentaires(liv);

            foreach (String comm in listCommentaire)
            {
                Console.WriteLine(comm);
            }

            Console.ReadLine();
            return 0;
        }
    }
}
