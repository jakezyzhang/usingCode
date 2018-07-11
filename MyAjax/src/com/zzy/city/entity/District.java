package com.zzy.city.entity;

public class District {
	private int distId;
	private String distName;
	private int cityId;
	private int distSort;
	private String cityName;
	public District() {
		// TODO Auto-generated constructor stub
	}
	public District(int distId, String distName, int cityId, int distSort, String cityName) {
		super();
		this.distId = distId;
		this.distName = distName;
		this.cityId = cityId;
		this.distSort = distSort;
		this.cityName = cityName;
	}
	public District(String distName, int cityId, int distSort, String cityName) {
		super();
		this.distName = distName;
		this.cityId = cityId;
		this.distSort = distSort;
		this.cityName = cityName;
	}
	public District(int distId, String distName, int cityId, int distSort) {
		super();
		this.distId = distId;
		this.distName = distName;
		this.cityId = cityId;
		this.distSort = distSort;
	}
	
	public District(int distId, String distName) {
		super();
		this.distId = distId;
		this.distName = distName;
	}
	public int getDistId() {
		return distId;
	}
	public void setDistId(int distId) {
		this.distId = distId;
	}
	public String getDistName() {
		return distName;
	}
	public void setDistName(String distName) {
		this.distName = distName;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getDistSort() {
		return distSort;
	}
	public void setDistSort(int distSort) {
		this.distSort = distSort;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	
}
