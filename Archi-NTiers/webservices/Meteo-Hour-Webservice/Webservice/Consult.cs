using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;

namespace Webservice
{
    class Consult
    {

        wheather.GlobalWeather meteox = new wheather.GlobalWeather();
        XmlDocument parseur = new XmlDocument();
        Dictionary<String, List<String>> countriesAndCities = new Dictionary<string,List<string>>();
        XmlNodeList liste;
        XmlDocument parseur2 = new XmlDocument();
        XmlDocument parseurtemp = new XmlDocument();


        public Consult()
        {

        }

        public List<String> ParseCurrentWeather(String pays, String ville)
        {
            String weather = meteox.GetWeather("Montpellier", "France");
            List<String> conditons = new List<String>();
           
            parseurtemp.LoadXml(weather);
            XmlNodeList infometeo;
            infometeo = parseurtemp.SelectNodes("CurrentWeather");


            String location = infometeo[0].SelectNodes("Location").Item(0).InnerText;
            String vent = infometeo[0].SelectNodes("Wind").Item(0).InnerText;
            String visibilite = infometeo[0].SelectNodes("Visibility").Item(0).InnerText;
            String tempertaure = infometeo[0].SelectNodes("Temperature").Item(0).InnerText;

            
            conditons.Add(location);
            conditons.Add(vent);
            conditons.Add(visibilite);
            conditons.Add(tempertaure);

            return conditons;

        }

        public bool Consulter(String pays, String ville)
        {
            bool search = false;
            String meteoxml = meteox.GetWeather(ville, pays);
            if (!meteoxml.Equals("Data Not Found"))
            {
                search = true;
                parseur.LoadXml(meteoxml);
              //  this.liste = parseur.SelectNodes("CurrentWheather");

            }
            else
            {
                addCountryandCity(pays);
            }


            return search;
        }


        public List<String> CitybyCountry(String pays)
        {
            String citysbycountry = meteox.GetCitiesByCountry(pays);
            List<String> listedesvilles = new List<string>();
            parseur.LoadXml(citysbycountry);
            XmlNodeList listeCities;
            List<String> listvilles = new List<String>();
            listeCities = parseur.GetElementsByTagName("Table");
            for (int i = 0; i < listeCities.Count; i++)
            {
                listvilles.Add(liste[i].SelectNodes("City").Item(0).InnerText);
            }
            return listvilles;
        }

        

        public void addCountryandCity(String pays)
        {
            String citysbycountry = meteox.GetCitiesByCountry(pays);
            List<String> listedesvilles = new List<string>();
            parseur.LoadXml(citysbycountry);
            this.liste = parseur.GetElementsByTagName("Table");

            if (!countriesAndCities.ContainsKey(pays))
            {
                countriesAndCities.Add(pays, new List<string>());
            }

            for (int i = 0; i < liste.Count; i++)
            {
                
                String citytrouve = liste[i].SelectNodes("City").Item(0).InnerText;

                foreach (KeyValuePair<String, List<String>> element in countriesAndCities)
                {
                    if (element.Key.Equals(pays))
                    {
                        element.Value.Add(citytrouve);
                    }

                }
            }
            
        }

       
    }
}
