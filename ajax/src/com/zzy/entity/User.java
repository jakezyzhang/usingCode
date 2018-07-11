package com.zzy.entity;

public class User {
	private String name;
	private String sex;
	private Address  addr;
	public User(String name, String sex, Address addr) {
		super();
		this.name = name;
		this.sex = sex;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	
}
