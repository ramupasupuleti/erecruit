package com.viinter.forms;

import java.io.Serializable;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegistrationForm implements Serializable, IRegistrationForm {
private static final long serialVersionUID = 112L;
	
	private String firstName;
	
	private String lastName;
	
	private String mobileNumber;
	
	private String email;

	private String password;
	
	private String confirmPassword;

	/* (non-Javadoc)
	 * @see com.viinter.forms.IRegistrationForm#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}

	/* (non-Javadoc)
	 * @see com.viinter.forms.IRegistrationForm#setFirstName(java.lang.String)
	 */
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/* (non-Javadoc)
	 * @see com.viinter.forms.IRegistrationForm#getLastName()
	 */
	@Override
	public String getLastName() {
		return lastName;
	}

	/* (non-Javadoc)
	 * @see com.viinter.forms.IRegistrationForm#setLastName(java.lang.String)
	 */
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/* (non-Javadoc)
	 * @see com.viinter.forms.IRegistrationForm#getMobileNumber()
	 */
	@Override
	public String getMobileNumber() {
		return mobileNumber;
	}

	/* (non-Javadoc)
	 * @see com.viinter.forms.IRegistrationForm#setMobileNumber(java.lang.String)
	 */
	@Override
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/* (non-Javadoc)
	 * @see com.viinter.forms.IRegistrationForm#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see com.viinter.forms.IRegistrationForm#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see com.viinter.forms.IRegistrationForm#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/* (non-Javadoc)
	 * @see com.viinter.forms.IRegistrationForm#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see com.viinter.forms.IRegistrationForm#getConfirmPassword()
	 */
	@Override
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/* (non-Javadoc)
	 * @see com.viinter.forms.IRegistrationForm#setConfirmPassword(java.lang.String)
	 */
	@Override
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	

}
