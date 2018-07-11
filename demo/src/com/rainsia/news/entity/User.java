package com.rainsia.news.entity;

/*
 * �û� ʵ����
 * @author
 */

public class User {

	private int id;
	private String name;
	private String displayName;
	private String email;
	private String password;
	private int role;
	
	public static final int SUPER_ADMIN = 1;
	public static final int ADMIN = 2;
	public static final int ROLE_NORMAL = 3;
	
	public User(int id, String name, String displayName, String password,
			int role) {
		this.id = id;
		this.name = name;
		this.displayName = displayName;
		//this.email = email;
		this.password = password;
		this.role = role;
	}
	
	

	public User(String name, String displayName, String password, int role) {
		this.name = name;
		this.displayName = displayName;
		//this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String name, String displayName, String email, String password) {
		this.name = name;
		this.displayName = displayName;
		this.email = email;
		this.password = password;
		this.role = ROLE_NORMAL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
