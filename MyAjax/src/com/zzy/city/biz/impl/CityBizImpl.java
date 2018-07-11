package com.zzy.city.biz.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.zzy.city.entity.City;
import com.zzy.city.biz.CityBiz;
import com.zzy.city.biz.util.BizUtil;
import com.zzy.city.dao.CityDao;
import com.zzy.city.entity.City;

public class CityBizImpl implements CityBiz{

	
	@Override
	public List<City> getAllCity() {
		
		// TODO Auto-generated method stub
		CityDao cityDao = null;
		try {
			cityDao = (CityDao) BizUtil.getDialectedDao(CityDao.class);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(cityDao != null) {
			List<City> allcityBrief = cityDao.getAllCityBrief();
			return allcityBrief;
		}
		
		return null;
	}

	@Override
	public City getCityById(int cityId) {
		// TODO Auto-generated method stub
		CityDao cityDao = null;
		try {
			cityDao = (CityDao) BizUtil.getDialectedDao(CityDao.class);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
