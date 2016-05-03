package com.viinter.exceptions;

@SuppressWarnings("serial")
public class NoRolesAssignedException extends Exception {
	
	public NoRolesAssignedException(){
		super();
	}
	
	public NoRolesAssignedException(String exceptionMessage){
		super(exceptionMessage);
	}
	
	public NoRolesAssignedException(String exceptionMessage, Throwable t) {
        super(exceptionMessage, t);
	}
	
	@Override 
	public String toString() { 
		return super.toString(); 
	}
	
	@Override 
	public String getMessage() { 
		return super.getMessage() + "No Role are Defined"; 
	}
}
