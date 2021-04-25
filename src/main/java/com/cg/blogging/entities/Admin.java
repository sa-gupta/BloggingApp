package com.cg.blogging.entities;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 * <h1>Admin Class</h1>
 * <p>
 * This class details regarding 
 * the administrators of this 
 * application.
 * 
 * @author SKSSS
 *
 */
@Entity
@Table
public class Admin {
	@Id
//	@GeneratedValue
	private int userId;
	@NotBlank 
	@Pattern(regexp = "^[a-zA-Z\\s]{2,30}$", message = "adminName must be 4 to 20 characters long with first letter alphabet")
	private String adminName;
	
	private String adminContact;
	@NotBlank
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#%&*$])(?=\\S+$).{8,16}$", 
			message = "password must be 8 to 16 characters long and consist of at least :"
					+ " one digit, one lowercase alphabet, one Uppercase alphabet and one special character in the bracket with No white space allowed.")
	private String password;
	
	/**
	 * Admin class constructor.
	 */
	public Admin() {
		
	}
	
	/**
	 * <p>
	 * Admin class constructor
	 * to create a admin
	 * by passing these arguments.
	 * 
	 * @param userId
	 * @param adminName
	 * @param adminContact
	 * @param password
	 */
	public Admin(int userId, String adminName, String adminContact, String password) {
		this.userId = userId;
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.password = password;
	}
	
	/**
	 * <p>
	 * Admin class constructor
	 * to create a admin
	 * by passing these arguments.
	 * 
	 * @param adminName
	 * @param adminContact
	 * @param password
	 */
	public Admin(String adminName, String adminContact, String password) {
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	@Override
	public String toString() {
		return "Admin [userId=" + userId + ", adminName=" + adminName + ", adminContact=" + adminContact + "]";
	}
	
	
}
