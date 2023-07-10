package com.Email.EmailApp;

import com.model.Ticket;
import com.util.RoutingTickets;
import com.util.Util;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	Util u=new Util();
    	String url = "jdbc:mysql://localhost:3306/CustomerSupportDB";
        String user = "root";
        String password = "root";
        List<Ticket> t = new ArrayList<Ticket>();
        

        List data = new ArrayList();
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CustomerSupport");
            System.out.println(resultSet);
            while(resultSet.next())
    		{
            	Ticket tt = new Ticket(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),0);
            	
    	        t.add(tt);
    		}
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        System.out.println("Reading text file and determing SLA time");
        t = u.findSLATime(t);
    	
    	System.out.println("Routing Generated Tickets to a Tech Support engineer with Ticket Details");
    	RoutingTickets.routeGeneratedTickets(t);
   
    	 
    	System.out.println("Sending all tickets raised to Line Manager");
    	 GEMailSender mail=new GEMailSender();
         String from="santoshgumaste017@gmail.com";
      
         String to="santoshgumaste017@gmail.com";
         String sub="Tickets Raised for the Day";
         
         mail.sendEmailToLineManager(to,from,sub, t);
     
    }
    	}
    
