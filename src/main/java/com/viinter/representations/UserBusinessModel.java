package com.viinter.representations;

import java.io.Serializable;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserBusinessModel implements Serializable, IUserBusinessModel{
	
	private static final long serialVersionUID = 112L;
	
	private int userId;
	
	private String firstName;
	
	private String lastName;
	
	private String mobileNumber;
	
	private String email;

	private String password;
	
	
	/* (non-Javadoc)
	 * @see com.erecruitment.model.IUser#getUserId()
	 */
	@Override
	public int getUserId() {
		return userId;
	}
	/* (non-Javadoc)
	 * @see com.erecruitment.model.IUser#setUserId(int)
	 */
	@Override
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/* (non-Javadoc)
	 * @see com.erecruitment.model.IUser#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}
	/* (non-Javadoc)
	 * @see com.erecruitment.model.IUser#setFirstName(java.lang.String)
	 */
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/* (non-Javadoc)
	 * @see com.erecruitment.model.IUser#getLastName()
	 */
	@Override
	public String getLastName() {
		return lastName;
	}
	/* (non-Javadoc)
	 * @see com.erecruitment.model.IUser#setLastName(java.lang.String)
	 */
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/* (non-Javadoc)
	 * @see com.erecruitment.model.IUser#getMobileNumber()
	 */
	@Override
	public String getMobileNumber() {
		return mobileNumber;
	}
	/* (non-Javadoc)
	 * @see com.erecruitment.model.IUser#setMobileNumber(java.lang.String)
	 */
	@Override
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/* (non-Javadoc)
	 * @see com.erecruitment.model.IUser#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}
	/* (non-Javadoc)
	 * @see com.erecruitment.model.IUser#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	/* (non-Javadoc)
	 * @see com.erecruitment.model.IUser#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}
	/* (non-Javadoc)
	 * @see com.erecruitment.model.IUser#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
}
