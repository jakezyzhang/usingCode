package com.zzy.city.biz.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.zzy.city.biz.DistBiz;
import com.zzy.city.biz.util.BizUtil;
import com.zzy.city.dao.CityDao;
import com.zzy.city.dao.DistDao;
import com.zzy.city.entity.City;
import com.zzy.city.entity.District;

public class DistBizImpl implements DistBiz{

	@Override
	public List<District> getAllDist() {
		// TODO Auto-generated method stub
		DistDao distDao = null;
		try {
			distDao = (DistDao) BizUtil.getDialectedDao(DistDao.class);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(distDao != null) {
			List<District> alldistBrief = distDao.getAllDistBrief();
			return alldistBrief;
		}
		
		return null;
	}

	@Override
	public District getDistById(int distId) {
		// TODO Auto-generated method stub
		DistDao distDao = null;
		try {
			distDao = (DistDao) BizUtil.getDialectedDao(DistDao.class);
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
