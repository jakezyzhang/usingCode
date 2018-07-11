package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

import java.util.List;


public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	
	//利用名字搜索商品
	public List<ItemsCustom> findItemsListByName(ItemsQueryVo itemsQueryVo) throws Exception;
}