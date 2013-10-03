using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using share;
using System.ServiceModel;

namespace Client
{
    class Program
    {
        static void Main(string[] args)
        {
            IServiceRecette recetteProxy = new ChannelFactory<IServiceRecette>("RecetteClient").CreateChannel();
          //  recetteProxy.initializebase();
            Console.WriteLine("proxy ok");

         /*   Console.WriteLine(recetteProxy.MyMethod());
            Console.WriteLine(recetteProxy.MyMethod());
            Console.WriteLine(recetteProxy.MyMethod());
            Console.WriteLine(recetteProxy.MyMethod());*/

            // Ajout de 3 recettes dans la base
            Recette recette = recetteProxy.newRecette("Pizza");
           
            Ingredient ingr1 = recetteProxy.newIngredient("tomate");
            Ingredient ingr2 = recetteProxy.newIngredient("salami");
            Ingredient ingr3 = recetteProxy.newIngredient("mozzarella");
            

            recette.Listeingredients.Add(ingr1);
            recette.Listeingredients.Add(ingr1);
            recette.Listeingredients.Add(ingr1);

            recetteProxy.addRecette(recette);


            Recette recettespagh = recetteProxy.newRecette("Spaghetti");

            Ingredient ingr1spagh = recetteProxy.newIngredient("tomate");
            Ingredient ingr2spagh = recetteProxy.newIngredient("spaghetti");
            Ingredient ingr3spagh = recetteProxy.newIngredient("ail");


            recettespagh.Listeingredients.Add(ingr1spagh);
            recettespagh.Listeingredients.Add(ingr2spagh);
            recettespagh.Listeingredients.Add(ingr3spagh);

            recetteProxy.addRecette(recettespagh);

            Recette recettecouscous = recetteProxy.newRecette("Coucous");

            Ingredient ingr1couscous = recetteProxy.newIngredient("couscous");
            Ingredient ingr2couscous = recetteProxy.newIngredient("courgette");
            Ingredient ingr3couscous = recetteProxy.newIngredient("pois");


          
            recettecouscous.Listeingredients.Add(ingr1couscous);
            recettecouscous.Listeingredients.Add(ingr1couscous);
            recettecouscous.Listeingredients.Add(ingr1couscous);

            recetteProxy.addRecette(recettecouscous);


            Console.WriteLine("Recettes Existantes dans la base : ");
            foreach (Recette rec in recetteProxy.listeBase())
            {
                Console.WriteLine(rec.Nom);
            }

            
            Console.WriteLine("Nom de la recette à créer?");
            String nomRecette = Console.ReadLine();
            // récupérer la recette
            Recette recette1 = recetteProxy.newRecette(nomRecette);
            //Console.WriteLine("Nom enregistré :" +recetteProxy.getNomRecette(recette1));

            Console.WriteLine("Combien d'ingrédients?");
            int nbingredients = Convert.ToInt32(Console.ReadLine());

            for (int i = 0; i < nbingredients; i++)
            {
                int ii = i + 1;
                Console.WriteLine("Nom de l'ingrédient numéro "+ii);
                String nomIngr = Console.ReadLine();
                // Nouveau ingrédient
                Ingredient ingr = recetteProxy.newIngredient(nomIngr);
               // Console.WriteLine(recetteProxy.getNomIngre(ingr));
                // Ajout de l'ingrédient à la recette
                recette1.Listeingredients.Add(ingr);
            }

            List<Ingredient> listingrr = recette1.Listeingredients;
            Console.WriteLine("Ingrédients dans la recette : "+recette1.Nom);
            foreach (Ingredient inr in listingrr)
            {
                Console.WriteLine(inr.Nom);
            }

            //Ajout de la recette à la base
            Console.WriteLine(recetteProxy.addRecette(recette1));
            Console.WriteLine(recetteProxy.addRecette(recette1));
            Console.WriteLine(recetteProxy.addRecette(recette1));

            Console.WriteLine("Ingredient pour recherche : ");
            String rechercheIng = Console.ReadLine();
            Ingredient ingredientcherch = null;

            Boolean test = false;
            // Voir si ingrédient existe dans une des recettes
            foreach (Recette rec in recetteProxy.listeBase())
            {
                foreach (Ingredient ingr in rec.Listeingredients)
                {
                   
                    if (ingr.Nom.Equals(rechercheIng))
                    {
                        ingredientcherch = ingr;
                        test = true;
                    }
                    
                }
                if (test == false)
                {
                    Console.WriteLine("Ingredient n'existe pas");
                }
            }

            List<Recette> listerecette = new List<Recette>();

            if (ingredientcherch != null)
            {
                // Rechercher par ingrédient
                listerecette = recetteProxy.searchRecette(ingredientcherch);
            }


            Console.WriteLine("Nombre de recettes trouvées : " +Convert.ToString(listerecette.Count));

            foreach (Recette rec in listerecette)
            {
                // Afficher toutes les recettes retrouvées
                Console.WriteLine("Nom de la recette " + rec.Nom);
            }

            foreach (Recette rec in recetteProxy.getInfoCourante())
            {
                Console.WriteLine("Infocourante : nom de la recette " + rec.Nom);
            }

            Console.WriteLine("Nom de la recette à supprimer de la sélection courante?");
            String supprimcourante = Console.ReadLine();
            Console.WriteLine(recetteProxy.deletecourante(supprimcourante));

            foreach (Recette rec in recetteProxy.getInfoCourante())
            {
                Console.WriteLine("Nouvelle info courante : " + rec.Nom);
            }

            if (recetteProxy.getInfoCourante().Count == 0)
            {
                Console.WriteLine("pas de sélection");
            }
            
            /*
            Recette recette = recetteProxy.newRecette("recette1");
            Console.WriteLine(recetteProxy.getNomRecette(recette));

            Ingredient ingr1 = recetteProxy.newIngredient("tomate");
            Ingredient ingr2 = recetteProxy.newIngredient("vin");
            Ingredient ingr3 = recetteProxy.newIngredient("jus");
            Console.WriteLine(recetteProxy.getNomIngre(ingr1));
            SelectionCourante selectioncour = new SelectionCourante();

           
            List<Ingredient> listingr = recette.Listeingredients;
            recette.Listeingredients.Add(ingr1);
            recette.Listeingredients.Add(ingr2);
            recette.Listeingredients.Add(ingr3);

            

            List<Ingredient> listingrr = recette.Listeingredients;
            foreach (Ingredient inr in listingr)
            {
                Console.WriteLine(inr.Nom);
            }

            foreach (Ingredient inr in listingrr)
            {
                Console.WriteLine(inr.Nom);
            }

            Console.WriteLine(recetteProxy.addRecette(recette));
            Console.WriteLine(recetteProxy.addRecette(recette));
            Console.WriteLine(recetteProxy.addRecette(recette));

            List<Recette> listrec = new List<Recette>();

            if (!listrec.Contains(recette))
            {
                listrec.Add(recette);
                Console.WriteLine("listerecette");
            }

            if (!listrec.Contains(recette))
            {
                listrec.Add(recette);
                Console.WriteLine("listerecette");
            }

            if (!listrec.Contains(recette))
            {
                listrec.Add(recette);
                Console.WriteLine("listerecette");
            }

           // recetteProxy.addRecette(baserecette, recette);


            List<Recette> listerecette = recetteProxy.listeRecette(ingr1);

           

            Console.WriteLine(Convert.ToString(listerecette.Count));

            foreach (Recette rec in listerecette)
            {
                Console.WriteLine("nom de la recette " + rec.Nom);
            }

            foreach (Recette rec in recetteProxy.getInfoCourante())
            {
                Console.WriteLine("infocourante " + rec.Nom);
            }

            Console.ReadLine();

            Console.WriteLine(recetteProxy.deletecourante("recette1"));

            foreach (Recette rec in recetteProxy.getInfoCourante())
            {
                Console.WriteLine("infocourante " + rec.Nom);
            }

            if (recetteProxy.getInfoCourante().Count == 0)
            {
                Console.WriteLine("pas de sélection");
            }

            */
            Console.WriteLine("Fin du client");
            Console.ReadLine();
              
             
        }
    }
}
