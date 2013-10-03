using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using share;

namespace ServiceRecettes
{

   // [ServiceBehavior(InstanceContextMode = InstanceContextMode.Single)]
    public static class Base 
    {
        public static List<Recette> baseRecettes = new List<Recette>();
        public static List<Recette> basedelaRecettes()
        {
            return baseRecettes;
        }
    }
   
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in both code and config file together.
    [ServiceBehavior(InstanceContextMode = InstanceContextMode.PerSession)]
    public class ServiceRecette : IServiceRecette
    {
        
        List<Recette> baseRecettes = Base.baseRecettes;
        //public Recette selectionCourante = new Recette();
        public List<Recette> selectionCour = new List<Recette>();
        
        public Recette recet = new Recette();


        int m_Counter = 0;

        public int MyMethod()
        {
            m_Counter++;
            return m_Counter;
        }


        public string GetData(int value)
        {
            return string.Format("You entered: {0}", value);
        }


        public CompositeType GetDataUsingDataContract(CompositeType composite)
        {
            if (composite == null)
            {
                throw new ArgumentNullException("composite");
            }
            if (composite.BoolValue)
            {
                composite.StringValue += "Suffix";
            }
            return composite;
        }

        public List<Recette> rechercheParNomIngredient(String nom)
        {
            List<Recette> listeRecettes = new List<Recette>();

            return listeRecettes;

        }

        public Recette newRecette(String nom)
        {
            Recette recette = new Recette();
            recette.Nom = nom;
            recette.Listeingredients = new List<Ingredient>();

            return recette;
        }

        public Ingredient newIngredient(String nom)
        {
            Ingredient ingredient = new Ingredient();
            ingredient.Nom = nom;
            return ingredient;
        }



        public List<Recette> searchRecette(Ingredient ingr)
        {
            List<Recette> liste = new List<Recette>();


            foreach (Recette rec in baseRecettes)
            {
                foreach (Ingredient ingred in rec.Listeingredients)
                {
                    
                    if (ingred.Nom.Equals(ingr.Nom))
                    {
                        if (!liste.Contains(rec))
                        {
                            Console.WriteLine("Nom de la recette recherchée : " + rec.Nom);
                            liste.Add(rec);
                            selectionCour.Add(rec);
                        }


                    }
                }
            }

            return liste;
        }



        public String getNomIngre(Ingredient ing)
        {
            return ing.Nom;
        }


        public String getNomRecette(Recette rec)
        {
            return rec.Nom;
        }




        public string deletecourante(String nom)
        {
            foreach (Recette rec in selectionCour)
            {
                if (rec.Nom.Equals(nom))
                {
                    selectionCour.Remove(rec);
                    Console.WriteLine("Suppression de la sélection courante effectuée");
                    return "Suppression de la sélection courante ok";
                }
            }

            return "Suppression impossible";
        }

        public List<Recette> getInfoCourante()
        {
            return selectionCour;
        }


        public string addRecette(Recette recettes)
        {
            this.recet = recettes;
            Boolean test = false;

            foreach (Recette rec in baseRecettes)
            {
                if (rec.Nom.Equals(recettes.Nom))
                {
                    test = true;
                }
            }

            if (test == false)
            {
                baseRecettes.Add(recet);
                Console.WriteLine("Ajout de la recette " + recet.Nom + " réussi");
                return "Ajout de la recette " + recet.Nom + " réussi";

            }
            else
            {
                Console.WriteLine("Recette avec même nom existe déjà : " + recet.Nom);
                return "Recette avec même nom existe déjà : " + recet.Nom;
            }
        }


        public void initializebase()
        {
            baseRecettes = new List<Recette>();
        }


        public List<Recette> listeBase()
        {
            return baseRecettes;
        }
    }
}
