package com.viinter.model;

import java.util.Collection;

public interface IUser extends IBaseEntity {

	int getUserId();

	void setUserId(int userId);

	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);

	String getMobileNumber();

	void setMobileNumber(String mobileNumber);

	String getEmail();

	void setEmail(String email);

	String getPassword();

	void setPassword(String password);

	Role getRole();
	void setRole(Role role);


}