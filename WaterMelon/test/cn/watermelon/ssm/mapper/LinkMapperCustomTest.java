package cn.watermelon.ssm.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.watermelon.ssm.po.LinkCustom;
import cn.watermelon.ssm.po.LinkQueryVo;
/**
 * 
 * 这是查询数据库中现在有哪些长链接和短链接和
 * 通过长链接判断数据库中是否已有匹配的短链接和
 * 通过短链接判断数据库中与之匹配的长链接的测试代码
 * @author zyloveyy
 *
 */
public class LinkMapperCustomTest {

	private ApplicationContext applicationContext;
	
	private LinkMapperCustom linkMapperCustom;

	//在setUp这个方法得到spring容器
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		linkMapperCustom = (LinkMapperCustom) applicationContext.getBean("linkMapperCustom");
	}
	
	
	//通过长链接判断数据库中是否已有匹配的短链接的测试
	@Test
	public void testFindLinkShortUrlByLongUrl() throws Exception {
		LinkCustom links = new LinkCustom();
		links.setLinklong("www.baidu.com");
		LinkQueryVo linkQueryVo = new LinkQueryVo();
		linkQueryVo.setLinksCustom(links);
		
		List<LinkCustom> findLinkShortUrl = linkMapperCustom.findLinkShortUrlByLongUrl(linkQueryVo);
		System.out.println(findLinkShortUrl);
	}
	
	//通过短链接判断数据库中与之匹配的长链接的测试代码
	@Test
	public void testfindLinkLongtUrlByShortUrl() throws Exception {
		LinkCustom links = new LinkCustom();
		links.setLinkshort("fqEfuy");
		LinkQueryVo linkQueryVo = new LinkQueryVo();
		linkQueryVo.setLinksCustom(links);
		
		List<LinkCustom> findLinkLongUrl = linkMapperCustom.findLinkLongtUrlByShortUrl(linkQueryVo);
		System.out.println(findLinkLongUrl);
	}

}
