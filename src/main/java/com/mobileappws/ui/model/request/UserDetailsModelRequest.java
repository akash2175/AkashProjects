package com.mobileappws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsModelRequest {
	
	@NotNull(message="First Name can't be Null")
	@NotEmpty(message="This field Cant be empty")
	private String firstName;
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@NotNull(message = "Last Name can't be empty")
	private String lastName;
	@NotNull(message="Email can't be empty")
	@Email
	private String email;
	@NotNull
	@Size(min = 6,max = 10,message = "Password can be minimum 6 character and maximum 10 chacracter")
	private String password;
	

}
