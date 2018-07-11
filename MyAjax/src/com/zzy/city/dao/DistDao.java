package com.zzy.city.dao;

import java.util.List;

import com.zzy.city.entity.District;

public interface DistDao {
	List<District> getAllDistBrief();
	District getDistNameById(int distId);
	List<District> getDistNameByCityName(String cityName);
	District getDistIdByDistName(String distName);
}
