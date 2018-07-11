package com.zzy.city.entity;

public class Province {
	private int provId;
	private String provName;
	private int provSort;
	private String provRemark;
	public Province() {
		// TODO Auto-generated constructor stub
	}
	public Province(int provId, String provName) {
		super();
		this.provId = provId;
		this.provName = provName;
	}
	public Province(String provName, int provSort, String provRemark) {
		super();
		this.provName = provName;
		this.provSort = provSort;
		this.provRemark = provRemark;
	}
	public Province(int provId, String provName, int provSort, String provRemark) {
		super();
		this.provId = provId;
		this.provName = provName;
		this.provSort = provSort;
		this.provRemark = provRemark;
	}
	public int getProvId() {
		return provId;
	}
	public void setProvId(int provId) {
		this.provId = provId;
	}
	public String getProvName() {
		return provName;
	}
	public void setProvName(String provName) {
		this.provName = provName;
	}
	public int getProvSort() {
		return provSort;
	}
	public void setProvSort(int provSort) {
		this.provSort = provSort;
	}
	public String getProvRemark() {
		return provRemark;
	}
	public void setProvRemark(String provRemark) {
		this.provRemark = provRemark;
	}
	
}
