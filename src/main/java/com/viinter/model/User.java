package com.viinter.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Table(name = "Users")
public class User extends BaseEntity implements Serializable, IUser{
	
	private static final long serialVersionUID = 112L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name = "EMAIL", unique=true)
	private String email;

	@Column(name = "PASSWORD")
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
	
	//				User to Role relationship
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "USER_ROLE_ID")
		private Role role;

		@Override
		public Role getRole() {
			return role;
		}
		
		@Override
		public void setRole(Role role) {
			this.role = role;
		}

	
	
}
