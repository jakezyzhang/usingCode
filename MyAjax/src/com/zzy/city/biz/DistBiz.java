package com.zzy.city.biz;

import java.util.List;

import com.zzy.city.entity.District;

public interface DistBiz {
	List<District> getAllDist();
	District getDistById(int distId);
}
