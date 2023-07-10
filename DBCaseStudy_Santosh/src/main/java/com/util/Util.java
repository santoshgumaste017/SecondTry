package com.util;
import java.util.*;

import com.exception.InvalidTicketException;
import com.model.*;
import java.io.*;
public class Util 
{
	public List<Ticket> findSLATime(List<Ticket> ticketList)
	{
		int SLAhours;
		for(Ticket t:ticketList)
		{
			if(t.getTicketType().equals("Report a problem"))
			{
				t.setSlaHours(4);
				
			}
			else if(t.getTicketType().equals("Access Issue"))
			{
				t.setSlaHours(3);
			}
			else if(t.getTicketType().equals("General Enquiry"))
			{
				t.setSlaHours(2);
			}
			else if(t.getTicketType().equals("Feedback"))
			{
				t.setSlaHours(1);
			}
		}
		return ticketList;
	//	System.out.println(ticketList);
	}

public 	List<Ticket> readFile(String inputfeed)
	{
	List<Ticket> ticketlist = new ArrayList();
	FileInputStream inputStream = null;
	BufferedReader bufferedReader = null;
	try {
	if (inputfeed != null) {
		
			inputStream = new FileInputStream(inputfeed);
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String strline;
			boolean eligible=false;
			while ((strline = bufferedReader.readLine()) != null) {
				String[] fields = strline.split(",");
				int i=Integer.parseInt(fields[0]);
			try {
				if(validateTicketType(fields[1]))
			
				
					eligible=true;
				
				if(eligible)
				{
				Ticket t=new Ticket(i,fields[1],fields[2],fields[3],fields[4],0);
				ticketlist.add(t);
				
				}

}
	catch(InvalidTicketException  e)
	{
		//System.out.println(e);
	}
			}}}
	catch(Exception  e)
	{
		System.out.println(e);
	}
	List<Ticket> t=findSLATime(ticketlist);
	return t;
	//System.out.println(ticketlist);	
	}
	

public boolean validateTicketType(String s) throws InvalidTicketException
{
	if((s.equals("Report a problem"))||s.equals("Access Issue" )||s.equals("General Enquiry")||s.equals("Feedback"))
	{
		return true;
	}
	else
	{
		throw new InvalidTicketException("Invalid Ticket");
	}
}
}
