package com.zzy.city.biz;

import java.util.List;

import com.zzy.city.entity.Province;

public interface ProvBiz {
	List<Province> getAllProv();
	Province getProvById(int provId);
}
