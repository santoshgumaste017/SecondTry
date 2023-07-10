using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;
using IncidentLibrary;

namespace Inicident_UI
{
    internal class ExecuteTicket
    {
        Ticket t;
        TicketLibrary tl;

       public ExecuteTicket()
        {
            tl = new TicketLibrary();
        }
        public void Menu()
        {
            Console.WriteLine("Welome to Incident Management System"   );
            Console.WriteLine("1.Add a  new Ticket \n 2.Display all Tickets \n 3. Search a Ticket");
            Console.WriteLine("\n \n select an option");
            int choice = Convert.ToInt32(Console.ReadLine());

          switch ( choice ) {
                case 1:
                    AddTicketDetails();          
                break;
                case 2:
                    PrintAllTickets();
                break;
                case 3:
                    GetTicketById();
                break;
                default: Console.WriteLine("Invalid choice ....");
                    break;

            }

        }

        public void AddTicketDetails()
        {
            Ticket ticket = new Ticket();
            Console.WriteLine("Enter Ticket Id");
            ticket.TicketId = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Enter Ticket Type");
            ticket.TicketType=Console.ReadLine();
            Console.WriteLine("Enter ticket description");
            ticket.TicketDescription = Console.ReadLine();
            try
            {
                tl.AddTicket(ticket);
                Console.WriteLine("Ticket added successfully");
            } 
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine("Cannot add the Ticket try again");

                }

}

        public void PrintAllTickets()
        {
            List<Ticket> arr = tl.GetAllTickets();

            foreach (Ticket ticket in arr)
            {
                Console.WriteLine($"Id : {ticket.TicketId} TicketType : {ticket.TicketType} TicketDescription : {ticket.TicketDescription}");
            }
        }

        public void GetTicketById()
        {
            int num;
            Console.WriteLine("Enter Ticket Id");
            num = Convert.ToInt32(Console.ReadLine());

            bool result = tl.GetTicketById(num);

            if(result == true)
            {
                Ticket exisitingTicket = tl.ticketarray.Where(t => t.TicketId == num).FirstOrDefault();
                Console.WriteLine($"Id : {exisitingTicket.TicketId} TicketType : {exisitingTicket.TicketType} TicketDescription : {exisitingTicket.TicketDescription}");
            }
            else
            {
                Console.WriteLine($"ticket with id : {num} could not be found");
            }
        }
    }
}
