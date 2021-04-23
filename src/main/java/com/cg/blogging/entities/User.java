package com.cg.blogging.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "blog_user")
public class User {
	@Id
	@Column(name = "user_id")
	@SequenceGenerator(allocationSize=1, name="seq1", sequenceName="user_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq1")
	private int userId;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_role")
	private String role;
	
	public User() {
	}

	public User(String password, String role) {
		this.password = password;
		this.role = role;
	}

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
