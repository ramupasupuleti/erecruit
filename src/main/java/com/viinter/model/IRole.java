
package com.viinter.model;

public interface IRole {

	Integer getId();

	 void setId(Integer id);

	 String getName();

	 void setName(String name);
	 
	 int hashCode();

	 String toString();
	 
	 User getUser();

	 void setUser(User user);

}

