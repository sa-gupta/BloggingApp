package com.cg.blogging.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")
public class Admin {
	@Id
//	@GeneratedValue
	private int userId;
	private String adminName;
	private String adminContact;
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(int userId, String adminName, String adminContact, String password) {
		this.userId = userId;
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.password = password;
	}
	
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
