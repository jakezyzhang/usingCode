package cn.watermelon.ssm.mapper;
/**
 * 
 * <p>Title: CustomDateConverter</p>
 * <p>Description:mapper的扩展 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	张子阳
 * @date	2018-4-18
 * @version 1.0
 */
import java.util.List;

import cn.watermelon.ssm.po.LinkCustom;
import cn.watermelon.ssm.po.LinkQueryVo;

public interface LinkMapperCustom {
	//查询数据库中现在有哪些长链接和短链接
	public List<LinkCustom> findLinkList(LinkQueryVo linkQueryVo) throws Exception;

	//通过长链接判断数据库中是否已有匹配的短链接
	public List<LinkCustom> findLinkShortUrlByLongUrl(LinkQueryVo linkQueryVo) throws Exception;
	
	//通过短链接判断数据库中与之匹配的长链接
	public List<LinkCustom> findLinkLongtUrlByShortUrl(LinkQueryVo linkQueryVo) throws Exception;
}
