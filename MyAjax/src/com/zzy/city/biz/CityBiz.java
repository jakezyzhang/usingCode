package com.zzy.city.biz;

import java.util.List;

import com.zzy.city.entity.City;

public interface CityBiz {
	List<City> getAllCity();
	City getCityById(int cityId);
}
