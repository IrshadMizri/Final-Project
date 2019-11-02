package com.ust.model;

public class User {
	
	private int userId;
	private String username;
	private String password;
	private int roleid;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public User(int userId, String username, String password, int roleid) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.roleid = roleid;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", roleid=" + roleid
				+ "]";
	}

	
	
	
	

}
