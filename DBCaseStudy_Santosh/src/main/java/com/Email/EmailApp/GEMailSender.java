package com.Email.EmailApp;
import java.util.*;
import java.io.*;

import com.model.Ticket;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
public class GEMailSender {
	
	public boolean sendEmail(String to,String from,String subject,Ticket ticket)
	{
		boolean flag=false;
		
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable",true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host","smtp.gmail.com");
		
		 final String username="santoshgumaste017@gmail.com";
		final String password="bizlvqrfpveclirn";
		Session session=Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(username,password);
			}
			
		});
		try
		{
			Message message=new MimeMessage(session);
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
		//	message.setText(text);
			message.setText("Here is a new Ticket Raised\n"+" " +"Ticket Id:"+ticket.getTicketId()+"  "+
			"Ticket Type:"+ticket.getTicketType()+"  "+
			"Customer Name:"+ticket.getCustomerName()+"  "+
			"Phone Number:"+ticket.getPhone()+"  "+
			"Description Issue:"+ticket.getDescriptionIssue()+" "+
			"Ticket Type:"+ticket.getTicketType()+" "+
			"SLA Hours:"+ticket.getSlaHours());
			
			Transport.send(message);
			
			flag=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	public void  sendEmailToLineManager(String to,String from,String subject,List<Ticket> ticket)
	{
		PrintWriter pw=null;
		try {
		
		pw = new PrintWriter(new FileOutputStream("IssuesReport.txt"));
	    for (Ticket  t2 : ticket)
	        pw.println(t2.getTicketId()+" "+t2.getTicketType()+" "+t2.getCustomerName()+" "+t2.getPhone()+
	        		" "+t2.getDescriptionIssue()+"  "+"  "+t2.getSlaHours());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}pw.close();
		
		
		
		boolean flag=false;
		
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable",true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host","smtp.gmail.com");
	//	final String username="techsupport_engineer_emailid_here";
		 final String username="santoshgumaste017@gmail.com";
		final String password="bizlvqrfpveclirn";
		Session session=Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(username,password);
			}
			
		});
		try
		{
			Message message=new MimeMessage(session);
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
		
	         BodyPart messageBodyPart = new MimeBodyPart();
	       
	         messageBodyPart.setText("Dear Sir,Pls find the Issues reported for the Day as in attachment");

	         
	         Multipart multipart = new MimeMultipart();

	        
	         multipart.addBodyPart(messageBodyPart);

	        
	         messageBodyPart = new MimeBodyPart();
	         String filename = "IssuesReport.txt";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         message.setContent(multipart);

	        
	         Transport.send(message);

	         System.out.println("Sent message to Line Manager successfully....");
	  
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	}

}
