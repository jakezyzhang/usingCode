package com.zzy.city.dao;

import java.util.List;

import com.zzy.city.entity.City;
import com.zzy.city.entity.Province;

public interface CityDao {
	List<City> getAllCityBrief();
	City getCityNameById(int cityId);
	List<City> getCityNameByProvName(String provName);
}
