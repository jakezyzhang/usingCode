	package com.zzy.util;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	
	
	/**
	 * 数库连接与关闭工具类。
	 */
	public abstract class BaseDao {
		private static String driver = 
				"driverclass: com.mysql.jdbc.Driver";
		private static String url = 
			"connection URL: jdbc:mysql://127.0.0.1:3306/test";
		private static String user = "root"; 
		private static String password = "000000"; 
		
		protected Connection conn;
		protected PreparedStatement pstmt;
		protected ResultSet rs;
		
		/**
		 * 获数库连接对象。
		 */
		public Connection getConnection() {
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);			
			} catch (Exception e) {
				e.printStackTrace();// 异常处
			}
			return conn;// 返回连接对象
		}
		/**
		 * 关闭数库连接。
		 * @param conn 数库连接
		 * @param stmt Statement对象
		 * @param rs 结果集
		 */
		public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
			// 若结果集对象为空，则关闭
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 若Statement对象为空，则关闭
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void closeAll() {
			closeAll(this.conn, this.pstmt, this.rs);
		}
		
		/**
		 * 增删改
		 * @param sql sql语
		 * @param params 数数组
		 * @return 执行结果
		 */
		public int exceuteUpdate(String sql, Object...params){
	
			this.getConnection();
			try {
				if(conn != null && conn.isClosed() == false) {
					pstmt = conn.prepareStatement(sql);
					for(int i = 0;i < params.length;i++){
						pstmt.setObject(i + 1, params[i]);	
					}
					return pstmt.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeAll();
			}
			
			return -1;
		}
		
		public ResultSet executeQuery(String sql, Object...params) {
			this.getConnection();
			try {
				if(conn != null && conn.isClosed() == false) {
					pstmt = conn.prepareStatement(sql);
					for(int i = 0;i < params.length;i++){
						pstmt.setObject(i + 1, params[i]);	
					}
					return pstmt.executeQuery();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	}
