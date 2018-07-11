package cn.watermelon.ssm.mapper;
/**
 * 
 * 这是插入数据库的测试代码
 * 
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.watermelon.ssm.po.Link;

public class LinkMapperTest {

	private ApplicationContext applicationContext;
	
	private LinkMapper linkMapper;

	//在setUp这个方法得到spring容器
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		linkMapper = (LinkMapper) applicationContext.getBean("linkMapper");
	}
	
	// 这是插入数据库的测试代码
	@Test
	public void testInsert() {
		Link link = new Link();
		link.setLinklong("www.baidu2.com");
		link.setLinkshort("adasdq");
		linkMapper.insert(link);
	}

}
