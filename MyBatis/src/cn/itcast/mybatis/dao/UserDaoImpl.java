package cn.itcast.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.po.User;

/**
 * dao的接口实现类
 * @author zyloveyy
 *
 */
public class UserDaoImpl implements UserDao{
	//需要向dao类中注入SqlSessionFactory
	//这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById",id);
		
		//释放资源
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//执行插入操作
		sqlSession.insert("test.insertUser", user);
		
		//提交事务
		sqlSession.commit();
		
		//释放资源
		sqlSession.close();
	}

	@Override
	public void deletUser(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//执行删除操作
		sqlSession.delete("test.deletUser",id);
		
		//提交事务
		sqlSession.commit();
		
		//释放资源
		sqlSession.close();
	}

}
