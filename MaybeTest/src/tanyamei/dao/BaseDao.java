package tanyamei.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class BaseDao {
	//private static String driver = "com.mysql.jdbc.Driver";
	private static String url = 
		"jdbc:mysql://localhost:3306/vote?useUnicode=true&characterEncoding=utf-8";
	private static String user = "root"; 
	private static String password = "root"; 
	
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	/**获取数据库连接对象*/
	public Connection getConnection(){
		conn = null;
		//获取连接并捕获异常
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			//pstmt = conn.prepareStatement(sql);
			//rs = pstmt.executeQuery();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(conn == null){
			System.err.println("无法建立数据库连接！");
		}
		return conn;
	}
	/**关闭数据库连接*/
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		//rs不为空，则关闭
		if(rs != null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//pstmt不为空，则关闭
		if(pstmt != null){
			try{
				pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//conn不为空，则关闭
		if(conn != null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public void closeAll(Connection conn, PreparedStatement pstmt) {
		closeAll(conn, pstmt, null);
	}
	/**查询数据库*/
	public ResultSet executeQuery(String sql){
		try{
			conn = this.getConnection();
			if(conn != null && conn.isClosed() == false){
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	/**修改数据库*/
	public int executeUpdate(String sql){
		int result = 0;
		conn = this.getConnection();
		try{
			if(conn != null && conn.isClosed() == false){
				pstmt = conn.prepareStatement(sql);
				result = pstmt.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeAll(conn,pstmt);
		}
		return result;
	}
}
