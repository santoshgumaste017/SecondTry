using System;
using System.Runtime.Serialization;

namespace IncidentLibrary
{
   
    public class InvalidTicketException : Exception
    {
       public InvalidTicketException(string message) : base(message)
        {
        }

   
    }
}