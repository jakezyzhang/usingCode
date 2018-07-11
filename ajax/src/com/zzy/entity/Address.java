package com.zzy.entity;

public class Address {
	private int id;
	private String addr1;
	private String addr2;
	public Address(int id, String addr1, String addr2) {
		super();
		this.id = id;
		this.addr1 = addr1;
		this.addr2 = addr2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
}
