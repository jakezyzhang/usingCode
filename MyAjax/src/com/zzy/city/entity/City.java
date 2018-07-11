package com.zzy.city.entity;

public class City {
	private int cityId;
	private String cityName;
	private int provId;
	private int citySort;
	private String provName;
	public City() {
		// TODO Auto-generated constructor stub
	}
	public City(int cityId, String cityName, int provId, int citySort, String provName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.provId = provId;
		this.citySort = citySort;
		this.provName = provName;
	}
	public City(String cityName, int provId, int citySort, String provName) {
		super();
		this.cityName = cityName;
		this.provId = provId;
		this.citySort = citySort;
		this.provName = provName;
	}
	
	public City(int cityId, String cityName, int provId, int citySort) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.provId = provId;
		this.citySort = citySort;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getProvId() {
		return provId;
	}
	public void setProvId(int provId) {
		this.provId = provId;
	}
	public int getCitySort() {
		return citySort;
	}
	public void setCitySort(int citySort) {
		this.citySort = citySort;
	}
	public String getProvName() {
		return provName;
	}
	public void setProvName(String provName) {
		this.provName = provName;
	}
	
	
	
}
