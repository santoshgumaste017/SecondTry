using System;
using System.Collections.Generic;
using System.Data.SqlTypes;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IncidentLibrary
{
    public class TicketLibrary
    {
     public   List<Ticket> ticketarray;
        public TicketLibrary() {
            ticketarray = new List<Ticket>()
            {
                //network outages, malfunctioning hardware assets like routers and printers, or an unresponsive application
                new Ticket(){TicketId=1,TicketType="feed back",TicketDescription="this is a feedback"},
                new Ticket(){TicketId=2,TicketType="network outages",TicketDescription="network outgrages 1"},
                new Ticket(){TicketId=3,TicketType="malfunctioning",TicketDescription="mal funcitoning of printer"},


                new Ticket(){TicketId=4,TicketType="feedback",TicketDescription="this is feedback2"},
                new Ticket(){TicketId=5,TicketType="netwrok outages",TicketDescription="networj outrages 2"},
                new Ticket(){TicketId=6,TicketType="malfunctioning",TicketDescription="mal functioning of scanner"},

            };


        
        }

        public void AddTicket(Ticket ticket)
        {
            Ticket exisitingTicket = ticketarray.Where(t => t.TicketId == ticket.TicketId).FirstOrDefault();



            if (ticket.TicketType == "Feedback" || ticket.TicketType == "network outages" || ticket.TicketType == "malfunctioning")
            {
                ticketarray.Add(ticket);
                foreach (Ticket t in GetAllTickets())
                {
                    Console.WriteLine($"Id : {t.TicketId} TicketType : {t.TicketType} TicketDescription : {t.TicketDescription}");
                }
            }
            else
            {
               
                    throw new InvalidTicketException("Ticket Type should be Feedback/malfunctioning/network outages");
               



            }
        }

        public List<Ticket> GetAllTickets()
        {
            return ticketarray;
        }

        public bool GetTicketById(int id)
        {
            bool flag = true;
            foreach (Ticket ticket in ticketarray)
            {
                if (ticket.TicketId == id) {
                    flag = true;
                    break;
                }
                else
                {
                    flag = false;
                }
            }
            return flag;
               
        }


    }
}
