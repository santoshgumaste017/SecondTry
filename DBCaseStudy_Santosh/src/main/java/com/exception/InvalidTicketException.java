package com.exception;

public class InvalidTicketException extends Exception {

	String msg;
	public InvalidTicketException() {
		// TODO Auto-generated constructor stub
	}
	public InvalidTicketException(String msg) {
		this.msg=msg;
	}

}
