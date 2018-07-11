package com.zzy.city.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzy.city.dao.CityDao;
import com.zzy.city.entity.City;
import com.zzy.city.entity.Province;
import com.zzy.dao.base.BaseDao;
import com.zzy.dao.base.RSProcessor;

public class CityDaoImpl extends BaseDao implements CityDao{
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getAllCityBrief() {
		// TODO Auto-generated method stub
		String sql = "select CityID,CityName,ProvID,CitySort from city";
		
		RSProcessor cityRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				List<City> cityList = new ArrayList<City>();
				while(rs.next()){
					int cityId = rs.getInt("CityID");
					String cityName = rs.getString("CityName");
					int provId = rs.getInt("ProvID");
					int citySort = rs.getInt("CitySort");
					
					City city = new City(cityId, cityName, provId, citySort);
					cityList.add(city);
				}
				return cityList;
			}
		};
		
		return (List<City>) executeQuery(cityRS, sql);
	}

	
	
	public City getCityNameById(int cityId){
		String sql = "select * from city where provID = ?";
		
		RSProcessor cityRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				City city = null;
				if(rs.next()){
					int cityId = rs.getInt("CityID");
					String cityName = rs.getString("CityName");
					int provId = rs.getInt("ProvID");
					int citySort = rs.getInt("CitySort");
					city = new City(cityId, cityName, provId, citySort);
				}
				return city;
			}
		};
		return (City)executeQuery(cityRS, sql, cityId);
	}

	public List<City> getCityNameByProvName(String provName){
		String sql = "select * from city where ProvID = (select ProvID from province where ProvName= ?)";
		Object[] params = {provName};
		RSProcessor cityRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				List<City> cityList = new ArrayList<City>();
				while(rs.next()){
					int cityId = rs.getInt("CityID");
					String cityName = rs.getString("CityName");
					int provId = rs.getInt("ProvID");
					int citySort = rs.getInt("CitySort");
				
					City city = new City(cityId, cityName, provId, citySort);
					cityList.add(city);
				}
				return cityList;
			}
		};
		
		return (List<City>)this.executeQuery(cityRS, sql, params);
	}

}
