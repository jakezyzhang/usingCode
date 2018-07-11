package cn.watermelon.ssm.mapper2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.watermelon.ssm.mapper.LinkMapperCustom;
import cn.watermelon.ssm.po.LinkCustom;
import cn.watermelon.ssm.po.LinkQueryVo;

public class LinkMapperCustomTest {
	private ApplicationContext applicationContext;
	
	private LinkMapperCustom linkMapperCustom;

	//在setUp这个方法得到spring容器
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		linkMapperCustom = (LinkMapperCustom) applicationContext.getBean("linkMapperCustom");
	}
	@Test
	public void testFindLinkList() throws Exception {
		LinkQueryVo linkQueryVo = new LinkQueryVo();
		List<LinkCustom> listLink = linkMapperCustom.findLinkList(linkQueryVo);
		System.out.println(linkQueryVo.getLinksCustom().getLinklong());
	}

}
