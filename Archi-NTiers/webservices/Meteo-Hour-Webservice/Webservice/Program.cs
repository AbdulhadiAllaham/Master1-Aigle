using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using System.Globalization;
using Webservice.convert;

namespace Webservice
{
    class Program
    {
        static void Main(string[] args)
        {

            wheather.GlobalWeather meteo = new wheather.GlobalWeather();
            Consult consulter = new Consult();
           
            XmlDocument parseur = new XmlDocument();
            XmlDocument parseur2 = new XmlDocument();
            String weather = meteo.GetWeather("Montpellier", "France");
            Console.WriteLine(weather);
            String citysbycountry = meteo.GetCitiesByCountry("France");
           // Console.WriteLine(citysbycountry);

            parseur.LoadXml(citysbycountry);
            XmlNodeList villes;
            villes = parseur.GetElementsByTagName("Table");

            for (int i = 0; i < villes.Count; i++)
            {
              //  Console.WriteLine(villes[i].SelectNodes("City").Item(0).InnerText);
            }

            parseur2.LoadXml(weather);
            XmlNodeList infometeo;
            infometeo = parseur2.SelectNodes("CurrentWeather");

            String location = infometeo[0].SelectNodes("Location").Item(0).InnerText;
            String vent = infometeo[0].SelectNodes("Wind").Item(0).InnerText;
            String visibilite = infometeo[0].SelectNodes("Visibility").Item(0).InnerText;
            String tempertaure = infometeo[0].SelectNodes("Temperature").Item(0).InnerText;

            Console.WriteLine("Location " +location);
            Console.WriteLine("Vent " +vent);
            Console.WriteLine("Visibilité " +visibilite);
            Console.WriteLine("Température" +tempertaure);

            Console.WriteLine("Pays?");
            String pays = Console.ReadLine();
            Console.WriteLine("Ville?");
            String ville = Console.ReadLine();
            List<String> meteoo = new List<String>();
            Boolean consultverif = consulter.Consulter(pays, ville);
            if (consultverif)
            {
                meteoo = consulter.ParseCurrentWeather(pays, ville);
                foreach (String weatherstring in meteoo)
                {
                    Console.WriteLine(weatherstring);
                }
            }
            else
            {
                meteoo = consulter.CitybyCountry(pays);
                foreach (String parsedcities in meteoo)
                {
                    Console.WriteLine(parsedcities);
                }
                Console.WriteLine("La ville "+ville+" n'exite pas, veuillez entrer une ville se trouvant dans la liste ci-dessus");
                String villesectionnee = Console.ReadLine();
                consultverif = consulter.Consulter(pays, villesectionnee);
                if (consultverif)
                {
                   
                    meteoo = consulter.ParseCurrentWeather(pays, ville);
                    foreach (String weatherstring in meteoo)
                    {
                        Console.WriteLine(weatherstring);
                    }
                }
                else
                {
                    Console.WriteLine("Vous êtes incapables de consulter la météo pour une ville");
                }
            } 

            convert.ConvertTemperature convertemp = new convert.ConvertTemperature();

            Console.Write("Température à convertir :");
            String temperatureString = Console.ReadLine();
            double temperature = Convert.ToDouble(temperatureString);
            //double temperature = double.Parse(temperatureString, CultureInfo.InvariantCulture);

            Console.Write("Unité de temperature à convertir (Celsius/Fahrenheit): ");
            String uniteTemperature = Console.ReadLine();

            switch (uniteTemperature)
            {
                case "Celsius":

                    double celsKelv = convertemp.ConvertTemp(temperature, TemperatureUnit.degreeCelsius, TemperatureUnit.kelvin);
                    Console.WriteLine("Temperature en Celsius " + temperature);
                    Console.WriteLine("Temperature en Kelvin " + celsKelv);
                    break;

                case "Fahrenheit":

                    double fahKelv = convertemp.ConvertTemp(temperature, TemperatureUnit.degreeFahrenheit, TemperatureUnit.kelvin);
                    Console.WriteLine("Temperature en Fahrenheit " + temperature);
                    Console.WriteLine("Temperature en Kelvin "+ fahKelv);
                    break;

                default:
                    Console.WriteLine("Choix invalide !!");
                    break;

            }


        }
    }
}
