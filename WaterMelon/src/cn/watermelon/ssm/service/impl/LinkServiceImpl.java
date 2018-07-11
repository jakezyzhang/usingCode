package cn.watermelon.ssm.service.impl;
/**
 * 
 * <p>Title: CustomDateConverter</p>
 * <p>Description:Link的service接口类 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	张子阳
 * @date	2018-4-18
 * @version 1.0
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.watermelon.ssm.mapper.LinkMapper;
import cn.watermelon.ssm.mapper.LinkMapperCustom;
import cn.watermelon.ssm.po.Link;
import cn.watermelon.ssm.po.LinkCustom;
import cn.watermelon.ssm.po.LinkQueryVo;
import cn.watermelon.ssm.service.LinkService;

public class LinkServiceImpl implements LinkService{
	@Autowired
	private LinkMapperCustom linkMapperCustom;
	
	@Autowired
	private LinkMapper linkMapper;
	
	
	@Override
	public void LinkInsert(Link links) throws Exception {
		// TODO Auto-generated method stub
		linkMapper.insert(links);
	}

	@Override
	public List<LinkCustom> findLinkList(LinkQueryVo linkQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return linkMapperCustom.findLinkList(linkQueryVo);
	}

	@Override
	public List<LinkCustom> findLinkShortUrlByLongUrl(LinkQueryVo linkQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return linkMapperCustom.findLinkShortUrlByLongUrl(linkQueryVo);
	}

	@Override
	public List<LinkCustom> findLinkLongtUrlByShortUrl(LinkQueryVo linkQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return linkMapperCustom.findLinkLongtUrlByShortUrl(linkQueryVo);
	}

	

}
