package com.util;
import java.util.*;

import com.Email.EmailApp.GEMailSender;
import com.model.Ticket;
public class RoutingTickets {

	public static void routeGeneratedTickets(List<Ticket> t)
	{
		for(Ticket t1:t)
    	{
    		if(t1.getTicketType().equals("Report a problem"))
    		{
    	
   	
    	
        GEMailSender mail=new GEMailSender();
        String from="santoshgumaste017@gmail.com";
       // String to="diazonic@gmail.com";
        String to="santoshgumaste017@gmail.com";
        String sub="test mail for Report a Problem";
       // String text="hi,how r u";
       boolean b= mail.sendEmail(to,from,sub, t1);
       if(b)
       {
    	   System.out.println("mail sent to Reporting Team successfully");
       }
       else
       {
    	   System.out.println("there is a problem sending email to Reporting Team");
       }
    		}
    		
    		if(t1.getTicketType().equals("Access Issue"))
    		{
    	
   	
    	
        GEMailSender mail=new GEMailSender();
        String from="santoshgumaste017@gmail.com";
       
        String to="santoshgumaste017@gmail.com";
        String sub="test mail for Access Issue";
      
       boolean b= mail.sendEmail(to,from,sub, t1);
       if(b)
       {
    	   System.out.println("mail sent to Access Issue  Team successfully");
       }
       else
       {
    	   System.out.println("there is a problem sending email to Access Issue Team");
       }
    		}
    	
    		
    }
    	//similar code for General Enquiry  to be sent to General Enquiry team
    	
    	//similar code for feedback to be sent to Feedback  team
    	 
		
	}

}
