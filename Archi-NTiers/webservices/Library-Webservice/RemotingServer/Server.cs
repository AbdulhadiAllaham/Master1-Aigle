using System;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;
using System.Runtime.Remoting.Channels.Http;

using RemotingPartage2;

namespace RemotingServer
{
    class Server
    {
        public static int Main(string[] args)
        {
            
            // Creating a custom formatter for a TcpChannel sink chain
            BinaryServerFormatterSinkProvider provider = new BinaryServerFormatterSinkProvider();
            provider.TypeFilterLevel = System.Runtime.Serialization.Formatters.TypeFilterLevel.Full;
            // Creating the IDictionary to set the port on the channel instance.
            System.Collections.IDictionary props = new System.Collections.Hashtable();
            props["port"] = 8089;
            // Pass the properties for the port setting and the server provider in the server chain argument. (Client remains null here.)
            // TcpChannel = transport par socket
            TcpChannel chan = new TcpChannel(props, null, provider);
            
            
            ChannelServices.RegisterChannel(chan, true);
            // On distribue l'objet "Biblio"
            // Singleton = une seule isntance de serveur paratagée par tous les cleints, Singlecall : on voudrait créer de nouvelles instances de bibliothèque à chaque appel de méthode
            // Singleton : durée de vie = 5 minutes + 2 minutes à chaque appel de méthode
            
            RemotingConfiguration.RegisterWellKnownServiceType(typeof(Biblio), "Biblio", WellKnownObjectMode.Singleton);
            System.Console.WriteLine("Appuyez sur <entre> pour sortir...");
            System.Console.ReadLine();
            return 0;
        }
    }
}
