using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ClientDateHeure
{
    class Program
    {
       

        static void Main(string[] args)
        {
            localhost.Service service = new localhost.Service();
          

            
            int year = service.StructureDateHoure().year;
            int month = service.StructureDateHoure().month;
            int day = service.StructureDateHoure().day;
            int hour = service.StructureDateHoure().hour;
            int minute = service.StructureDateHoure().minute;
            int second = service.StructureDateHoure().second;
            String total = service.StructureDateHoure().stringdateheure;

            Console.WriteLine("Year :"+year);
            Console.WriteLine("Month :"+month);
            Console.WriteLine("Day :"+day);
            Console.WriteLine("Hour :"+hour);
            Console.WriteLine("Minute :"+minute);
            Console.WriteLine("Second :" + second);
            Console.WriteLine(total);


            Console.ReadLine();
           



        }
    }
}
