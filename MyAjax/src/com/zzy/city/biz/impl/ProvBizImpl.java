package com.zzy.city.biz.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.zzy.city.biz.ProvBiz;
import com.zzy.city.biz.util.BizUtil;
import com.zzy.city.dao.CityDao;
import com.zzy.city.dao.ProvDao;
import com.zzy.city.entity.City;
import com.zzy.city.entity.Province;

public class ProvBizImpl implements ProvBiz{

	@Override
	public List<Province> getAllProv() {
		// TODO Auto-generated method stub
		ProvDao provDao = null;
		try {
			provDao = (ProvDao) BizUtil.getDialectedDao(ProvDao.class);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(provDao != null) {
			List<Province> allprovBrief = provDao.getAllProvBrief();
			return allprovBrief;
		}
		
		return null;
	}

	@Override
	public Province getProvById(int provId) {
		// TODO Auto-generated method stub
		ProvDao provDao = null;
		try {
			provDao = (ProvDao) BizUtil.getDialectedDao(ProvDao.class);
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
