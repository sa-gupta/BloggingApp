package com.cg.blogging.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
/**
 * <h1>User Class</h1>
 * <p>
 * This class is for creating a user
 * by using the following parameters.
 * Describes the role of the user also.
 *   
 * @author SKSSS
 *
 */
@Entity
@Table(name = "user_table")
public class User {
	@Id
	@Column(name = "user_id")
	@SequenceGenerator(allocationSize=1, name="seq1", sequenceName="user_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq1")
	private int userId;
	@Column(name = "user_password")
	@NotBlank
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
	message = "password must be 8 to 16 characters long and consist of at least :"
			+ " one digit, one lowercase alphabet, one Uppercase alphabet and one special "
			+ "character in the bracket with No white space allowed.")
	private String password;
	@Column(name = "user_role")
	private String role;
	
	/**
	 * User class constructor.
	 */
	public User() {
	}
	
	/**
	 * <p>
	 * User class constructor
	 * to create a user 
	 * by passing these arguments.  
	 * 
	 * @param password
	 * @param role
	 */
	public User(String password, String role) {
		this.password = password;
		this.role = role;
	}
	
	/**
	 * <p>
	 * User class constructor
	 * to create a user 
	 * by passing these arguments.
	 *  
	 * @param userId
	 * @param password
	 * @param role
	 */
	public User(int userId, String password, String role) {
		this.userId = userId;
		this.password = password;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

	
}
