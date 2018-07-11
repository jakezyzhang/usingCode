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
	/**��ȡ���ݿ����Ӷ���*/
	public Connection getConnection(){
		conn = null;
		//��ȡ���Ӳ������쳣
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
			System.err.println("�޷��������ݿ����ӣ�");
		}
		return conn;
	}
	/**�ر����ݿ�����*/
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		//rs��Ϊ�գ���ر�
		if(rs != null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//pstmt��Ϊ�գ���ر�
		if(pstmt != null){
			try{
				pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//conn��Ϊ�գ���ر�
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
	/**��ѯ���ݿ�*/
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
	/**�޸����ݿ�*/
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
