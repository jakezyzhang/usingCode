package com.zzy.city.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzy.city.dao.ProvDao;
import com.zzy.city.entity.Province;
import com.zzy.dao.base.BaseDao;
import com.zzy.dao.base.RSProcessor;

public class ProvDaoImpl extends BaseDao implements ProvDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<Province> getAllProvBrief() {
		// TODO Auto-generated method stub
		String sql = "select ProvID,ProvName,ProvSort,ProvRemark from province";
		
		RSProcessor provRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				List<Province> provList = new ArrayList<Province>();
				while(rs.next()){
					int provId = rs.getInt("ProvID");
					String provName = rs.getString("ProvName");
					int provSort = rs.getInt("ProvSort");
					String provRemark = rs.getString("ProvRemark");
					
					Province province = new Province(provId, provName, provSort, provRemark);
					provList.add(province);
				}
				return provList;
			}
		};
		return (List<Province>) executeQuery(provRS, sql);
	}

	@Override
	public Province getProvNameById(int provId) {
		// TODO Auto-generated method stub
		String sql="select * from province where ProvID = ?";
		
		RSProcessor provRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Province province = null;
				if(rs.next()){
					int provId= rs.getInt("ProvID");
					String provName = rs.getString("ProvName");
					int provSort = rs.getInt("ProvSort");
					String provRemark = rs.getString("ProvRemark");
					 province = new Province(provId, provName,provSort,provRemark);
				}
				return province;
			}
		};
		
		return (Province)executeQuery(provRS, sql, provId);
	}

}
