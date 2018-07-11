package com.zzy.city.dao;

import java.util.List;

import com.zzy.city.entity.Province;

public interface ProvDao {
	List<Province> getAllProvBrief();
	Province getProvNameById(int provId);
}
