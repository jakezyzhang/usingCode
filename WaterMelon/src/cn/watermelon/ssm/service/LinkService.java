package cn.watermelon.ssm.service;
/**
 * 
 * <p>Title: CustomDateConverter</p>
 * <p>Description:Link的service类 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	张子阳
 * @date	2018-4-18
 * @version 1.0
 */
import java.util.List;

import cn.watermelon.ssm.po.Link;
import cn.watermelon.ssm.po.LinkCustom;
import cn.watermelon.ssm.po.LinkQueryVo;

public interface LinkService {
	//插入长链接和短链接
	public void LinkInsert(Link links) throws Exception;
	
	//查找链接的信息
	public List<LinkCustom> findLinkList(LinkQueryVo linkQueryVo) throws Exception;
	
	//通过长链接查找到短链接
	public List<LinkCustom> findLinkShortUrlByLongUrl(LinkQueryVo linkQueryVo) throws Exception;

	//通过短链接查找到长链接
	public List<LinkCustom> findLinkLongtUrlByShortUrl(LinkQueryVo linkQueryVo) throws Exception;
}
