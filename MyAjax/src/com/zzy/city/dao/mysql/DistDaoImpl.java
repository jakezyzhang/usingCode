package com.zzy.city.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzy.city.dao.DistDao;
import com.zzy.city.entity.District;
import com.zzy.dao.base.BaseDao;
import com.zzy.dao.base.RSProcessor;

public class DistDaoImpl extends BaseDao implements DistDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<District> getAllDistBrief() {
		// TODO Auto-generated method stub
		String sql = "select * from district";
		
		RSProcessor distRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				List<District> distList = new ArrayList<District>();
				while(rs.next()){
					int distId = rs.getInt("DistId");
					String distName = rs.getString("DistName");
					int cityId = rs.getInt("CityID");
					int distSort = rs.getInt("DistSort");
					
					District district = new District(distId, distName, cityId, distSort);
					distList.add(district);
				}
				return distList;
			}
		};
		return (List<District>) executeQuery(distRS, sql);
	}

	@Override
	public District getDistNameById(int distId) {
		// TODO Auto-generated method stub
		String sql = "select DistName from district where DistId =?";
		
		RSProcessor distRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				District district = null;
				if(rs.next()){
					int distId = rs.getInt("DistId");
					String distName = rs.getString("DistName");
					district = new District(distId, distName);
				}
				return district;
			}
		};
		
		return (District)executeQuery(distRS, sql, distId);
	}
	
	public List<District> getDistNameByCityName(String cityName){
		String sql ="select * from district where CityID = (select CityId from city where CityName= ?)";
		Object[] params = {cityName};
		RSProcessor distRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				List<District> distList = new ArrayList<District>();
				while(rs.next()){
					int distId = rs.getInt("DistId");
					String distName = rs.getString("DistName");
					int cityId = rs.getInt("CityID");
					int distSort = rs.getInt("DistSort");
					
					District district = new District(distId, distName, cityId, distSort);
					distList.add(district);
				}
				return distList;
			}
		};
		return (List<District>)this.executeQuery(distRS, sql, params);
	}
	public District getDistIdByDistName(String distName){
		String sql ="select * from district where CityID = (select CityId from city where CityName= ?)";
		Object[] params = {distName};
		RSProcessor distRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				District dist = null;
				if(rs.next()){
					int distId = rs.getInt("DistId");
					String distName = rs.getString("DistName");
					int cityId = rs.getInt("CityID");
					int distSort = rs.getInt("DistSort");
					
					dist = new District(distId,distName, cityId, distSort);
				}
				return dist;
			}
		};
		
		
		return (District)this.executeQuery(distRS, sql, params);
	}
}
