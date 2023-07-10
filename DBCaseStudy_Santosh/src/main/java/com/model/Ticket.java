package com.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Ticket {
	
	int ticketId;
	String  ticketType;
	String customerName;
	String phone;
	String descriptionIssue;
	int slaHours;
	public Ticket(int ticketId, String ticketType, String customerdetails,String phone, String descriptionIssue,int slaHours) {
	
		this.ticketId = ticketId;
		this.ticketType = ticketType;
		this.customerName = customerdetails;
		this.phone=phone;
		this.descriptionIssue = descriptionIssue;
		this.slaHours=slaHours;
	}
	
	public int getSlaHours() {
		return slaHours;
	}

	public void setSlaHours(int slaHours) {
		this.slaHours = slaHours;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	
	public String getDescriptionIssue() {
		return descriptionIssue;
	}
	public void setDescriptionIssue(String descriptionIssue) {
		this.descriptionIssue = descriptionIssue;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketType=" + ticketType + ", customerName=" + customerName
				+ ", phone=" + phone + ", descriptionIssue=" + descriptionIssue + ", slaHours=" + slaHours + "]";
	}
	
	
	
	

}
