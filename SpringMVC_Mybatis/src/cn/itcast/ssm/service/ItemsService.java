package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

/**
 * 
 * <p>Title: ItemsService</p>
 * <p>Description:商品管理service </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-13下午3:48:09
 * @version 1.0
 */
public interface ItemsService {
	
	/**
	 * 
	 * @param id 查询商品的id
	 * @author zyloveyy
	 */
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据id查询商品信息
	
	
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	/**
	 * 
	 * @param id 修改商品的id
	 * @param itemsCustom 修改商品信息
	 */
	//修改商品信息
	
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	
	/**
	 * 
	 * 根据名字查询商品信息
	 */
	
	public List<ItemsCustom> selectItemsByName(ItemsQueryVo itemsQuery) throws Exception;

}
