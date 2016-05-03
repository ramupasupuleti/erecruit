package com.viinter.exceptions;

@SuppressWarnings("serial")
public class RoleNotFoundException extends Exception {
	
	String roleId;
	
	public RoleNotFoundException(){
		super();
	}
	
	public RoleNotFoundException(String exceptionMessage){
		super(exceptionMessage);
	}
	
	public RoleNotFoundException(String exceptionMessage, String roleId){
		super(exceptionMessage);
		this.roleId = roleId;
	}
	
	public RoleNotFoundException(String exceptionMessage, String roleId, Throwable t) {
        super(exceptionMessage, t);
        this.roleId = roleId;
	}
	
	@Override 
	public String toString() { 
		return super.toString(); 
	}
	
	@Override 
	public String getMessage() { 
		return super.getMessage() + " for RoleId :" + roleId; 
	}
	
	public String getRoleId() { 
		return roleId; 
	}
}
